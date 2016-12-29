package ro.siit.java5.homework6;

import java.util.ArrayList;

public class Seniority {

	private ArrayList<Integer> seniorityList = new ArrayList<>();
	
	public void setSeniorityList(ArrayList<EmployeeDetails> employeeList) {
		for (EmployeeDetails e : employeeList) {
			seniorityList.add(e.getSeniority());
		}
	}
		
	public Seniority(ArrayList<EmployeeDetails> employeeList) {
		setSeniorityList(employeeList);
	}
	
	public Seniority() {
		seniorityList = new ArrayList<>();
	}
	
	public int getSeniorityListSize() {
		return seniorityList.size();
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
