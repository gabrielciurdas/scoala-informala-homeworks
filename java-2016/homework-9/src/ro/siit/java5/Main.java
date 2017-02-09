package ro.siit.java5;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Gabi on 2/3/2017.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        Random random = new Random();
        FestivalGate gate = new FestivalGate();
        //TicketType ticketType = new TicketType();// this should be enum value randomly generated.
        //FestivalAttendeeThread festivalAttendee = new FestivalAttendeeThread(ticketType, gate);
        FestivalStatisticsThread statsThread = new FestivalStatisticsThread(gate);

        System.out.println("Number of people on queue : " + gate.getNumberOfAttendees());

        FestivalAttendeeThread[] festivalAttendeeThreads =
                new FestivalAttendeeThread[gate.getNumberOfAttendees()];

        statsThread.setNumberOfAttendees(gate.getNumberOfAttendees());
        statsThread.start();
        for (int i = 0; i < festivalAttendeeThreads.length; i++) {
            festivalAttendeeThreads[i] = new FestivalAttendeeThread(gate);
            festivalAttendeeThreads[i].start();
            festivalAttendeeThreads[i].sleep(random.nextInt(50));
        }
        for (FestivalAttendeeThread fa : festivalAttendeeThreads) {
            fa.join();
        }
    }
}
