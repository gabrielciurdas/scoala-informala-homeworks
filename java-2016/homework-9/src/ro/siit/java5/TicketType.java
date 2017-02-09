package ro.siit.java5;

import java.util.Random;

/**
 * Created by Gabi on 2/3/2017.
 */
public class TicketType {

    Random random;
    Ticket[] tickets;
    Ticket ticket;

    public TicketType() {
        random = new Random();
        tickets = Ticket.values();
        ticket = tickets[random.nextInt(5)];
    }
    public Ticket getTicket() {
        return ticket;
    }
}
