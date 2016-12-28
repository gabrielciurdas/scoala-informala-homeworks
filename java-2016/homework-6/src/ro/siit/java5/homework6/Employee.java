package ro.siit.java5.homework6;

public class Employee {

	private String employee;

	public Employee(String employee) {
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
}
