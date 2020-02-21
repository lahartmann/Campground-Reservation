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

public class JDBCParkDAOTest {

		
		private static SingleConnectionDataSource dataSource;
		private ParkDAO dao;
		private JdbcTemplate jdbcTemplate;
		private Park myPark;
		
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
			
			dao = new JDBCParkDAO(dataSource);
			myPark = new Park();
			
		}
		

		@After
		public void tearDown() throws Exception {
			dataSource.getConnection().rollback();
		}
		
		@Test
		public void test_get_and_set_park_id() {
			int parkId = 12;
			myPark.setPark_id(parkId);
			assertEquals(12, myPark.getPark_id());
		}

		@Test
		public void test_get_and_set_name() {
			String name = "Kennywood";
			myPark.setName(name);
			assertEquals(name, myPark.getName());
		}
		
		@Test
		public void test_get_and_set_location() {
			String location = "Pittsburgh";
			myPark.setLocation(location);
			assertEquals(location, myPark.getLocation());
		}
		
		@Test
		public void test_get_and_set_establish_date() {
			LocalDate established = LocalDate.of(2001, 12, 01);
			myPark.setEstablish_date(established);
			assertEquals(established, myPark.getEstablish_date());
		}
		
		@Test
		public void test_get_and_set_area() {
			int area = 50;
			myPark.setArea(area);
			assertEquals(area, myPark.getArea());
		}
		@Test
		public void test_get_and_set_visitors() {
			int visitors = 50000;
			myPark.setVisitors(visitors);
			assertEquals(visitors, myPark.getVisitors());
		}
		@Test
		public void test_get_and_set_description() {
			String description = "Potato Patch French Fries";
			myPark.setDescription(description);;
			assertEquals(description, myPark.getDescription());
		}
		
		@Test
		public void test_get_all_parks() {
			List<Park> results = dao.getAllParks();
			assertNotNull(results);	
			myPark.setName("Kennywood");
			myPark.setLocation("Pittsburgh");;
			myPark.setEstablish_date(LocalDate.of(2001, 01, 12));
			myPark.setArea(5000);;
			myPark.setVisitors(50000);
			myPark.setDescription("Family Fun");
			dao.createPark(myPark);
			

			List<Park> results2 = dao.getAllParks();
			
			assertNotNull(results2);	
			assertEquals(results.size() + 1, results2.size());
			
		}
}
