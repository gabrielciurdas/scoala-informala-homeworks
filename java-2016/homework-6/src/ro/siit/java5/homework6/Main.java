package ro.siit.java5.homework6;

import java.util.Collections;


public class Main {
	
	public static void main(String[] args) {

		CompanyManagementSoftware companyManagementSoftware = new CompanyManagementSoftware();
		
		companyManagementSoftware.addToEmployeeList("John Snow", 7, 1, JobRole.MANAGER);
		companyManagementSoftware.addToEmployeeList("Ghita", 1, JobRole.MANAGER);
		companyManagementSoftware.addToEmployeeList("Mihai", 6, 2, JobRole.SENIOR_SOFTWARE_DEVELOPER);
		companyManagementSoftware.addToEmployeeList("Alex", 5,  JobRole.SENIOR_SOFTWARE_DEVELOPER);
		companyManagementSoftware.addToEmployeeList("Bogdan", 6, 3, JobRole.SENIOR_SOFTWARE_TESTER);
		companyManagementSoftware.addToEmployeeList("Cristina", 1, 4,  JobRole.JUNIOR_SOFTWARE_DEVELOPER);
		companyManagementSoftware.addToEmployeeList("Alin", 1, JobRole.JUNIOR_SOFTWARE_DEVELOPER);
		companyManagementSoftware.addToEmployeeList("Andrei", 1, 5,  JobRole.JUNIOR_SOFTWARE_TESTER);
		companyManagementSoftware.addToEmployeeList("Carmen", 1, JobRole.JUNIOR_SOFTWARE_TESTER);
		
		Collections.sort(companyManagementSoftware.getEmployeeList(), CompanyManagementSoftware.SENIORITY_DESCENDING_ORDER);
		System.out.println("\nSeniority comparison:");
		
		companyManagementSoftware.displayEmployees(companyManagementSoftware.getEmployeeList());
		
		System.out.println();
		
		companyManagementSoftware.printEmployeeSortedBySeniority();
	}
}
