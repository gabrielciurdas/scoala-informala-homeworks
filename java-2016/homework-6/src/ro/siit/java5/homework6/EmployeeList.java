package ro.siit.java5.homework6;

import java.util.Map;
import java.util.TreeMap;

public class EmployeeList {
	
	private Map<Seniority, Employee> employeeList = new TreeMap<>();

	public void setEmployeeList(Seniority seniority, Employee employee) {
		employeeList.put(seniority, employee);
	}
	
	public void getEmployeeList(Seniority seniority, Employee employee) {
		for(Map.Entry<Seniority, Employee> entry: employeeList.entrySet()) {
			System.out.println(entry.getKey() + "/" + entry.getValue());
		}
	}
	
	
	
}
