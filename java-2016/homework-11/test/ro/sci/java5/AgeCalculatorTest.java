package ro.sci.java5;

import java.time.temporal.ChronoUnit;

import org.junit.Assert;
import org.junit.Test;

public class AgeCalculatorTest {

	@Test
	public void calculatesAgeInDays() {
		AgeCalculator ageCalculator = new AgeCalculator();

		ageCalculator.setBirthday(1988, 7, 18);
		ageCalculator.setCurrentDay(2017, 2, 28);

		long actual = ChronoUnit.DAYS.between(ageCalculator.getBirthday(), ageCalculator.getCurrentDay());
		long expected = 10452;

		Assert.assertEquals(expected, actual);
	}
}
