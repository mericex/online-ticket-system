package ticketing.system;

public class Reservation {
    private String reservationId;
    private Event event;
    private Ticket ticket;
    private String userEmail;

    public Reservation(String reservationId, Event event, Ticket ticket, String userEmail) {
        this.reservationId = reservationId;
        this.event = event;
        this.ticket = ticket;
        this.userEmail = userEmail;
    }

    public String getReservationId() { return reservationId; }
    public Event getEvent() { return event; }
    public Ticket getTicket() { return ticket; }
    public String getUserEmail() { return userEmail; }
}