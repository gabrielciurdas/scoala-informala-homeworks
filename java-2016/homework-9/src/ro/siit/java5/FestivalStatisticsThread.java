package ro.siit.java5;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Gabi on 2/3/2017.
 */
public class FestivalStatisticsThread extends Thread {

    private FestivalGate gate = new FestivalGate();
    private Map<LinkedBlockingQueue<TicketType>, Integer> statistics = new HashMap<>();
    private int numberOfAttendees = 0;

    public FestivalStatisticsThread(FestivalGate gate) {
        this.gate = gate;
    }

    public void run() {
        if (gate.getQueue().size() < 1) {
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
            gate.displayStatistics();
            System.out.println("Total number of tickets processed : " + gate.getQueue().size());
        } else {
            System.out.println("Waiting for attendees..");
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
        String time = (calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE)+ ":"
                + calendar.get(Calendar.SECOND));

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
}
