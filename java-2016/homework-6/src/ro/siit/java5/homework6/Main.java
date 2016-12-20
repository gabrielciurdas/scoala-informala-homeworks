package ro.siit.java5.homework6;

import java.util.ArrayList;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) {

		CompanyManagementSoftware companyManagementSoftware = new CompanyManagementSoftware();
		ParkingSpace parkingSpace = new ParkingSpace();
		Seniority seniority = new Seniority();
		
		ArrayList<Employee> employees = new ArrayList<>();
		employees.add(new Employee("John Snow"));
		employees.add(new Employee(1, "Gabriel Ciurdas"));
		employees.add(new Employee(2, "Mihai Popa"));
		employees.add(new Employee(3, "Software Tester1"));
		employees.add(new Employee(4, "Software Tester2"));
		employees.add(new Employee(5, "Manager1"));
		
		
		/*companyManagementSoftware.setJuniorSoftwareDevelopers(new HashSet<EmployeeList<Seniority, Employee>>());
		companyManagementSoftware.setJuniorSoftwareTesteres(new HashSet<EmployeeList<Seniority, Employee>>());
		companyManagementSoftware.setManagers(new HashSet<EmployeeList<Seniority, Employee>>());
		companyManagementSoftware.setSeniorSoftwareDevelopers(new HashSet<EmployeeList<Seniority, Employee>>());
		companyManagementSoftware.setSeniorSoftwareTesteres(new HashSet<EmployeeList<Seniority, Employee>>());*/
		
	}

}
