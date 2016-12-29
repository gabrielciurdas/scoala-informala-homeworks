package ro.siit.java5.homework6;

import java.util.regex.Pattern;

/**
 * Creates an Employee object with its name.
 * 
 * @author Gabriel Ciurdas
 *	<p> Date: 29/12/2016
 */
public class Employee {

	private String employee;
	
	/**
	 * A constructor for an Employee object.
	 * 
	 * @param employee is the name of the Employee object.
	 * @throws IllegalArgumentException if the name of the employee contains an empty string,
	 *  is null or the name contains non alphabetical characters.
	 */
	public Employee(String employee) throws IllegalArgumentException {
		validateName(employee);
		this.employee = employee;
	}
	
	/**
	 * A constructor for an Employee object with no parameters.
	 */
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
