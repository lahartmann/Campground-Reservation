package com.techelevator;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class JDBCReservationDAOTest {

	private static SingleConnectionDataSource dataSource;
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
		
		myReso = new Reservation();
		
	}
	

	@After
	public void tearDown() throws Exception {
		dataSource.getConnection().rollback();
	}
	
	
	@Test
	public void test_get_and_set_reservation_id() {	
		int reservationId = 145;
		myReso.setReservationId(reservationId);
		assertEquals(145, myReso.getReservationId());
		
	}
	@Test
	public void test_get_and_set_site_id() {	
		int siteId = 12;
		myReso.setSiteId(siteId);
		assertEquals(12, myReso.getSiteId());
		
	}
	
	@Test
	public void test_get_and_set_name() {	
		String resoName = "Hartmann";
		myReso.setName(resoName);;
		assertEquals("Hartmann", myReso.getName());
		
	}
	
	@Test
	public void test_get_and_set_from_date() {	
		LocalDate fromDate = LocalDate.of(2020, 12, 18);
		myReso.setFromDate(fromDate);
		assertEquals(fromDate, myReso.getFromDate());
		
	}
	
	@Test
	public void test_get_and_set_to_date() {	
		LocalDate toDate = LocalDate.of(2020, 12, 20);
		myReso.setToDate(toDate);
		assertEquals(toDate, myReso.getToDate());
		
	}
	
	@Test
	public void test_get_and_set_create_date() {	
		LocalDate createDate = LocalDate.now();
		myReso.setCreateDate(createDate);;
		assertEquals(createDate, myReso.getCreateDate());
		
	}
}
