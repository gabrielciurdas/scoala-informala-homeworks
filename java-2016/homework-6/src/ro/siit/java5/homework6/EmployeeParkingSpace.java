package ro.siit.java5.homework6;

import java.util.ArrayList;
import java.util.HashMap;

public class EmployeeParkingSpace extends Employee{
	
	//private ParkingSpace parkingSpaces;
	//private ArrayList<Employee> employees = new ArrayList<>();
	private HashMap<ParkingSpace, ArrayList<Employee>> employeeParkingSpace = new HashMap<>();
	
	public EmployeeParkingSpace(HashMap<ParkingSpace, ArrayList<Employee>> employeeParkingSpace) {
		this.employeeParkingSpace = employeeParkingSpace;
	}
}
