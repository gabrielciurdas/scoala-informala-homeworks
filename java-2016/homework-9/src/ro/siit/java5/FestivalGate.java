package ro.siit.java5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Gabi on 2/3/2017.
 */
public class FestivalGate extends Counter {

    private LinkedBlockingQueue<TicketType> queue = new LinkedBlockingQueue<>();
    private List<String> festivalStatistics = new ArrayList<>();

    public FestivalGate() {
        super();
        queue = new LinkedBlockingQueue<>();
    }

    public LinkedBlockingQueue<TicketType> getQueue() {
        return queue;
    }

    public synchronized void setStatistics(String statistics) {
        festivalStatistics.add(statistics);
    }

    public void displayStatistics() {
        for (String s: festivalStatistics) {
            System.out.println(s);
        }
    }

    public List<String> getFestivalStatistics() {
        return festivalStatistics;
    }

    public synchronized void addTicket(TicketType ticketType) throws InterruptedException {
        System.out.println("Festival attendee #" + (queue.size() + 1) +
                " with " + ticketType.getTicket() + " ticket is next on queue") ;
        if(isValid(ticketType.getTicket()) && queue.size() <= getNumberOfAttendees()) {
            queue.add(ticketType);
            System.out.println("#" + queue.size() + " validated");
        } else {
            throw new IllegalArgumentException("Invalid ticket!");
        }
    }

    public synchronized ArrayList<Ticket> getTicketsFromQueue() throws InterruptedException {
        ArrayList<Ticket> tickets = new ArrayList<>();
        for(TicketType t: queue) {
            tickets.add(t.getTicket());
        }
        return tickets;
    }

    public boolean isValid(Ticket ticket) {
        boolean valid = false;
        for(Ticket t: Ticket.values()) {
            if(ticket.equals(t)) {
                valid = true;
            }
        }
        return valid;
    }
}