import org.junit.Assert;
import org.junit.Test;
import ro.sci.java5.AgeCalculator;

import java.time.temporal.ChronoUnit;

/**
 * Created by Gabi on 2/28/2017.
 */
public class AgeCalculatorTest {

    @Test
    public void calculatesAgeInDays() {
        AgeCalculator ageCalculator = new AgeCalculator();

        ageCalculator.setBirthday(1988, 7, 18);
        ageCalculator.setCurrentDay(2017, 2, 28);
        ageCalculator.calculateAge();

        long actual = ChronoUnit.DAYS.between(ageCalculator.getBirthday(), ageCalculator.getCurrentDay());
        long expected = 10452;

        Assert.assertEquals(expected, actual);
    }
}
