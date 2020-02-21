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
	private Park displayPark;
	private List<Park> parkNames = new ArrayList<>();
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
			List parkList = new ArrayList();
			parkNames = parkDAO.getAllParks();
			for (int i = 0; i < parkNames.size(); i ++) {
				parkList.add(parkNames.get(i).getPark_id());
				parkList.add(parkNames.get(i).getName());
			}
			
				System.out.println(parkList);
			
			System.out.println("Select a park number for futher details or Q to quit");
			firstOption = campScanner.nextLine();
			
				if(firstOption.equalsIgnoreCase("Q")) {
				System.out.println("Thank you for computing, have a pleasant day!");
				System.exit(0);
				}else if (Integer.parseInt(firstOption) <=  parkNames.size()) {
				campMenuTwo();
				} else {
					System.out.println("Please make a valid selection");
				}
			}
		}
		
		
private void campMenuTwo(){
			printMenuTwoHeader(firstOption);
			
	}
				
	//Helper Methods
		private void printMenuTwoHeader(String firstOption){
			displayPark = parkNames.get(Integer.parseInt(firstOption));
			
			System.out.println("Park Info Screen");
			System.out.println( displayPark.getName());
			System.out.println("Location: " + displayPark.getLocation());
			System.out.println("Established: " + displayPark.getEstablish_date());
			System.out.println("Area: " + displayPark.getArea());
			System.out.println("Annual Vistors: " + displayPark.getVisitors());
			
		}

	
				{}
			{}	
		
		}
	



	