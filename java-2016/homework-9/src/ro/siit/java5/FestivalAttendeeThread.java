package ro.siit.java5;

import java.util.concurrent.TimeUnit;

/**
 * Created by Gabi on 2/3/2017.
 */
public class FestivalAttendeeThread extends Thread {

    private TicketType ticketType = new TicketType();
    private FestivalGate gate;

    public FestivalAttendeeThread(TicketType ticketType, FestivalGate gate) {
        this.ticketType = ticketType;
        this.gate = gate;
    }

    public FestivalAttendeeThread(FestivalGate gate) {
        ticketType = new TicketType();
        this.gate = gate;
    }

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(5000);
            gate.addTicket(ticketType);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
