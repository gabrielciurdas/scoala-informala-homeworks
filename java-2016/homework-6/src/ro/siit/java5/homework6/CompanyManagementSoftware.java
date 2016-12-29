package ro.siit.java5.homework6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * This class firstly stores employee with all of their details in a single list.
 * Employees are sorted by seniority in ascending order.
 * Then, employees are separated and stored by their name in job specific lists.
 * 
 * @see Employee 
 * @see EmployeeDetails 
 * @see Seniority
 * 
 * @author Gabriel Ciurdas
 *	<p> Date: 29/12/2016
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
	
	/**
	 * Compares EmployeeDetails objects by seniority in ascending order.
	 */
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
	
	/**
	 * Displays all employees sorted by seniority. 
	 */
	public void printEmployeeSortedBySeniority() {
		addEmployeeSortedBySeniority();
		displayEmployees();
	}

	private void displayEmployees() {
		for (Map.Entry<Integer, ArrayList<EmployeeDetails>> entry : employeesOrderedBySeniority.entrySet())
	    {
			if(entry.getKey()== 1) {
				System.out.println("Seniority: " + entry.getKey() + " year -> " + entry.getValue());
			} else {
				System.out.println("Seniority: " + entry.getKey() + " years -> " + entry.getValue());
			}
	    }
	}
	
	/**
	 * Adds employees to employeeList and then stores their name to separate job roles lists.
	 * 
	 * @param name is the name of the employee.
	 * @param seniority represents employee's experience in number of years worked.
	 * @param hasParkingSpace keeps a record if the employee has a parking space or not.
	 * @param jobRole is the job role of the employee.
	 * @throws IllegalArgumentException if the name of the employee contains an empty string,
	 *  is null or the name contains non alphabetical characters. Returns same exception if the
	 *  job role variable is null or if the number of year of work experience is greater than 50. 
	 */
	public void addToEmployeeList(String name, int seniority, boolean hasParkingSpace, JobRole jobRole) 
									throws IllegalArgumentException {
		
		employeeList.add(new EmployeeDetails(name, seniority, hasParkingSpace, jobRole));
		addToJobeRoleList(name, jobRole);
	}

	private void addToJobeRoleList(String name, JobRole jobRole) {
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
	
	/**
	 * Displays the list of employees with all of their details.
	 * 
	 * @param employee is the name of the ArrayList of employees to display.
	 */
	public void displayEmployeeDetails(ArrayList<EmployeeDetails> employee) {
		for (EmployeeDetails e : employee) {
			System.out.println(e.toString());
		}
	}
	
	/**
	 * Displays the list of employees's name from their corresponding list of job roles.
	 * 
	 * @param employee is the name of the ArrayList of employees to display.
	 */
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
