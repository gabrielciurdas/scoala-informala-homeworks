package ro.siit.java5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * This class simulates a Festival Gate. It contains a queue list
 * of TicketType objects which were validated. Also, it keeps a
 * list of statistical data which are generated every 5 seconds.
 *
 * @author Gabriel Ciurdaș
 *         <p> Created on 03/02/2017. </p>
 */
public class FestivalGate extends Counter {

    private LinkedBlockingQueue<TicketType> queue;
    private List<String> festivalStatistics;

    /**
     * A default Constructor for a FestivalGate object. A queue list
     * is instantiated as a LinkedBlockingQueue and a list of statistical
     * data is instantiated as an ArrayList.
     */
    public FestivalGate() {
        super();
        queue = new LinkedBlockingQueue<>();
        festivalStatistics = new ArrayList<>();
    }

    /**
     * Displays the generated list of statistical data for the validated
     * Tickets types.
     */
    public void displayStatistics() {
        for (String s: festivalStatistics) {
            System.out.println(s);
        }
    }

    /**
     * This method adds a Ticket to the queue list if it is validated.
     * Meanwhile, a message is displayed in the console with Ticket information.
     *
     * @param ticketType is the TicketType instance of TicketType object to be
     *                   validated and added to the queue list.
     * @throws InterruptedException if the current thread is interrupted.
     */
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

    /**
     * This method iterates over the queue list and adds Ticket objects
     * from each iteration to a Ticket list.
     *
     * @return a Ticket ArrayList.
     * @throws InterruptedException if the current thread is interrupted.
     */
    public synchronized ArrayList<Ticket> getTicketsFromQueue() throws InterruptedException {
        ArrayList<Ticket> tickets = new ArrayList<>();
        for(TicketType t: queue) {
            tickets.add(t.getTicket());
        }
        return tickets;
    }

    /**
     * Iterates over an array of Ticket enum values.
     * Each ticket is compared to the ticket parameter, if they are
     * the same, then the boolean is  set true and the Ticket is valid.
     *
     * @param ticket is the Ticket parameter to be checked if it is valid.
     * @return true or false, depending on the Ticket validity.
     */
    public boolean isValid(Ticket ticket) {
        boolean valid = false;
        for(Ticket t: Ticket.values()) {
            if(ticket.equals(t)) {
                valid = true;
            }
        }
        return valid;
    }

    public LinkedBlockingQueue<TicketType> getQueue() {
        return queue;
    }

    public synchronized void setStatistics(String statistics) {
        festivalStatistics.add(statistics);
    }

    public List<String> getFestivalStatistics() {
        return festivalStatistics;
    }
}