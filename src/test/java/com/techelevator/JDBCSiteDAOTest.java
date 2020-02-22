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
		mySite.
		assertEquals(12, mySite.getSiteId());
		
	}
}
