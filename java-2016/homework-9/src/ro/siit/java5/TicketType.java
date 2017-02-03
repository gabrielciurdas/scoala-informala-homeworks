package ro.siit.java5;

import java.util.Random;

/**
 * Created by Gabi on 2/3/2017.
 */
public class TicketType {

    Random random = new Random();
    Ticket[] tickets = Ticket.values();
    Ticket ticketType = tickets[random.nextInt(5)];

    public Ticket getTicketType() {
        return ticketType;
    }
}
