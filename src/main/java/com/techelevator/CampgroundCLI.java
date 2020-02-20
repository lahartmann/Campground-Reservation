package com.techelevator;


import java.util.List;
import java.util.Scanner;

import org.apache.commons.dbcp2.BasicDataSource;


public class CampgroundCLI {
	

	private CampgroundMenu menu;
	private ParkDAO parkDAO;
	private SiteDAO siteDAO;
	private CampgroundDAO campgroundDAO;
	private ReservationDAO reservationDAO;
	
	public static void main(String[] args) {
		
	
	public CampgroundCLI() {
		this.menu = new CampgroundMenu(System.in, System.out);
		
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/campground");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		
		CampgroundCLI application = new CampgroundCLI();
		application.run();
		
	
		//parkDAO = new JDBCParkDAO(dataSource);
		//campgroundDAO = new JDBCCampgroundDAO(dataSource);
		//siteDAO = new JDBCSiteDAO(dataSource);
		reservationDAO = new JDBCReservationDAO(dataSource);
	}	

	private void run() {
		
	
		while(true) {
			displayApplicationBanner();	
		}
			String parkNames = getAllParksNames();
			System.out.println(parkNames);
			System.out.println("Select a park number for futher details or Q to quit");
			String choice = (String)menu.getChoiceFromOptions(parkName);
				if(choice.equals("Q") {
				printHeading("Thank you for computing, have a pleasant day!");
				System.exit(0);
				}else if (Integer.parseInt(choice)<=parkNames.length() {
					handleMenuTwo
				} else if printHeading("Please make a valid selection");
				
				
		

	private void displayApplicationBanner() {
		}
	
	private void printHeading(String headingText) {
		System.out.println("\n"+headingText);
		for(int i = 0; i < headingText.length(); i++) {
			System.out.print("-");
		}
		System.out.println();
	}
	private void handleMenuOne() {
		
	}
	}
	
	
//		System.out.println("National Parks Campground Booking Doodad");
	}
}

//	private void handleDepartments() {
//		printHeading("Departments");
//		String choice = (String)menu.getChoiceFromOptions(DEPARTMENT_MENU_OPTIONS);
//		if(choice.equals(DEPT_MENU_OPTION_ALL_DEPARTMENTS)) {
//			handleListAllDepartments();
//		} else if(choice.equals(DEPT_MENU_OPTION_SEARCH_BY_NAME)) {
//			handleDepartmentSearch();
//		} else if(choice.equals(DEPT_MENU_OPTION_DEPARTMENT_EMPLOYEES)) {
//			handleDepartmentEmployeeList();
//		} else if(choice.equals(DEPT_MENU_OPTION_ADD_DEPARTMENT)) {
//			handleAddDepartment();
//		} else if(choice.equals(DEPT_MENU_OPTION_UPDATE_NAME)) {
//			handleUpdateDepartmentName();
//		} 
//	}
//
//	private void handleAddDepartment() {
//		printHeading("Add New Department");
//		String newDepartmentName = getUserInput("Enter new Department name");
//		Department newDepartment = new Department();
//		newDepartment.setName(newDepartmentName);
//		newDepartment = departmentDAO.createDepartment(newDepartment);
// 		System.out.println("\n*** "+newDepartment.getName()+" created ***");
//	}
//	
//	private void handleUpdateDepartmentName() {
//		printHeading("Update Department Name");
//		List<Department> allDepartments = departmentDAO.getAllDepartments();
//		if(allDepartments.size() > 0) {
//			System.out.println("\n*** Choose a Department ***");
//			Department selectedDepartment = (Department)menu.getChoiceFromOptions(allDepartments.toArray());
//			String newDepartmentName = getUserInput("Enter new Department name");
//			selectedDepartment.setName(newDepartmentName);
//			departmentDAO.saveDepartment(selectedDepartment);
//		} else {
//			System.out.println("\n*** No results ***");
//		}
//	}
//
//	private void handleListAllDepartments() {
//		printHeading("All Departments");
//		List<Department> allDepartments = departmentDAO.getAllDepartments();
//		listDepartments(allDepartments);
//	}
//
//	private void handleDepartmentSearch() {
//		printHeading("Department Search");
//		String departmentSearch = getUserInput("Enter department name to search for");
//		List<Department> departments = departmentDAO.searchDepartmentsByName(departmentSearch);
//		listDepartments(departments);
//	}
//	
//	private void handleDepartmentEmployeeList() {
//		printHeading("Department Employee List");
//		List<Department> allDepartments = departmentDAO.getAllDepartments();
//		if(allDepartments.size() > 0) {
//			System.out.println("\n*** Choose a Department ***");
//			Department selectedDepartment = (Department)menu.getChoiceFromOptions(allDepartments.toArray());
//			List<Employee> departmentEmployees = employeeDAO.getEmployeesByDepartmentId(selectedDepartment.getId());
//			listEmployees(departmentEmployees);
//		} else {
//			System.out.println("\n*** No results ***");
//		}
//	}
//
//	private void listDepartments(List<Department> departments) {
//		System.out.println();
//		if(departments.size() > 0) {
//			for(Department dept : departments) {
//				System.out.println(dept.getName());
//			}
//		} else {
//			System.out.println("\n*** No results ***");
//		}
//	}
//	
//	private void handleEmployees() {
//		printHeading("Employees");
//		String choice = (String)menu.getChoiceFromOptions(EMPL_MENU_OPTIONS);
//		if(choice.equals(EMPL_MENU_OPTION_ALL_EMPLOYEES)) {
//			handleListAllEmployees();
//		} else if(choice.equals(EMPL_MENU_OPTION_SEARCH_BY_NAME)) {
//			handleEmployeeSearch();
//		} else if(choice.equals(EMPL_MENU_OPTION_EMPLOYEES_NO_PROJECTS)) {
//			handleUnassignedEmployeeSearch();
//		} else if(choice.equals(EMPL_MENU_OPTION_CHANGE_DEPARTMENT)) {
//			handleChangeEmployeeDepartment();
//		}
//	}
//
//	private void handleListAllEmployees() {
//		printHeading("All Employees");
//		List<Employee> allEmployees = employeeDAO.getAllEmployees();
//		listEmployees(allEmployees);
//	}
//
//	private void handleEmployeeSearch() {
//		printHeading("Employee Search");
//		String firstNameSearch = getUserInput("Enter first name to search for");
//		String lastNameSearch = getUserInput("Enter last name to search for");
//		List<Employee> employees = employeeDAO.searchEmployeesByName(firstNameSearch, lastNameSearch);
//		listEmployees(employees);
//	}
//
//	private void handleUnassignedEmployeeSearch() {
//		printHeading("Unassigned Employees");
//		List<Employee> employees = employeeDAO.getEmployeesWithoutProjects();
//		listEmployees(employees);
//	}
//	
//	private void listEmployees(List<Employee> employees) {
//		System.out.println();
//		if(employees.size() > 0) {
//			for(Employee emp : employees) {
//				System.out.println(emp.getLastName() + ", " + emp.getFirstName());
//			}
//		} else {
//			System.out.println("\n*** No results ***");
//		}
//	}
//	
//	private void handleChangeEmployeeDepartment() {
//		printHeading("Change Employee Department");
//		
//		System.out.println("Choose an employee to transfer:");
//		List<Employee> allEmployees = employeeDAO.getAllEmployees();
//		Employee selectedEmployee = (Employee)menu.getChoiceFromOptions(allEmployees.toArray());
//		
//		System.out.println("Choose the new department:");
//		List<Department> allDepartments = departmentDAO.getAllDepartments();
//		Department selectedDepartment = (Department)menu.getChoiceFromOptions(allDepartments.toArray());
//		
//		employeeDAO.changeEmployeeDepartment(selectedEmployee.getId(), selectedDepartment.getId());
//	}
//
//	private void handleProjects() {
//		printHeading("Projects");
//		String choice = (String)menu.getChoiceFromOptions(PROJ_MENU_OPTIONS);
//		if(choice.equals(PROJ_MENU_OPTION_ACTIVE_PROJECTS)) {
//			handleListActiveProjects();
//		} else if(choice.equals(PROJ_MENU_OPTION_PROJECT_EMPLOYEES)) {
//			handleProjectEmployeeList();
//		} else if(choice.equals(PROJ_MENU_OPTION_ASSIGN_EMPLOYEE_TO_PROJECT)) {
//			handleEmployeeProjectAssignment();
//		}  else if(choice.equals(PROJ_MENU_OPTION_REMOVE_EMPLOYEE_FROM_PROJECT)) {
//			handleEmployeeProjectRemoval();
//		}
//	}
//
//	private void handleListActiveProjects() {
//		printHeading("Active Projects");
//		List<Project> projects = projectDAO.getAllActiveProjects();
//		listProjects(projects);
//	}
//
//	private void handleEmployeeProjectRemoval() {
//		printHeading("Remove Employee From Project");
//		
//		Project selectedProject = getProjectSelectionFromUser();
//		
//		System.out.println("Choose an employee to remove:");
//		List<Employee> projectEmployees = employeeDAO.getEmployeesByProjectId(selectedProject.getId());
//		if(projectEmployees.size() > 0) {
//			Employee selectedEmployee = (Employee)menu.getChoiceFromOptions(projectEmployees.toArray());
//			projectDAO.removeEmployeeFromProject(selectedProject.getId(), selectedEmployee.getId());
//			System.out.println("\n*** "+selectedEmployee+" removed from "+selectedProject+" ***");
//		} else {
//			System.out.println("\n*** No results ***");
//		}
//	}
//
//	private void handleEmployeeProjectAssignment() {
//		printHeading("Assign Employee To Project");
//		
//		Project selectedProject = getProjectSelectionFromUser();
//		
//		System.out.println("Choose an employee to add:");
//		List<Employee> allEmployees = employeeDAO.getAllEmployees();
//		Employee selectedEmployee = (Employee)menu.getChoiceFromOptions(allEmployees.toArray());
//		
//		projectDAO.addEmployeeToProject(selectedProject.getId(), selectedEmployee.getId());
//		System.out.println("\n*** "+selectedEmployee+" added to "+selectedProject+" ***");
//	}
//	
//	private void handleProjectEmployeeList() {
//		Project selectedProject = getProjectSelectionFromUser();
//		List<Employee> projectEmployees = employeeDAO.getEmployeesByProjectId(selectedProject.getId());
//		listEmployees(projectEmployees);
//	}
//
//	private Project getProjectSelectionFromUser() {
//		System.out.println("Choose a project:");
//		List<Project> allProjects = projectDAO.getAllActiveProjects();
//		return (Project)menu.getChoiceFromOptions(allProjects.toArray());
//	}
//	
//	private void listProjects(List<Project> projects) {
//		System.out.println();
//		if(projects.size() > 0) {
//			for(Project proj : projects) {
//				System.out.println(proj.getName());
//			}
//		} else {
//			System.out.println("\n*** No results ***");
//		}
//	}
//
//	private void printHeading(String headingText) {
//		System.out.println("\n"+headingText);
//		for(int i = 0; i < headingText.length(); i++) {
//			System.out.print("-");
//		}
//		System.out.println();
//	}
//	
//	@SuppressWarnings("resource")
//	private String getUserInput(String prompt) {
//		System.out.print(prompt + " >>> ");
//		return new Scanner(System.in).nextLine();
//	}
//
	