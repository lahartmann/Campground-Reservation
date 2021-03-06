package com.techelevator;

import java.awt.Font;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class CampgroundCLI {
	
	

	//
	private ParkDAO parkDAO;
	private SiteDAO siteDAO;
	private CampgroundDAO campgroundDAO;
	private ReservationDAO reservationDAO;
	private String firstOption;
	private String secondOption;
	private String thirdOption;
	private String fourthOption = "";
	private Park displayPark;
	private Campground displayCampground;
	private Site displaySite;
	private String startDate;
	private String endDate;
	private String reservationName;
	private Long lengthOfStay;
	private LocalDate startLocalDate;
	private LocalDate endLocalDate;
	private Reservation newReservation;
	private List<Park> parkNames = new ArrayList<>();
	private List <Campground> campgroundNames = new ArrayList<>();
	private List <Site> siteList = new ArrayList<>();
	private Scanner campScanner = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/campground");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");

		CampgroundCLI application = new CampgroundCLI(dataSource);
		application.run();
		dataSource.close();

	}

	public CampgroundCLI(DataSource datasource) {
		parkDAO = new JDBCParkDAO(datasource);
		campgroundDAO = new JDBCCampgroundDAO(datasource);
		siteDAO = new JDBCSiteDAO(datasource);
		reservationDAO = new JDBCReservationDAO(datasource);
	}

	public void run() {
		while (true) {
			printRunHeader();
			
			firstOption = campScanner.nextLine();
			try {
			if (firstOption.equalsIgnoreCase("Q")) {
				System.out.println("Thank you for computing, have a pleasant day!");
				System.exit(0);
			} else if (Integer.parseInt(firstOption) <= parkNames.size()) {
				campMenuTwo();
			} else {
				System.out.println("Please make a valid selection");
			} 
			}catch(NumberFormatException e) {
				System.out.println("Please make a valid selection");

			}
		}
	}

	private void campMenuTwo() {
		
		while (true) {
		printMenuTwoHeader(firstOption);
		secondOption = campScanner.nextLine();
		try {
		if (secondOption.equals("1")) {
			campMenuThree();
		} else if (secondOption.equals("2")) {
			run();
		} else {
			System.out.println("Please enter a valid option.");
		}
			
		}catch(NumberFormatException e) {
			System.out.println("Please make a valid selection");
			}
		}
	}

	private void campMenuThree() {
		
		
		printMenuThreeHeader(); {
			while(true) {
				System.out.println("Which campground? (enter 0 to return to previous menu)");
				thirdOption = campScanner.nextLine();
				if (thirdOption.equals("0")) {
					campMenuTwo();
				}
				else if (Integer.parseInt(thirdOption) <= campgroundNames.size()) {
					while(true) {
						
					System.out.println("Enter arrival date (yyyy-mm-dd)");
						startDate = campScanner.nextLine(); {
							try {
								LocalDate.parse(startDate, DateTimeFormatter.ofPattern("uuuu-MM-dd"));
								startLocalDate = LocalDate.parse(startDate);
								if (startLocalDate.isBefore(LocalDate.now())) {
								System.out.println("\n***Date must not be in the past.***\n");
								}else {
									break;
							}
						}	
						catch (DateTimeParseException e) {
							System.out.println("\n***Please enter date as yyyy-mm-dd***\n");
							}
						}
					}
					
				while(true) {
					System.out.println("Enter departure date (yyyy-mm-dd)");
					endDate = campScanner.nextLine();
					
					try{
						LocalDate.parse(endDate, DateTimeFormatter.ofPattern("uuuu-M-dd"));
						endLocalDate = LocalDate.parse(endDate);
						if(endLocalDate.isBefore(startLocalDate) || endLocalDate.isEqual(startLocalDate)) {
							System.out.println("\n***Departure date must be after start date***\n");
						}else {
							break;
						}
					}
					catch (DateTimeParseException d) {
						System.out.println("Please enter date as yyyy-mm-dd");
						}
					}campMenuFour();
			
				}System.out.println("Please enter valid campground id");
			}
		}
			
	}
	
	private void campMenuFour() {
		
	printMenuFourHeader();
	
			System.out.println("Which site to reserve? (enter 0 to cancel)");
			fourthOption = campScanner.nextLine();
			if (fourthOption.equals("0")){
				campMenuThree();
			}else if (Integer.parseInt(fourthOption) <= siteList.size()) {
				System.out.println("Enter name for reservation");
				int siteID = siteList.get(Integer.parseInt(fourthOption)-1).getSiteId();
				reservationName = campScanner.nextLine();
				newReservation = reservationDAO.createReservation(siteID, reservationName, startLocalDate, endLocalDate);
				System.out.println("Your site is reservered. Your reservation number is: " + newReservation.getReservationId());
				System.out.println("");
				System.out.println("************************************************************");
				System.out.println("");
				System.out.println("");
				System.out.println("");
				}run();
			} 
			
		 
		
			
	

	// Helper Methods
	private void printRunHeader() {
		System.out.println("Welcome to the Campground Booking App");
		
		List parkList = new ArrayList();
		parkNames = parkDAO.getAllParks();
		
		for (int i = 0; i < parkNames.size(); i++) {
			int optionNum = i+1;
			
			System.out.println(optionNum + ") " 
					+ " " + " " + parkNames.get(i).getName());
			}
			System.out.println("Select a park number for futher details or Q to quit");
	}
	
	
	private void printMenuTwoHeader(String firstOption) {
		displayPark = parkNames.get(Integer.parseInt(firstOption) - 1);
		System.out.println("Park Information Screen");
		System.out.println(displayPark.getName() + " National Park");
		System.out.println("Location: " + "\t" + displayPark.getLocation());
		System.out.println("Established: " + "\t" + displayPark.getEstablish_date().getMonthValue() + "/" + displayPark.getEstablish_date().getDayOfMonth() + "/" + displayPark.getEstablish_date().getYear());
		System.out.println("Area: " + "\t\t" + NumberFormat.getNumberInstance(Locale.US).format(displayPark.getArea()) + " sq km");
		System.out.println("Annual Vistors: " + NumberFormat.getNumberInstance(Locale.US).format(displayPark.getVisitors()));
		System.out.println(("\n" + displayPark.getDescription()) + "\n");
		System.out.println("**********************************************");
		System.out.println("Select an Option: ");
		System.out.println("1) View Campgrounds and reserve a site ");
		System.out.println("2) Return to Previous Menu ");

	}

	private void printMenuThreeHeader() {
		
		campgroundNames = campgroundDAO.getCampgroundByParkId(Integer.parseInt(firstOption));
		System.out.printf("%-20s %-13s %-10s %-20s %n", "   Name", "   Open", "Close", "Daily Fee");
		for (int i = 0; i < campgroundNames.size(); i++) {
			int optionNum = i+1;
			
			System.out.printf("%d%s %-20s %-10s %-10s %s%.2f %n", optionNum,") ", 
					 campgroundNames.get(i).getName(), Month.of(Integer.parseInt(campgroundNames.get(i).getOpenDate())), 
					Month.of(Integer.parseInt(campgroundNames.get(i).getCloseDate())), "$", campgroundNames.get(i).getDailyFee());
			
			displayCampground = campgroundNames.get(Integer.parseInt(secondOption)-1);
		}
	}

	private void printMenuFourHeader()	{
		
		System.out.println("Available camp sites:");
		System.out.println("Site # 	 Max Occup. 	Accessible	RV Length	Utilities	Cost of Stay");
		
		
		
		lengthOfStay = ChronoUnit.DAYS.between(startLocalDate, endLocalDate);
		
		
		siteList = siteDAO.getAvailableSitesByReservationDate
				(Integer.parseInt(thirdOption), 
				startLocalDate, 
				endLocalDate);
		
			
		for (int i = 0; i < siteList.size(); i++) {
			int optionNum = i + 1;
		System.out.println(optionNum + ") " + siteList.get(i).getSiteNumber()
				+ " " + " 		" + siteList.get(i).getMaxOccupancy()
				+ " " + " 		" + siteList.get(i).isAccessible()
				+ " " + "		" + siteList.get(i).getMaxRvLength()
				+ " " + " 		" + siteList.get(i).isUtilities()
				+ " " + " 		" +  "$" + displayCampground.getDailyFee().longValue() * lengthOfStay);		
			}
		}
}
