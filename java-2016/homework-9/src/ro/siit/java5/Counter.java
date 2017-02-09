package ro.siit.java5;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Gabi on 2/4/2017.
 */
public class Counter{
    private Random random = new Random();
    private int numberOfAttendees = 100 + random.nextInt(400);  //at least 100 Festival Attendees

    public int getNumberOfAttendees() {
        return numberOfAttendees;
    }

}
