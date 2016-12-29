package ro.siit.java5.homework6;

import java.util.Collections;

/**
 * The Main class in which a CompanyManagementSoftware object is created in order
 * to add Employees to lists. The list of employees is sorted by seniority and then 
 * is displayed for the user to see.
 * 
 * @see Employee
 * @see EmployeeDetails 
 * @see CompanyManagementSoftware
 * @see Seniority
 * @see JobRole
 * 
 * @author Gabriel Ciurdas
 *	<p> 29/12/2016
 */
public class Main {
	
	/**
	 * The main method.
	 * 
	 * @see Employee
	 * @see EmployeeDetails 
	 * @see CompanyManagementSoftware
	 * @see Seniority
	 * @see JobRole
	 * 
	 * @param args represents the command line arguments.
	 */
	public static void main(String[] args) {

		CompanyManagementSoftware companyManagementSoftware = new CompanyManagementSoftware();
		companyManagementSoftware.addToEmployeeList("John Snow", 7, true, JobRole.MANAGER);
		companyManagementSoftware.addToEmployeeList("Ghita ", 1, false, JobRole.MANAGER);
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
		
		System.out.println("\n[List of employees names]: ");
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
