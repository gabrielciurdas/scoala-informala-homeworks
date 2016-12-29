package ro.siit.java5.homework6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author Gabriel Ciurdas
 *
 */
public class CompanyManagementSoftware implements Comparable<EmployeeDetails>{
	
	private ArrayList<Employee> managers = new ArrayList<>();
	private ArrayList<Employee> juniorSoftwareDevelopers = new ArrayList<>();
	private ArrayList<Employee> seniorSoftwareDevelopers = new ArrayList<>();
	private ArrayList<Employee> juniorSoftwareTesteres = new ArrayList<>();
	private ArrayList<Employee> seniorSoftwareTesteres = new ArrayList<>();
	private int index = 1;

	private ArrayList<EmployeeDetails> employeeList = new ArrayList<>();
	
	private Map<Integer, ArrayList<EmployeeDetails>> employeesOrderedBySeniority = new HashMap<>();
	private Seniority seniority = new Seniority();
	
	public static final Comparator<EmployeeDetails> SENIORITY_ASCENDING_ORDER = new Comparator<EmployeeDetails>() {
		
		@Override
		public int compare(EmployeeDetails o1, EmployeeDetails o2) {
			if (o2.getSeniority() == o1.getSeniority()) {
				return 0;
			} else if (o1.getSeniority() > o2.getSeniority()) {
				return 1;
			}
			return -1;
		}
	};
	
	private void addEmployeeSortedBySeniority() {
		seniority = new Seniority(employeeList);
		for (Integer i : seniority.getSeniorityList()) {
			ArrayList<EmployeeDetails> e = new ArrayList<>();
			for (EmployeeDetails employee : employeeList) {
				if(i.equals(employee.getSeniority())) {
					e.add(employee);
				}
			}
			employeesOrderedBySeniority.put(i, e);
		}
	}
	
	public void printEmployeeSortedBySeniority() {
		addEmployeeSortedBySeniority();
		for (Map.Entry<Integer, ArrayList<EmployeeDetails>> entry : employeesOrderedBySeniority.entrySet())
	    {
			if(entry.getKey()== 1) {
				System.out.println("Seniority: " + entry.getKey() + " year -> " + entry.getValue());
			} else {
				System.out.println("Seniority: " + entry.getKey() + " years -> " + entry.getValue());
			}
	    }
	}
	
	public void addToEmployeeList(String name, int seniority, boolean hasParkingSpace, JobRole jobRole) 
									throws IllegalArgumentException {
		
		employeeList.add(new EmployeeDetails(name, seniority, hasParkingSpace, jobRole));
		if(jobRole.equals(JobRole.MANAGER)) {
			managers.add(new Employee(name));
		}else if(jobRole.equals(JobRole.SENIOR_SOFTWARE_DEVELOPER)) {
			seniorSoftwareDevelopers.add(new Employee(name));
		}else if(jobRole.equals(JobRole.SENIOR_SOFTWARE_TESTER)) {
			seniorSoftwareTesteres.add(new Employee(name));
		}else if(jobRole.equals(JobRole.JUNIOR_SOFTWARE_DEVELOPER)) {
			juniorSoftwareDevelopers.add(new Employee(name));
		}else{
			juniorSoftwareTesteres.add(new Employee(name));
		}
		
	}

	public ArrayList<EmployeeDetails> getEmployeeList() {
		return employeeList;
	}
	
	public ArrayList<Employee> getJuniorSoftwareDevelopers() {
		return juniorSoftwareDevelopers;
	}
	
	public ArrayList<Employee> getJuniorSoftwareTesters() {
		return juniorSoftwareTesteres;
	}
	
	public ArrayList<Employee> getManagers() {
		return managers;
	}
	
	public ArrayList<Employee> getSeniorSoftwareDevelopers() {
		return seniorSoftwareDevelopers;
	}
	
	public ArrayList<Employee> getSeniorSoftwareTesters() {
		return seniorSoftwareTesteres;
	}
	
	public void displayEmployeeDetails(ArrayList<EmployeeDetails> employee) {
		for (EmployeeDetails e : employee) {
			System.out.println(e.toString());
		}
	}
	
	public void displayEmployees(ArrayList<Employee> employee) {
		for (Employee e : employee) {
			System.out.println((index++) + ". " + e.getEmployee());
		}
	}

	@Override
	public int compareTo(EmployeeDetails o) {
		return 0;
	}
}
