package test;

import org.junit.Test;

import ro.siit.java5.homework6.CompanyManagementSoftware;
import ro.siit.java5.homework6.JobRole;

/**
 * This class contains a Unit Test suites for {@link CompanyManagementSoftware} class.
 * 
 * @author Gabriel Ciurdas
 * <p> Date: 29/12/2016
 */
public class CompanyManagementSoftwareTest {

	@Test(expected = IllegalArgumentException.class)
	public void whenNullEmployeeNameIsUsed_ExceptionIsThrown() {
		String name = null;
		CompanyManagementSoftware CMS = new CompanyManagementSoftware();
		CMS.addToEmployeeList(name, 1, true, JobRole.MANAGER);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void whenEmptyEmployeeNameIsUsed_ExceptionIsThrown() {
		String name = "";
		CompanyManagementSoftware CMS = new CompanyManagementSoftware();
		CMS.addToEmployeeList(name, 1, true, JobRole.MANAGER);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void whenNullEmployeeJobRoleIsUsed_ExceptionIsThrown() {
		JobRole jobRole = null;
		CompanyManagementSoftware CMS = new CompanyManagementSoftware();
		CMS.addToEmployeeList("Alex", 1, true, jobRole);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void whenNonAlphabeticalCharactersAreUsedForEmployeeName_ExceptionIsThrown() {
		String name = "J0hn $n0w..";
		CompanyManagementSoftware CMS = new CompanyManagementSoftware();
		CMS.addToEmployeeList(name, 1, true, JobRole.MANAGER);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void whenNumberOfYearsOfExperienceUsedForEmployeeSeniorityIsTooLarge_ExceptionIsThrown() {
		int seniority = 51;
		CompanyManagementSoftware CMS = new CompanyManagementSoftware();
		CMS.addToEmployeeList("Johnny", seniority, true, JobRole.MANAGER);
	}

}
