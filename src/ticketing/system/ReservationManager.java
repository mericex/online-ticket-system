package ticketing.system;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ReservationManager {
    private List<Reservation> reservations;

    public ReservationManager() {
        reservations = new ArrayList<>();
    }

    public String generateReservationId() {
        return "RES" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public Reservation makeReservation(Event event, Ticket ticket, String userEmail) {
        if (ticket.getQuantity() <= 0) {
            System.out.println("No tickets left!");
            return null;
        }

        String id = generateReservationId();
        ticket.setQuantity(ticket.getQuantity() - 1); // reduce ticket count
        Reservation r = new Reservation(id, event, ticket, userEmail);
        reservations.add(r);
        return r;
    }

    public List<Reservation> getReservationsForUser(String email) {
        List<Reservation> result = new ArrayList<>();
        for (Reservation r : reservations) {
            if (r.getUserEmail().equalsIgnoreCase(email)) {
                result.add(r);
            }
        }
        return result;
    }
}