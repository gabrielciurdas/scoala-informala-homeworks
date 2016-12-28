package ro.siit.java5.homework6;

import java.util.Collections;


public class Main {
	
	public static void main(String[] args) {

		CompanyManagementSoftware companyManagementSoftware = new CompanyManagementSoftware();
		companyManagementSoftware.addToEmployeeList("John Snow", 7, true, JobRole.MANAGER);
		companyManagementSoftware.addToEmployeeList("Ghita", 1, false, JobRole.MANAGER);
		companyManagementSoftware.addToEmployeeList("Mihai", 6, true, JobRole.SENIOR_SOFTWARE_DEVELOPER);
		companyManagementSoftware.addToEmployeeList("Alex", 5, false,  JobRole.SENIOR_SOFTWARE_DEVELOPER);
		companyManagementSoftware.addToEmployeeList("Bogdan", 6, true, JobRole.SENIOR_SOFTWARE_TESTER);
		companyManagementSoftware.addToEmployeeList("Cristina", 1, true,  JobRole.JUNIOR_SOFTWARE_DEVELOPER);
		companyManagementSoftware.addToEmployeeList("Alin", 1, false, JobRole.JUNIOR_SOFTWARE_DEVELOPER);
		companyManagementSoftware.addToEmployeeList("Andrei", 1, true,  JobRole.JUNIOR_SOFTWARE_TESTER);
		companyManagementSoftware.addToEmployeeList("Carmen", 1, false, JobRole.JUNIOR_SOFTWARE_TESTER);
		
		
		Collections.sort(companyManagementSoftware.getEmployeeList(), CompanyManagementSoftware.SENIORITY_ASCENDING_ORDER);
		
		System.out.println("[List of employees sorted by seniority in ascending order]: \n");
		companyManagementSoftware.printEmployeeSortedBySeniority();
		
		System.out.println("\n[List of employee names]: ");
		System.out.println("\nManagers: ");
		companyManagementSoftware.displayEmployees(companyManagementSoftware.getManagers());
		System.out.println("\nJunior Software Developers: ");
		companyManagementSoftware.displayEmployees(companyManagementSoftware.getJuniorSoftwareDevelopers());
		System.out.println("\nSenior Software Developers: ");
		companyManagementSoftware.displayEmployees(companyManagementSoftware.getSeniorSoftwareDevelopers());
		System.out.println("\nJunior Software Testers: ");
		companyManagementSoftware.displayEmployees(companyManagementSoftware.getJuniorSoftwareTesters());
		System.out.println("\nSenior Software Testers: ");
		companyManagementSoftware.displayEmployees(companyManagementSoftware.getSeniorSoftwareTesters());
		
	}
}
