package ro.siit.java5;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

/**
 * Created by Gabi on 2/9/2017.
 */
public class FestivalGateTest {

    @Test
    public void gateCorrectlyGeneratesStatisticsEveryFiveSeconds_ForAGivenNumberOfAttendeesAndSleepTime()
            throws InterruptedException{
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
                new FestivalAttendeeThread[122];
        statsThread.setNumberOfAttendees(122);
        statsThread.start();

        for (int i = 0; i < festivalAttendeeThreads.length; i++) {
            festivalAttendeeThreads[i] = new FestivalAttendeeThread(gate);
            festivalAttendeeThreads[i].start();
            festivalAttendeeThreads[i].sleep(100);
        }
        for (FestivalAttendeeThread fa : festivalAttendeeThreads) {
                fa.join();
        }
        Calendar calendar = Calendar.getInstance();
        gate.displayStatistics();
        TimeUnit.SECONDS.sleep(5);
        int expectedSecondsPassed1 = calendar.get(Calendar.SECOND);
        int actualSecondsPassed1 = statsThread.getSeconds(gate.getFestivalStatistics().size()-1);
        TimeUnit.SECONDS.sleep(5);
        int expectedSecondsPassed2 = calendar.get(Calendar.SECOND);
        int actualSecondsPassed2 = statsThread.getSeconds(gate.getFestivalStatistics().size()-2);

        Assert.assertEquals(expectedSecondsPassed1, actualSecondsPassed1);
        Assert.assertEquals(expectedSecondsPassed2, actualSecondsPassed2);
    }

    @Test
    public void allValidTicketsAreValidated_AndIncludedInStatistics()
            throws InterruptedException{
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
