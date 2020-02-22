package com.techelevator;

import static org.junit.Assert.assertEquals;

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
	
//	@Test
//	public void test_get_and_set_accessible() {	
//		boolean accessible;
//		mySite.setAccessible(accessible);
//		assertEquals(12, mySite.getCampgroundID());
//		
//	}
	
	@Test
	public void test_get_and_set_rv_length() {	
		String maxRvLength = "0";
		mySite.setMaxRvLength(maxRvLength);
		assertEquals("N/A", mySite.getMaxRvLength());
		
	}
}
