package ro.siit.java5.homework6;

public class Employee {
	private String employee;
	private JobRole jobRole;
	private int seniority;
	
	public Employee(String employee, int seniority, JobRole jobRole) {
		this.employee = employee;
		this.seniority = seniority;
		this.jobRole = jobRole;
	}

	public Employee(String employee, int seniority) {
		this.employee = employee;
		this.seniority = seniority;
	}
	
	public Employee(String employee, JobRole jobRole) {
		this.employee = employee;
		this.jobRole = jobRole;
	}

	public Employee(String employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Employee [employee=" + employee + ", seniority=" + seniority + "]";
	}

	public int getSeniority() {
		return seniority;
	}
}
