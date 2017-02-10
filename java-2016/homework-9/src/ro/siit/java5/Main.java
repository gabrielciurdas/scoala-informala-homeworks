package ro.siit.java5;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * The Main class for the Festival Gate simulation.
 *
 * @author Gabriel Ciurdaș
 *         <p> Created on 03/02/2017. </p>
 */
public class Main {

    /**
     * The main method.
     *
     * @param args represents the command line arguments.
     * @throws InterruptedException if the FestivalStatisticsThread instance
     *                              or the FestivalAttendeeThread instances are interrupted.
     */
    public static void main(String[] args) throws InterruptedException {

        Random random = new Random();
        FestivalGate gate = new FestivalGate();
        FestivalStatisticsThread statsThread = new FestivalStatisticsThread(gate);
        System.out.println("Number of people on queue : " + gate.getNumberOfAttendees());

        FestivalAttendeeThread[] festivalAttendeeThreads =
                new FestivalAttendeeThread[gate.getNumberOfAttendees()];

        statsThread.setNumberOfAttendees(gate.getNumberOfAttendees());
        statsThread.start();
        generateFestivalAttendees(random, gate, festivalAttendeeThreads);
        joinFestivalAttendees(festivalAttendeeThreads);

        gate.displayStatistics();
    }

    private static void joinFestivalAttendees(FestivalAttendeeThread[] festivalAttendeeThreads) throws InterruptedException {
        for (FestivalAttendeeThread fa : festivalAttendeeThreads) {
            fa.join();
        }
        System.out.println("\nWaiting for statistics..\n ");
        TimeUnit.SECONDS.sleep(5); //to make sure all statistics are displayed
        //could be solved with wait() and notify()
    }

    private static void generateFestivalAttendees(Random random,
                                                  FestivalGate gate,
                                                  FestivalAttendeeThread[] festivalAttendeeThreads) throws InterruptedException {
        for (int i = 0; i < festivalAttendeeThreads.length; i++) {
            festivalAttendeeThreads[i] = new FestivalAttendeeThread(gate);
            festivalAttendeeThreads[i].start();
            festivalAttendeeThreads[i].sleep(50 + random.nextInt(450));  //at least 50ms of sleep
        }
    }
}
