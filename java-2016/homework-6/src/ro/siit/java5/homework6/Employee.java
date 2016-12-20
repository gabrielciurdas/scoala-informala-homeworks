package ro.siit.java5.homework6;

import java.util.ArrayList;

public class Employee {
	
	private ArrayList<ParkingSpace> parkingSpaces = new ArrayList<>();
	private String employee;
	
	public Employee() {
		employee = null;
	}
	
	public Employee(int i, String string) {
		employee = null;
	}
	
	public Employee(String employee) {
		this.employee = employee;
	}
	
	public Employee(ParkingSpace parkingSpace, String employee) {
		parkingSpace.setParkingSpace();
		this.employee = employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	
	/*public void setParkingSpaceNumber(int parkingSpaceNumber) {
		this.parkingSpaceNumber = parkingSpaceNumber;
	}*/
}
