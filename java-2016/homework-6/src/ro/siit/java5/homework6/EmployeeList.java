package ro.siit.java5.homework6;

import java.util.ArrayList;
import java.util.TreeMap;

public class EmployeeList<Seniority, Employee> {
	
	private TreeMap<Seniority, Employee> employeeList = new TreeMap<>();
	private Seniority seniority;
	private Employee employee;
	
	public EmployeeList(Seniority seniority, Employee employee) {
		this.seniority = seniority;
		this.employee = employee;
	}

	public EmployeeList(Seniority seniority, ArrayList<Employee> employees) {
		this.seniority = seniority;
		employees.add(employee);
	}

	/**
	 * @return the employeeList
	 */
	public TreeMap<Seniority, Employee> getEmployeeList() {
		return employeeList;
	}

	/**
	 * @param employeeList the employeeList to set
	 */
	public void setEmployeeList(TreeMap<Seniority, Employee> employeeList) {
		this.employeeList = employeeList;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EmployeeList [employeeList=" + employeeList + ", seniority=" + seniority + ", employee=" + employee
				+ ", getEmployeeList()=" + getEmployeeList() + "]";
	}
	
	
	
}
