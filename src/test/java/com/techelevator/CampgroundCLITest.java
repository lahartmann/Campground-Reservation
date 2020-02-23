package com.techelevator;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class CampgroundCLITest {

	private static SingleConnectionDataSource dataSource;
	private CampgroundCLI myCLI;
	private JdbcTemplate jdbcTemplate;
	private JDBCParkDAO parkDAO;
	private JDBCCampgroundDAO campgroundDAO;
	private JDBCSiteDAO siteDAO;
	private JDBCReservationDAO reservationDAO;
	List<Park> parkNames = new ArrayList<Park>();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/campground");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		
		dataSource.setAutoCommit(false);

		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dataSource.destroy();
	}

	@Before
	public void setUp() throws Exception {
		
		jdbcTemplate = new JdbcTemplate(dataSource);
		myCLI = new CampgroundCLI(dataSource);
		parkDAO = new JDBCParkDAO(dataSource);
		campgroundDAO = new JDBCCampgroundDAO(dataSource);
		siteDAO = new JDBCSiteDAO(dataSource);
		reservationDAO = new JDBCReservationDAO(dataSource);
		parkNames = parkDAO.getAllParks();
	}
	

	@After
	public void tearDown() throws Exception {
		dataSource.getConnection().rollback();
	}
	
	@Test
	public void test_main_menu_quit_option() {	
		String firstOption = "Q";

		if (firstOption.equalsIgnoreCase("Q")) {
			System.out.println("Thank you for computing, have a pleasant day!");
			
		} else if (Integer.parseInt(firstOption) <= parkNames.size()) {
			System.out.println("Goes to Menu 2");
			} else {
			System.out.println("Please make a valid selection");
		}
		
	}
	
	@Test
	public void test_main_menu_invalid_option() {	
		String firstOption = "8";

		if (firstOption.equalsIgnoreCase("Q")) {
			System.out.println("Thank you for computing, have a pleasant day!");
			
		} else if (Integer.parseInt(firstOption) <= parkNames.size()) {
			System.out.println("Goes to Menu 2");
			} else {
			System.out.println("Please make a valid selection");
		}
	}
	@Test
	public void test_print_header() {	
		System.out.println("Welcome to the Campground Booking App");
		
		parkNames = parkDAO.getAllParks();
		
		for (int i = 0; i < parkNames.size(); i++) {
			int optionNum = i+1;
			
			System.out.println(optionNum + ") " + (parkNames.get(i).getPark_id() 
					+ " " + " " + parkNames.get(i).getName()));
			}
			System.out.println("Select a park number for futher details or Q to quit");
		
	}
	@Test
	public void test_menu_four_header() {
	printMenuFourHeader();
	}
	
	
private void printMenuFourHeader()	{
	LocalDate startLocalDate = LocalDate.of(2020, 12, 18);
	LocalDate endLocalDate = LocalDate.of(2020, 12, 20);
	List<Site> siteList;
	String thirdOption = "3";
	Campground displayCampground = new Campground();
	displayCampground.setDailyFee(new BigDecimal(35));
	System.out.println("Available camp sites:");
	System.out.println("Site # 	 Max Occup. 	Accessible	RV Length	Utilities	Cost of Stay");
	
	
	
	long lengthOfStay = ChronoUnit.DAYS.between(startLocalDate, endLocalDate);
	
	
	siteList = siteDAO.getAvailableSitesByReservationDate
			(Integer.parseInt(thirdOption), 
			startLocalDate, 
			endLocalDate);
	
		
	for (int i = 0; i < siteList.size(); i++) {
	System.out.println(siteList.get(i).getSiteNumber()
			+ " " + " 		" + siteList.get(i).getMaxOccupancy()
			+ " " + " 		" + siteList.get(i).isAccessible()
			+ " " + "		" + siteList.get(i).getMaxRvLength()
			+ " " + " 		" + siteList.get(i).isUtilities()
			+ " " + " 		" + displayCampground.getDailyFee().longValue() * lengthOfStay);		
		}
	}
}
