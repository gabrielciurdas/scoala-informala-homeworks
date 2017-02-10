package ro.siit.java5;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * This class contains the Unit Tests for FestivalGate class.
 *
 * @author Gabriel Ciurdaș
 *         <p> Created on 09/03/2017. </p>
 */
public class FestivalGateTest {

    @Test
    public void gateCorrectlyGeneratesStatisticsEveryFiveSeconds_ForAGivenNumberOfAttendeesAndSleepTime()
            throws InterruptedException {
        FestivalGate gate = new FestivalGate();
        FestivalStatisticsThread statsThread = new FestivalStatisticsThread(gate);
        FestivalAttendeeThread[] festivalAttendeeThreads =
                new FestivalAttendeeThread[150];
        statsThread.setNumberOfAttendees(150);
        statsThread.start();

        for (int i = 0; i < festivalAttendeeThreads.length; i++) {
            festivalAttendeeThreads[i] = new FestivalAttendeeThread(gate);
            festivalAttendeeThreads[i].start();
            festivalAttendeeThreads[i].sleep(200);
        }
        for (FestivalAttendeeThread fa : festivalAttendeeThreads) {
            fa.join();
        }
        int expectedNumberOfStatisticsGenerated = 6;
        int actualNumberOfStatisticsGenerated = gate.getFestivalStatistics().size();
        Assert.assertEquals(expectedNumberOfStatisticsGenerated, actualNumberOfStatisticsGenerated);
    }

    @Test
    public void gateGeneratesStatisticsEveryFiveSeconds() throws InterruptedException {
        FestivalGate gate = new FestivalGate();
        FestivalStatisticsThread statsThread = new FestivalStatisticsThread(gate);
        FestivalAttendeeThread[] festivalAttendeeThreads =
                new FestivalAttendeeThread[203];
        statsThread.setNumberOfAttendees(203);
        statsThread.start();

        for (int i = 0; i < festivalAttendeeThreads.length; i++) {
            festivalAttendeeThreads[i] = new FestivalAttendeeThread(gate);
            festivalAttendeeThreads[i].start();
            festivalAttendeeThreads[i].sleep(100);
        }
        for (FestivalAttendeeThread fa : festivalAttendeeThreads) {
            fa.join();
        }
        ArrayList<Integer> actualSecondsPassed = statsThread.getSecondsList();
        ArrayList<Integer> expectedSecondsPassed = new ArrayList<>();
        //Calendar and Date objects are used in order to remove a bug
        //where expectedSecondsPassed array tried for example to add
        //second 3 - 5 which gives a negative number and therefore test fails.
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        for (int i = 0; i < actualSecondsPassed.size(); i++) {
            if (i > 0) {
                calendar.set(Calendar.SECOND, actualSecondsPassed.get(i - 1) - 5);
                expectedSecondsPassed.add(calendar.get(Calendar.SECOND));
            }

        }
        //The value of these two arrays represents the seconds at which
        //the gate generated statistics. The for loop checks if the
        //current value in seconds is equal to the current value -5 seconds
        //from the comparing array.
        for (int i = 0; i < expectedSecondsPassed.size(); i++) {
            if (i > 0) {
                Assert.assertEquals(expectedSecondsPassed.get(i), actualSecondsPassed.get(i - 1));
            }
        }
    }

    @Test
    public void allValidTicketsAreValidated()
            throws InterruptedException {
        FestivalGate gate = new FestivalGate();
        FestivalStatisticsThread statsThread = new FestivalStatisticsThread(gate);
        FestivalAttendeeThread[] festivalAttendeeThreads =
                new FestivalAttendeeThread[100];
        statsThread.setNumberOfAttendees(100);
        statsThread.start();

        for (int i = 0; i < festivalAttendeeThreads.length; i++) {
            festivalAttendeeThreads[i] = new FestivalAttendeeThread(gate);
            festivalAttendeeThreads[i].start();
            festivalAttendeeThreads[i].sleep(100);
        }
        for (FestivalAttendeeThread fa : festivalAttendeeThreads) {
            fa.join();
        }
        int expectedProcessedNumberOfAttendees = gate.getTicketsFromQueue().size();
        int actualProcessedNumberOfAttendees = statsThread.getNumberOfAttendees();
        Assert.assertEquals(expectedProcessedNumberOfAttendees, actualProcessedNumberOfAttendees);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenInvalidTicketIsUsed_IllegalArgumentExceptionIsThrown()
            throws InterruptedException {
        FestivalGate gate = new FestivalGate();
        FestivalStatisticsThread statsThread = new FestivalStatisticsThread(gate);

        FestivalAttendeeThread festivalAttendeeThread =
                new FestivalAttendeeThread(new TicketType(Ticket.valueOf("ONE_HOUR_PAS")), gate);
        FestivalAttendeeThread festivalAttendeeThread1
                = new FestivalAttendeeThread(new TicketType(Ticket.FREE_PAS), gate);
        FestivalAttendeeThread festivalAttendeeThread2
                = new FestivalAttendeeThread(new TicketType(Ticket.FULL_VIP), gate);
        statsThread.setNumberOfAttendees(3);
        statsThread.start();

        festivalAttendeeThread.start();
        festivalAttendeeThread.sleep(100);
        festivalAttendeeThread1.start();
        festivalAttendeeThread1.sleep(100);
        festivalAttendeeThread2.start();
        festivalAttendeeThread2.sleep(100);
    }
}
