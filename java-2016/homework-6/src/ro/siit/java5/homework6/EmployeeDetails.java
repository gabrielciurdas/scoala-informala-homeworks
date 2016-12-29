package ro.siit.java5.homework6;

import java.util.ArrayList;

public class EmployeeDetails extends Employee{

	private JobRole jobRole;
	private int seniority;
	private ArrayList<Integer> parkingSpaces = new ArrayList<>();
	private static int parkingSpace = 0;
	private boolean hasParkingSpace;
	
	public EmployeeDetails(String employee, int seniority, boolean hasParkingSpace, JobRole jobRole) 
								throws IllegalArgumentException {
		super(employee);
		
		validateSeniority(seniority);
		validateJobRole(jobRole);
		
		this.seniority = seniority;
		this.hasParkingSpace = hasParkingSpace;
		this.jobRole = jobRole;
		
		if(hasParkingSpace == true) {
			setParkingSpace();
			parkingSpaces.add(parkingSpaces.size(), parkingSpace);
		}
	}

	public EmployeeDetails() {
		super();
		seniority = 0;
		parkingSpace = 0;
		hasParkingSpace = false;
		jobRole = JobRole.MANAGER;
	}
	private void setParkingSpace() {
		parkingSpace++;
	}

	private void validateSeniority(int seniority) throws IllegalArgumentException {
		if(seniority > 50) {
			throw new IllegalArgumentException("The employee cannot have more than  50 years of work experience!");
		}
	}
	
	private void validateJobRole(JobRole jobRole) throws IllegalArgumentException {
		if (jobRole == null) {
			throw new IllegalArgumentException("Argument for EmployeeDetails cannot be null.");
		}
	}
	
	@Override
	public String toString() {
		if(hasParkingSpace == true) {
			return "Employee = " + super.toString() + ", jobRole=" + jobRole + ", seniority=" + seniority + ", parkingSpaces=" + parkingSpaces;
		}
		return "Employee = " + super.toString() + ", jobRole=" + jobRole + ", seniority=" + seniority + ", hasParkingSpace=" + hasParkingSpace;
	}

	public int getSeniority() {
		// TODO Auto-generated method stub
		return seniority;
	}
}
