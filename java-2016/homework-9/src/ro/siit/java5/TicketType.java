package ro.siit.java5;

import java.util.Random;

/**
 * This class contains an array of Tycket types
 * and is instantiated by a random Ticket.
 *
 * @author Gabriel Ciurdaș
 *         <p> Created on 03/02/2017. </p>
 */
public class TicketType {

    Random random;
    Ticket[] tickets;
    Ticket ticket;

    /**
     * A default constructor which instantiates the TicketType class.
     * Instantiates a Random object, a Ticket array with Ticket enumeration
     * values. Also, a ticket variable is instantied randomly by a Ticket value.
     */
    public TicketType() {
        random = new Random();
        tickets = Ticket.values();
        ticket = tickets[random.nextInt(5)];
    }

    /**
     * A constructor with a Ticket parameter which instantiates the TicketType class.
     * Instantiates a Random object, a Ticket array with Ticket enumeration
     * values. Also, a ticket variable is instantied with a given Ticket parameter.
     *
     * @param ticket is the Ticket instance for the TicketType
     *               to be constructed with.
     */
    public TicketType(Ticket ticket) {
        random = new Random();
        tickets = Ticket.values();
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return ticket;
    }
}
