package ro.siit.java5;

import java.util.Random;

/**
 * This class keeps a record of a randomly generated number
 * of Festival attendees.
 *
 * @author Gabriel Ciurdaș
 *         <p> Created on 03/02/2017. </p>
 */
public class Counter{
    private Random random = new Random();
    private int numberOfAttendees = 100 + random.nextInt(400);  //generates at least 100 Festival Attendees

    public int getNumberOfAttendees() {
        return numberOfAttendees;
    }

}
