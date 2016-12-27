package ro.siit.java5.homework6;

import java.util.ArrayList;

public class Seniority {

	private ArrayList<Integer> seniorityList = new ArrayList<>();
	
	public void setSeniorityList(ArrayList<Employee> employeeList) {
		for (Employee e : employeeList) {
			seniorityList.add(e.getSeniority());
		}
	}
	public Seniority(ArrayList<Employee> employeeList) {
		setSeniorityList(employeeList);
	}
	
	public Seniority() {
		seniorityList = new ArrayList<>();
	}
	
	public void displaySeniorityList() {
		for (Integer i : seniorityList) {
			System.out.println(i.toString());
		}
	}
	
	public ArrayList<Integer> getSeniorityList() {
		return seniorityList;
	}
}
