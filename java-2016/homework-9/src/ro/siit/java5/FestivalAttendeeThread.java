package ro.siit.java5;

/**
 * This class represents a Person attending a Festival.
 * It contains a TicketType and a common resource with
 * FestivalStatisticsThread - the EestivalGate object.
 *
 * @author Gabriel Ciurdaș
 *         <p> Created on 03/02/2017. </p>
 */
public class FestivalAttendeeThread extends Thread {

    private TicketType ticketType = new TicketType();
    private FestivalGate gate;

    /**
     * A constructor for FestivalAttendeeThread with two parameters.
     *
     * @param ticketType is the TicketType instance for the FestivalAttendeeThread
     *                   to be constructed with.
     * @param gate is the FestivalGate instance for the FestivalAttendeeThread
     *             to be constructed with.
     */
    public FestivalAttendeeThread(TicketType ticketType, FestivalGate gate) {
        this.ticketType = ticketType;
        this.gate = gate;
    }

    /**
     * A constructor for FestivalAttendeeThread with one parameter.
     *
     * @param gate is the FestivalGate instance for the FestivalAttendeeThread
     *             to be constructed with.
     */
    public FestivalAttendeeThread(FestivalGate gate) {
        ticketType = new TicketType();
        this.gate = gate;
    }

    /**
     * The overrided method of Thread which calls gate, the instantiated
     * FestivalGate object, to add a TicketType to a queue list.
     */
    @Override
    public void run() {
        try {
            gate.addTicket(ticketType);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
