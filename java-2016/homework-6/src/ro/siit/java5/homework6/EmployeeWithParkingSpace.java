package ro.siit.java5.homework6;

import java.util.ArrayList;

public class EmployeeWithParkingSpace extends Employee {
	
	private ArrayList<Integer> parkingSpaces = new ArrayList<>();
	private static int parkingSpace = 0;

	public EmployeeWithParkingSpace(String employee, int seniority, int parkingSpace, JobRole jobRole) {
		super(employee, seniority, jobRole);
		this.parkingSpace = parkingSpace;
		parkingSpaces.add(parkingSpaces.size(), parkingSpace);
	}
	
	public EmployeeWithParkingSpace(String employee, int seniority, int parkingSpace) {
		super(employee, seniority);
		this.parkingSpace = parkingSpace;
		parkingSpaces.add(parkingSpaces.size(), parkingSpace);
	}
	
	public EmployeeWithParkingSpace(String employee, int parkingSpace, JobRole jobRole) {
		super(employee);
		this.parkingSpace = parkingSpace;
		parkingSpaces.add(parkingSpaces.size(), parkingSpace);
	}
	
	public void setParkingSpace() {
		parkingSpace++;
	}
	
	public int getParkingSpace() {
		return parkingSpace;
	}

	@Override
	public String toString() {
		return "EmployeeWithParkingSpace [parkingSpaces=" + parkingSpaces + ", toString()=" + super.toString() + "]";
	}
}
