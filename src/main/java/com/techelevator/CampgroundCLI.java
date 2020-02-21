package com.techelevator;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;


public class CampgroundCLI {
	

	private CampgroundMenu menu;
	private ParkDAO parkDAO;
	private SiteDAO siteDAO;
	private CampgroundDAO campgroundDAO;
	private ReservationDAO reservationDAO;
	private String firstOption;
	
	public static void main(String[] args) throws SQLException
		{
			BasicDataSource dataSource = new BasicDataSource();
			dataSource.setUrl("jdbc:postgresql://localhost:5432/campground");
			dataSource.setUsername("postgres");
			dataSource.setPassword("postgres1");
			
			CampgroundCLI application = new CampgroundCLI(dataSource);
			application.run();
			dataSource.close();
		
			Scanner campScanner = new Scanner(System.in);
			String firstOption;
		}

		public CampgroundCLI(DataSource datasource)
		{
			parkDAO = new JDBCParkDAO(datasource);
			campgroundDAO = new JDBCCampgroundDAO(datasource);
			siteDAO = new JDBCSiteDAO(datasource);
			reservationDAO = new JDBCReservationDAO(datasource);
		}
		
		public void run()
		{
		Scanner campScanner = new Scanner(System.in);
		System.out.println("Welcome to the Campground Booking App");
	
		while(true) {
			List<Park> parkNames = new ArrayList<>();
			parkNames = parkDAO.getAllParkNames();
			System.out.println(parkNames);
			System.out.println("Select a park number for futher details or Q to quit");
			firstOption = campScanner.nextLine();
			
				if(firstOption.equalsIgnoreCase("Q")) {
				System.out.println("Thank you for computing, have a pleasant day!");
				System.exit(0);
				}else if (Integer.parseInt(firstOption) <=  parkNames.size()) {
				System.out.println("this is menu 2");//menuTwo();
				} else {
					System.out.println("Please make a valid selection");
				}
//		}campMenutwo(){
//			syst
	}
				
	//Helper Methods
//		private void printHeading(String heading)
//		{
//			System.out.printf("%n%s%n", heading);
//			for (int i = 0; i < heading.length(); i++) System.out.print('-');
//			System.out.println();
//		}
	
	//private void handleMenuOne() {
		
		}	
	}



	