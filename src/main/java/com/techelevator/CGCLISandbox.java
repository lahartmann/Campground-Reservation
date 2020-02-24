package com.techelevator;

//import java.math.BigDecimal;
//import java.sql.SQLException;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.time.format.DateTimeParseException;
//import java.time.temporal.ChronoUnit;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Locale;
//import java.util.Scanner;
//
//import javax.sql.DataSource;
//
//import org.apache.commons.dbcp2.BasicDataSource;
//
//public class CGCLISandbox {
//	
//	
//
//	private CampgroundMenu menu;
//	private ParkDAO parkDAO;
//	private SiteDAO siteDAO;
//	private CampgroundDAO campgroundDAO;
//	private ReservationDAO reservationDAO;
//	private String firstOption;
//	private String secondOption;
//	private String thirdOption;
//	private String fourthOption = "";
//	private Park displayPark;
//	private Campground displayCampground;
//	private Site displaySite;
//	private String startDate;
//	private String endDate;
//	private String reservationName;
//	private Long lengthOfStay;
//	private LocalDate startLocalDate;
//	private LocalDate endLocalDate;
//	private Reservation newReservation;
//	private List<Park> parkNames = new ArrayList<>();
//	private List <Campground> campgroundNames = new ArrayList<>();
//	private List <Site> siteList = new ArrayList<>();
//	private Scanner campScanner = new Scanner(System.in);
//
//	public static void main(String[] args) throws SQLException {
//		BasicDataSource dataSource = new BasicDataSource();
//		dataSource.setUrl("jdbc:postgresql://localhost:5432/campground");
//		dataSource.setUsername("postgres");
//		dataSource.setPassword("postgres1");
//
//		CampgroundCLI application = new CampgroundCLI(dataSource);
//		application.run();
//		dataSource.close();
//
//	}
//
//	public CGCLISandbox(DataSource datasource) {
//		parkDAO = new JDBCParkDAO(datasource);
//		campgroundDAO = new JDBCCampgroundDAO(datasource);
//		siteDAO = new JDBCSiteDAO(datasource);
//		reservationDAO = new JDBCReservationDAO(datasource);
//	}
//
//	public void run() {
//
//		System.out.println("Welcome to the Campground Booking App");
//
//		while (true) {
//			List parkList = new ArrayList<>();
//			parkNames = parkDAO.getAllParks();
//			for (int i = 0; i < parkNames.size(); i++) {
//				parkList.add(parkNames.get(i).getPark_id());
//				parkList.add(parkNames.get(i).getName());
//			}
//
//			menu.displayMenuOptions(parkList);
//				
//			System.out.println("Select a park number for futher details or Q to quit");
//			firstOption = campScanner.nextLine();
//
//			if (firstOption.equalsIgnoreCase("Q")) {
//				System.out.println("Thank you for computing, have a pleasant day!");
//				System.exit(0);
//			} else if (Integer.parseInt(firstOption) <= parkNames.size()) {
//				campMenuTwo();
//			} else {
//				System.out.println("Please make a valid selection");
//			}
//		}
//	}
//
//	private void campMenuTwo() {
//
//		// while(!secondOption.equalsIgnoreCase("2")) {
//		printMenuTwoHeader(firstOption);
//		secondOption = campScanner.nextLine();
//		if (secondOption.equals("1")) {
//			campMenuThree();
//		} else if (secondOption.equals("2")) {
//			run();
//		} else {
//			System.out.println("Please enter a valid option.");
//			;
//		}
//
//	}
//
//	private void campMenuThree() {
//		
//		
//		printMenuThreeHeader();
//			while(true) {
//				System.out.println("Which campground? (enter 0 to return to previous menu.)");
//				thirdOption = campScanner.nextLine();
//				if (thirdOption.equals("0")) {
//					campMenuTwo();
//				}
//				else if (Integer.parseInt(thirdOption)-1 <= campgroundNames.size()) {
//					
//					while(true) {
//						System.out.println("Enter arrival date (yyyy-mm-dd)");
//						startDate = campScanner.nextLine();
//						
//						
//				
//						try {
//							LocalDate.parse(startDate, DateTimeFormatter.ofPattern("uuuu-MM-dd"));
//							startLocalDate = LocalDate.parse(startDate);
//							if (startLocalDate.isBefore(LocalDate.now())) {
//								System.out.println("Date must not be in the past.");
//							}else {
//								break;
//							}
//						}	
//						catch (DateTimeParseException e) {
//							System.out.println("Please enter date as yyyy-mm-dd");
//							}
//						}
//					}
//					
//				while(true) {
//					System.out.println("Enter departure date (yyyy-mm-dd)");
//					endDate = campScanner.nextLine();
//					
//					try{
//						LocalDate.parse(endDate, DateTimeFormatter.ofPattern("uuuu-MM-dd"));
//						endLocalDate = LocalDate.parse(endDate);
//						if(endLocalDate.isBefore(startLocalDate) || endLocalDate.isEqual(startLocalDate)) {
//							System.out.println("Departure date must be after start date");
//						}else {
//							break;
//						}
//					}
//					catch (DateTimeParseException d) {
//						System.out.println("Please enter date as yyyy-mm-dd");
//						}
//					}campMenuFour();
//				} //System.out.println("Please enter valid campground id");//This needs to work to handle invaild campsite codes	
//			}
//	
//	
//	private void campMenuFour() {
//		
//	printMenuFourHeader();
//	
//			System.out.println("Which site to reserve? (enter 0 to cancel)");
//			fourthOption = campScanner.nextLine();
//			if (fourthOption.equals("0")){
//				campMenuThree();
//			}else  {
//				
//			for(int i = 0; i > siteList.size(); i++) {
//				 if (Integer.parseInt(fourthOption) == siteList.get(i).getSiteNumber()) {
//				System.out.println("Enter name for reservation");
//				int siteID = siteList.get(i).getSiteId();
//				reservationName = campScanner.nextLine();
//				newReservation = reservationDAO.createReservation(siteID, reservationName, startLocalDate, endLocalDate);
//				System.out.println("Your site is reservered. Your reservation number is; " + newReservation.getReservationId());
//				}
//			} 
//		 
//		}
//	}		
//	
//
//	// Helper Methods
//	private void printMenuTwoHeader(String firstOption) {
//		displayPark = parkNames.get(Integer.parseInt(firstOption) - 1);
//
//		System.out.println("Park Info Screen");
//		System.out.println(displayPark.getName());
//		System.out.println("Location: " + displayPark.getLocation());
//		System.out.println("Established: " + displayPark.getEstablish_date());
//		System.out.println("Area: " + displayPark.getArea());
//		System.out.println("Annual Vistors: " + displayPark.getVisitors());
//		System.out.println("**********************************************");
//		System.out.println("Select an Option: ");
//		System.out.println("1) View Campgrounds and reserve a site ");
//		System.out.println("2) Return to Previous Menu ");
//
//	}
//
//	private void printMenuThreeHeader() {
//		List<Campground> campgroundNames = new ArrayList<>();
//		campgroundNames = campgroundDAO.getCampgroundByParkId(Integer.parseInt(firstOption));
//		for (int i = 0; i < campgroundNames.size(); i++) {
//			System.out.println(campgroundNames.get(i).getCampgroundId() 
//					+ " " + " " + campgroundNames.get(i).getName()
//					+ " " + " " + Integer.parseInt(campgroundNames.get(i).getOpenDate()) 
//					+ " " + " " + campgroundNames.get(i).getCloseDate() 
//					+ " " + " " + campgroundNames.get(i).getDailyFee());
//			
//			displayCampground = campgroundNames.get(Integer.parseInt(secondOption)-1);
//		}
//	}
//
//	private void printMenuFourHeader()	{
//		
//		System.out.println("Available camp sites:");
//		System.out.println("Site # 	 Max Occup. 	Accessible	RV Length	Utilities	Cost of Stay");
//		
//		
//		
//		lengthOfStay = ChronoUnit.DAYS.between(startLocalDate, endLocalDate);
//		
//		
//		siteList = siteDAO.getAvailableSitesByReservationDate
//				(Integer.parseInt(thirdOption), 
//				startLocalDate, 
//				endLocalDate);
//		
//			
//		for (int i = 0; i < siteList.size(); i++) {
//		System.out.println(siteList.get(i).getSiteNumber()
//				+ " " + " 		" + siteList.get(i).getMaxOccupancy()
//				+ " " + " 		" + siteList.get(i).isAccessible()
//				+ " " + "		" + siteList.get(i).getMaxRvLength()
//				+ " " + " 		" + siteList.get(i).isUtilities()
//				+ " " + " 		" + displayCampground.getDailyFee().longValue() * lengthOfStay);		
//			}
//		}
//
//	
//}
