package ro.sci.java5;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * This class has two LocalDate objects and a method to calculate age in days.
 * 
 * @author Gabriel Ciurdas
 *         <p>
 *         Created on 4/3/2017
 *
 */
public class AgeCalculator {
	private LocalDate birthday;
	private LocalDate currentDay;

	public void setBirthday(int year, int month, int day) {
		birthday = LocalDate.of(year, month, day);
	}

	public void setCurrentDay(int year, int month, int day) {
		currentDay = LocalDate.of(year, month, day);
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public LocalDate getCurrentDay() {
		return currentDay;
	}

	/**
	 * This method sets a birthday and the current day.
	 * 
	 * @param yearOfBirthday
	 * @param monthOfBirthday
	 * @param birthday
	 * @param currentYear
	 * @param currentMonth
	 * @param currentDay
	 */
	public void setDates(int yearOfBirthday, int monthOfBirthday, int birthday, int currentYear, int currentMonth,
			int currentDay) {

		setBirthday(yearOfBirthday, monthOfBirthday, birthday);
		setCurrentDay(currentYear, currentMonth, currentDay);
	}

	/**
	 * This method displays the age in days for the chosen birthday and current
	 * day.
	 * 
	 * @return the age in days.
	 */
	public String displayAgeInDays() {
		return "Age in days: " + ChronoUnit.DAYS.between(birthday, currentDay);
	}
}
