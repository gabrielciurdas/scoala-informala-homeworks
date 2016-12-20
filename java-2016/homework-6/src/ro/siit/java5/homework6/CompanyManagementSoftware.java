package ro.siit.java5.homework6;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 */

/**
 * @author Gabi
 *
 */
public class CompanyManagementSoftware {
	
	private Seniority seniority;
	private Employee employee;
	
	private Set<EmployeeList<Seniority, Employee>> managers = new HashSet<>();
	private Set<EmployeeList<Seniority, Employee>> juniorSoftwareDevelopers = new HashSet<>();
	private Set<EmployeeList<Seniority, Employee>> seniorSoftwareDevelopers = new HashSet<>();
	private Set<EmployeeList<Seniority, Employee>> juniorSoftwareTesteres = new HashSet<>();
	private Set<EmployeeList<Seniority, Employee>> seniorSoftwareTesteres = new HashSet<>();
	
	public void setSeniority(byte seniority) {
		this.seniority.setSeniority(seniority);
	}
	
	public void setEmployee(String employee) {
		this.employee.setEmployee(employee);
	}

	/**
	 * @param managers the managers to set
	 */
	public void addManager(Seniority seniority, Employee employee) {
	}

	/**
	 * @param juniorSoftwareDevelopers the juniorSoftwareDevelopers to set
	 */
	public void setJuniorSoftwareDevelopers(Set<EmployeeList<Seniority, Employee>> juniorSoftwareDevelopers) {
		this.juniorSoftwareDevelopers = juniorSoftwareDevelopers;
	}

	/**
	 * @param seniorSoftwareDevelopers the seniorSoftwareDevelopers to set
	 */
	public void setSeniorSoftwareDevelopers(Set<EmployeeList<Seniority, Employee>> seniorSoftwareDevelopers) {
		this.seniorSoftwareDevelopers = seniorSoftwareDevelopers;
	}

	/**
	 * @param juniorSoftwareTesteres the juniorSoftwareTesteres to set
	 */
	public void setJuniorSoftwareTesteres(Set<EmployeeList<Seniority, Employee>> juniorSoftwareTesteres) {
		this.juniorSoftwareTesteres = juniorSoftwareTesteres;
	}

	/**
	 * @param seniorSoftwareTesteres the seniorSoftwareTesteres to set
	 */
	public void setSeniorSoftwareTesteres(Set<EmployeeList<Seniority, Employee>> seniorSoftwareTesteres) {
		this.seniorSoftwareTesteres = seniorSoftwareTesteres;
	}
	
	
}
