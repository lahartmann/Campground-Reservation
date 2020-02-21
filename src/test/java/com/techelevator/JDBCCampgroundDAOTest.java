package com.techelevator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
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
	
//	@Test
//	public void test_get_set_park_Id() {
//		int campgroundId = 15;
//		
//		assertEquals(15, myCampground.setCampgroundId(campgroundId));
//		
//		
//	}
		
		
	
	@Test
	public void test_all_campground() {
		List<Campground> results = dao.getAllCampgrounds();
		assertNotNull(results);	
		myCampground.setName("Deer Run");
		myCampground.setParkId(1);
		myCampground.setOpenDate("01");
		myCampground.setCloseDate("12");
		myCampground.setDailyFee(new Double(35.00));
		dao.createCampground(myCampground);
		

		List<Campground> results2 = dao.getAllCampgrounds();
		
		assertNotNull(results2);	
		assertEquals(results.size() + 1, results2.size());
		
	}
}


//public int getParkId() {
//	return parkId;
//}
//public void setParkId(int parkId) {
//	this.parkId = parkId;
//}
//public String getName() {
//	return name;
//}
//public void setName(String name) {
//	this.name = name;
//}
//public String getOpenDate() {
//	return openDate;
//}
//public void setOpenDate(String openDate) {
//	this.openDate = openDate;
//}
//	
//public String getCloseDate() {
//		return closeDate;
//	}
//public void setCloseDate(String openDate) {
//		this.closeDate = openDate;
//}
//public int getDailyFee() {
//	return dailyFee;
//}
//public void setDailyFee(int dailyFee) {
//	this.dailyFee = dailyFee;