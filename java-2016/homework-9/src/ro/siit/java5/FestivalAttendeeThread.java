package ro.siit.java5;

/**
 * Created by Gabi on 2/3/2017.
 */
public class FestivalAttendeeThread {
    TicketType ticketType = new TicketType();
    FestivalGate gate = new FestivalGate();

    public FestivalAttendeeThread(TicketType ticketType, FestivalGate gate) {
        this.ticketType = ticketType;
        this.gate = gate;
    }
}
