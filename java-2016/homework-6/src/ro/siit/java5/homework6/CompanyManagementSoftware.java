package ro.siit.java5.homework6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Gabriel Ciurdas
 *
 */
public class CompanyManagementSoftware implements Comparable<Employee>{
	
	private ArrayList<Employee> managers = new ArrayList<>();
	private ArrayList<Employee> juniorSoftwareDevelopers = new ArrayList<>();
	private ArrayList<Employee> seniorSoftwareDevelopers = new ArrayList<>();
	private ArrayList<Employee> juniorSoftwareTesteres = new ArrayList<>();
	private ArrayList<Employee> seniorSoftwareTesteres = new ArrayList<>();

	private ArrayList<Employee> employeeList = new ArrayList<>();
	private Map<Integer, ArrayList<Employee>> employeesOrderedBySeniority = new HashMap<>();
	private Seniority seniority = new Seniority();
	
	public static final Comparator<Employee> SENIORITY_DESCENDING_ORDER = new Comparator<Employee>() {
		
		@Override
		public int compare(Employee o2, Employee o1) {
			if (o2.getSeniority() == o1.getSeniority()) {
				return 0;
			} else if (o2.getSeniority() > o1.getSeniority()) {
				return 1;
			}
			return -1;
		}
	};
	
	private void addEmployeeSortedBySeniority() {
		seniority = new Seniority(employeeList);
		for (Integer i : seniority.getSeniorityList()) {
			ArrayList<Employee> e = new ArrayList<>();
			for (Employee employee : employeeList) {
				if(i.equals(employee.getSeniority())) {
					e.add(employee);
				}
			}
			employeesOrderedBySeniority.put(i, e);
		}
	}
	
	public void printEmployeeSortedBySeniority() {
		addEmployeeSortedBySeniority();
		for (Map.Entry<Integer, ArrayList<Employee>> entry : employeesOrderedBySeniority.entrySet())
	    {
			if(entry.getKey()== 1) {
				System.out.println("Seniority: " + entry.getKey() + " year -> " + entry.getValue());
			} else {
				System.out.println("Seniority: " + entry.getKey() + " years -> " + entry.getValue());
			}
	    }
	}
	
	public void addToEmployeeList(String name, int seniority, JobRole jobRole) {
		employeeList.add(new Employee(name, seniority, jobRole));
		if(jobRole.equals(JobRole.MANAGER)) {
			managers.add(new Employee(name, seniority));
		}else if(jobRole.equals(JobRole.SENIOR_SOFTWARE_DEVELOPER)) {
			seniorSoftwareDevelopers.add(new Employee(name, seniority));
		}else if(jobRole.equals(JobRole.SENIOR_SOFTWARE_TESTER)) {
			seniorSoftwareTesteres.add(new Employee(name, seniority));
		}else if(jobRole.equals(JobRole.JUNIOR_SOFTWARE_DEVELOPER)) {
			juniorSoftwareDevelopers.add(new Employee(name, seniority));
		}else{
			juniorSoftwareTesteres.add(new Employee(name, seniority));
		}
	}
	
	public void addToEmployeeList(String name, int seniority, int parkingSpace, JobRole jobRole) {
		employeeList.add(new EmployeeWithParkingSpace(name, seniority, parkingSpace, jobRole));
		if(jobRole.equals(JobRole.MANAGER)) {
			managers.add(new EmployeeWithParkingSpace(name, seniority, parkingSpace));
		}else if(jobRole.equals(JobRole.SENIOR_SOFTWARE_DEVELOPER)) {
			seniorSoftwareDevelopers.add(new EmployeeWithParkingSpace(name, seniority, parkingSpace));
		}else if(jobRole.equals(JobRole.SENIOR_SOFTWARE_TESTER)) {
			seniorSoftwareTesteres.add(new EmployeeWithParkingSpace(name, seniority, parkingSpace));
		}else if(jobRole.equals(JobRole.JUNIOR_SOFTWARE_DEVELOPER)) {
			juniorSoftwareDevelopers.add(new EmployeeWithParkingSpace(name, seniority, parkingSpace));
		}else{
			juniorSoftwareTesteres.add(new EmployeeWithParkingSpace(name, seniority, parkingSpace));
		}
	}
	public ArrayList<Employee> getEmployeeList() {
		return employeeList;
	}
	
	public ArrayList<Employee> getJuniorSoftwareDevelopers() {
		return juniorSoftwareDevelopers;
	}
	
	public ArrayList<Employee> getJuniorSoftwareTesteres() {
		return juniorSoftwareTesteres;
	}
	
	public ArrayList<Employee> getManagers() {
		return managers;
	}
	
	public ArrayList<Employee> getSeniorSoftwareDevelopers() {
		return seniorSoftwareDevelopers;
	}
	
	public ArrayList<Employee> getSeniorSoftwareTesteres() {
		return seniorSoftwareTesteres;
	}
	
	public void displayEmployees(ArrayList<Employee> employee) {
		printEmployee(employee);
	}

	private void printEmployee(ArrayList<Employee> employee) {
		for (Employee e : employee) {
			System.out.println(e.toString());
		}
	}

	@Override
	public int compareTo(Employee o) {
		return 0;
	}
}
