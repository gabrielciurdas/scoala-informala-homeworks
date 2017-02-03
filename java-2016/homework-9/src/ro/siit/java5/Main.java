package ro.siit.java5;

/**
* Created by Gabi on 2/3/2017.
*/
public class Main {

public static void main(String[] args) {

    FestivalGate gate = new FestivalGate();
    TicketType ticketType = new TicketType();// this should be enum value randomly generated.
    FestivalAttendeeThread festivalAttendee = new FestivalAttendeeThread(ticketType, gate);

    System.out.println(ticketType.getTicketType());
}
}
