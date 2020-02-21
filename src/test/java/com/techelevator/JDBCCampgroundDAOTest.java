package com.techelevator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;





public class JDBCCampgroundDAOTest {

	
	private static SingleConnectionDataSource dataSource;
	private CampgroundDAO dao;
	private JdbcTemplate jdbcTemplate;
	private Campground myCampground;
	
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
		
		dao = new JDBCCampgroundDAO(dataSource);
		myCampground = new Campground();
		
	}
	

	@After
	public void tearDown() throws Exception {
		dataSource.getConnection().rollback();
	}
	
	@Test
	public void test_get_and_set_campground_Id() {	
		int campgroundId = 12;
		myCampground.setCampgroundId(campgroundId);
		assertEquals(12, myCampground.getCampgroundId());
		
	}
	
	@Test
	public void test_get_set_park_Id() {
		int parkId = 15;
		myCampground.setParkId(parkId);
		assertEquals(15, myCampground.getParkId());	
	}
		
	@Test
	public void test_get_set_park_name() {
		String parkName = "Deer Park";
		myCampground.setName(parkName);
		assertEquals("Deer Park", myCampground.getName());	
	}
	
	@Test
	public void test_get_set_open_date() {
		String openDate = "01";
		myCampground.setOpenDate(openDate);
		assertEquals("01", myCampground.getOpenDate());	
	}
	
	@Test
	public void test_get_set_close_date() {
		String closeDate = "12";
		myCampground.setCloseDate(closeDate);
		assertEquals("12", myCampground.getCloseDate());	
	}
	
	@Test
	public void test_get_set_daily_fee() {
		BigDecimal Fee = new BigDecimal(30.00).setScale(2, RoundingMode.CEILING);
		myCampground.setDailyFee(Fee);
		assertEquals(new BigDecimal(30.00).setScale(2, RoundingMode.CEILING), myCampground.getDailyFee());	
	}
	
	@Test
	public void test_get_all_campground() {
		List<Campground> results = dao.getAllCampgrounds();
		assertNotNull(results);	
		myCampground.setName("Deer Run");
		myCampground.setParkId(1);
		myCampground.setOpenDate("01");
		myCampground.setCloseDate("12");
		myCampground.setDailyFee(new BigDecimal (35.00));
		dao.createCampground(myCampground);
		

		List<Campground> results2 = dao.getAllCampgrounds();
		
		assertNotNull(results2);	
		assertEquals(results.size() + 1, results2.size());
		
	}
	
	@Test
	public void test_seaching_campground_by_name() {
		List<Campground> results = dao.getAllCampgrounds();
		assertNotNull(results);	
		myCampground.setName("Deer Run");
		myCampground.setParkId(1);
		myCampground.setOpenDate("01");
		myCampground.setCloseDate("12");
		myCampground.setDailyFee(new BigDecimal (35.00));
		dao.createCampground(myCampground);
		
		List<Campground> results2 = dao.searchAllCampgroundsByName(myCampground.getName());
		assertNotNull(results2);	

		assertEquals(myCampground.getName(),results2.get(0).getName());
			
	}
	
	@Test
	public void test_seaching_campground_by_park_id() {
		
		List<Campground> results = dao.getAllCampgrounds();
		assertNotNull(results);	
		myCampground.setName("Deer Run");
		myCampground.setParkId(1);
		myCampground.setOpenDate("01");
		myCampground.setCloseDate("12");
		myCampground.setDailyFee(new BigDecimal (35.00));
		dao.createCampground(myCampground);
		
		List<Campground> results2 = dao.getCampgroundByParkId(myCampground.getParkId());
		assertNotNull(results2);	

		assertEquals(myCampground.getParkId(),results2.get(0).getParkId());		
	}
	
	
}






