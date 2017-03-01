package ro.sci.java5;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class AgeCalculator {
	private LocalDate birthday;
	private LocalDate currentDay;


    private void setBirthday(int year, int month, int day) {
        birthday = LocalDate.of(year, month, day);
    }

    private void setCurrentDay(int year, int month, int day) {
        currentDay = LocalDate.of(year, month, day);
    }

    public void calculateAge(int yearOfBirthday, int monthOfBirthday, int birthday,
    		int currentYear, int currentMonth, int currentDay) {
    	
    	setBirthday(yearOfBirthday, monthOfBirthday, birthday);
    	setCurrentDay(currentYear, currentMonth, currentDay);
    }

    public String displayAgeInDays() {
        return "Age in days: " + ChronoUnit.DAYS.between(birthday, currentDay);
    }
}
