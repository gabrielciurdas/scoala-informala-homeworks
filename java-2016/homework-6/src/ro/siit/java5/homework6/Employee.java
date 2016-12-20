package ro.siit.java5.homework6;

import java.util.ArrayList;

public class Employee {
	
	private ArrayList<Integer> parkingSpaces = new ArrayList<>();
	private ParkingSpace parkingSpace = new ParkingSpace();
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
		parkingSpaces.add(parkingSpaces.size(), parkingSpace.getParkingSpace());
		this.employee = employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}
}
