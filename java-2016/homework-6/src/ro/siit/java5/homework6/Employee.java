package ro.siit.java5.homework6;

import java.util.regex.Pattern;

public class Employee {

	private String employee;

	public Employee(String employee) throws IllegalArgumentException {
		validateName(employee);
		this.employee = employee;
	}
	
	public Employee() {
		employee = "";
	}
	public String getEmployee() {
		return employee;
	}

	@Override
	public String toString() {
		return  employee;
	}
	private void validateName(String name) throws IllegalArgumentException {
		if (name == null) {
			throw new IllegalArgumentException("Argument for EmployeeDetails cannot be null.");
		} else if (name.length() == 0) {
			throw new IllegalArgumentException("String cannot be empty.");
		} else if(!isAlpha(name)) {
			throw new IllegalArgumentException("Employee's name cannot contain non alphabetical characters!");
		}
	}
	
	private boolean isAlpha(String name) {
	    return Pattern.matches("[a-zA-Z ]+", name);
	}
	
}
