package ro.siit.java5;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * This class represents a Festival statistics generator for the
 * use of a Festival Gate simulation. It shares a common resource
 * with FestivalAttendeeThread, the FestivalGate object. Also, it
 * keeps a record of the generated statistics, every five seconds.
 *
 * @author Gabriel Ciurdaș
 *         <p> Created on 03/02/2017. </p>
 */
public class FestivalStatisticsThread extends Thread {

    private FestivalGate gate = new FestivalGate();
    private Map<LinkedBlockingQueue<TicketType>, Integer> statistics = new HashMap<>();
    private int numberOfAttendees = 0;
    private ArrayList<Integer> seconds = new ArrayList<>();  //variable used for Unit Test purposes.

    /**
     * A constructor with one parameter for a FestivalStatisticsThread object.
     *
     * @param gate is the FestivalGate instance for the FestivalStatisticsThread
     *             to be constructed with.
     */
    public FestivalStatisticsThread(FestivalGate gate) {
        this.gate = gate;
    }

    /**
     * This method generates statistics every five seconds from a queue list
     * of Festival Attendees, represented by FestivalAttendeeThread instances.
     * The overrided method of a Thread object calls the statistics
     * instance of a Map to add the queue list as key and the queue size as value.
     * Each Ticket type is counted and then the statistics is added in an array
     * of String, which are stored in gate - the FestivalGate instance.
     */
    public void run() {
            statistics.put(gate.getQueue(), gate.getQueue().size());
            try {
                boolean done = false;
                int queueSize = 0;

                while (queueSize <= numberOfAttendees && !done) {
                    queueSize = gate.getTicketsFromQueue().size();
                    if(queueSize == numberOfAttendees) {
                        done = true;
                    }
                    countPasses();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

    private void countPasses() throws InterruptedException {
        int freePas = 0;
        int full = 0;
        int fullVIP = 0;
        int oneDay = 0;
        int oneDayVIP = 0;
        String statistics = "";

        try {
            currentThread().sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (Ticket t : gate.getTicketsFromQueue()) {
            switch (t) {
                case FREE_PAS:
                    freePas += 1;
                    break;
                case FULL:
                    full += 1;
                    break;
                case FULL_VIP:
                    fullVIP += 1;
                    break;
                case ONE_DAY:
                    oneDay += 1;
                    break;
                case ONE_DAY_VIP:
                    oneDayVIP += 1;
                    break;
            }
        }
        Calendar calendar = Calendar.getInstance();
        String time = (calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE)+ ":"
                + calendar.get(Calendar.SECOND));
        seconds.add(calendar.get(Calendar.SECOND));

        statistics = String.format("Time: %s\n" + "  Number of tickets validated: " +
                "%d\n   People with free pass: " +
                "%d\n   People with full pass: " +
                "%d\n   People with full vip pass: " +
                "%d\n   People with one-day pass: " +
                "%d\n   People with one-day vip pass: " +
                "%d", time, gate.getTicketsFromQueue().size(),
                freePas, full, fullVIP, oneDay, oneDayVIP);
        gate.setStatistics(statistics);
    }

    public void setNumberOfAttendees(int numberOfAttendees) {
        this.numberOfAttendees = numberOfAttendees;
    }

    public int getNumberOfAttendees() {
        return numberOfAttendees;
    }

    public ArrayList<Integer> getSecondsList() {
        return seconds;
    }
}
