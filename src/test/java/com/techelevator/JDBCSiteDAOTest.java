package com.techelevator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class JDBCSiteDAOTest {

	private static SingleConnectionDataSource dataSource;
	private SiteDAO dao;
	private JdbcTemplate jdbcTemplate;
	private Site mySite;
	private ReservationDAO resoDAO;
	private Reservation myReso;
	
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
		
		dao = new JDBCSiteDAO(dataSource);
		mySite = new Site();
		resoDAO = new JDBCReservationDAO(dataSource);
		myReso = new Reservation();
		
	}
	

	@After
	public void tearDown() throws Exception {
		dataSource.getConnection().rollback();
	}
	
	@Test
	public void test_get_and_set_site_Id() {	
		int siteId = 12;
		mySite.setSiteId(siteId);
		assertEquals(12, mySite.getSiteId());
		
	}
	
	@Test
	public void test_get_and_set_campground_Id() {	
		int campgroundId = 12;
		mySite.setCampgroundID(campgroundId);
		assertEquals(12, mySite.getCampgroundID());
		
	}
	
	@Test
	public void test_get_and_set_site_number() {	
		int siteNumber = 12;
		mySite.setSiteNumber(siteNumber);
		assertEquals(12, mySite.getSiteNumber());	
	}
	
	@Test
	public void test_get_and_set_occupancy() {	
		int maxOccupancy = 8;
		mySite.setMaxOccupancy(maxOccupancy);;
		assertEquals(8, mySite.getMaxOccupancy());
		
	}
	
	@Test
	public void test_get_and_set_accessible() {	
		boolean accessible = true;
		mySite.setAccessible(accessible);
		assertEquals("Yes", mySite.isAccessible());
		
		
		mySite.setAccessible(!accessible);
		assertEquals("No", mySite.isAccessible());
	}
	
	@Test
	public void test_get_and_set_rv_length() {	
		String maxRvLength = "0";
		mySite.setMaxRvLength(maxRvLength);
		assertEquals("N/A", mySite.getMaxRvLength());
		
		maxRvLength = "35";
		mySite.setMaxRvLength(maxRvLength);
		assertEquals("35", mySite.getMaxRvLength());
	}
	
	@Test
	public void test_get_and_set_utilities() {	
		boolean utilities = true;
		mySite.setUtilities(utilities);
		assertEquals("Yes", mySite.isUtilities());
		
		mySite.setUtilities(!utilities);
		assertEquals("No", mySite.isUtilities());
	}
	
	@Test
	public void get_all_sites() {
		List<Site> results = dao.getAllSites();
		assertNotNull(results);	
		mySite.setCampgroundID(4);
		mySite.setSiteNumber(1);
		mySite.setMaxOccupancy(6);
		mySite.setAccessible(true);
		mySite.setMaxRvLength("35");
		mySite.setUtilities(false);
		dao.createSite(mySite);
		

		List<Site> results2 = dao.getAllSites();
		
		assertNotNull(results2);	
		assertEquals(results.size() + 1, results2.size());
		
	}
	
	@Test
	public void get_sites_by_reservation_date() {
		List<Site> results = dao.getAvailableSitesByReservationDate(1, LocalDate.of(2020, 03, 13), LocalDate.of(2020, 03, 15));
		assertNotNull(results);	

		resoDAO.createReservation(results.get(0).getSiteId(), "Hartmann", LocalDate.of(2020, 03, 13), LocalDate.of(2020, 03, 15));
		
		List<Site> results2 = dao.getAvailableSitesByReservationDate(1, LocalDate.of(2020, 03, 13), LocalDate.of(2020, 03, 15));
		
		assertNotNull(results2);	
		assertEquals(results.size() - 1, results2.size());
	}
}
