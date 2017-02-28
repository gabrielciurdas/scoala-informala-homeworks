package ro.sci.java5;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class AgeCalculator {
	private LocalDate birthday;
	private LocalDate currentDay;

    public void setBirthday(int year, Month month, int day) {
        birthday = LocalDate.of(year, month, day);
    }

    public void setBirthday(int year, int month, int day) {
        birthday = LocalDate.of(year, month, day);
    }

    public void setCurrentDay(int year, Month month, int day) {
        currentDay = LocalDate.of(year, month, day);
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

    public void calculateAge(LocalDate birthday, LocalDate currentDay) {
        System.out.println("Age in days: " + ChronoUnit.DAYS.between(birthday, currentDay));
    }

    public void calculateAge() {
        System.out.println("Age in days: " + ChronoUnit.DAYS.between(birthday, currentDay));
    }
}
