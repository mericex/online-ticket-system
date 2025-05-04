package ticketing.system;

import java.util.List;
import java.util.ArrayList;
public class TestMain {
    public static void main(String[] args) {
        // Firm event creation
        System.out.println("🎤 [1] Firm creates event...");
        EventManager eventManager = new EventManager();
        Event concert = new Event("Jazz Night", "2025-05-25", "Istanbul Arena", "concert");
        concert.addTicket(new Ticket("VIP", 800.0, 50));
        concert.addTicket(new Ticket("Regular", 400.0, 100));
        eventManager.addEvent(concert);

        // Search events
        System.out.println("\n🔍 [2] User searches event between 2025-05-01 and 2025-06-01...");
        List<Event> results = eventManager.searchEventsByDate("2025-05-01", "2025-06-01");
        for (Event e : results) {
            System.out.println("- " + e.getName() + " on " + e.getDate());
        }

        // Guest reserves ticket
        ReservationManager reservationManager = new ReservationManager();
        System.out.println("\n👤 [3] Guest reserves Regular ticket...");
        Reservation guestReservation = reservationManager.makeReservation(concert, concert.getTickets().get(1), "guest@example.com");
        System.out.println("Reservation ID: " + guestReservation.getReservationId());

        // Logged-in user reserves
        System.out.println("\n👥 [4] Ali logs in and reserves VIP ticket...");
        User ali = new User("Ali", "ali@example.com");
        ali.login();
        Reservation aliReservation = reservationManager.makeReservation(concert, concert.getTickets().get(0), ali.getEmail());
        System.out.println("Reservation ID: " + aliReservation.getReservationId());

        // Show Ali's history
        System.out.println("\n📜 [5] Ali's reservation history:");
        List<Reservation> history = reservationManager.getReservationsForUser(ali.getEmail());
        for (Reservation r : history) {
            System.out.println("- " + r.getEvent().getName() + " (" + r.getTicket().getCategory() + "), Code: " + r.getReservationId());
        }

        // Save data
        System.out.println("\n💾 [6] Saving data to files...");
        DataManager.saveEvents(eventManager.getEvents(), "events.txt");
        List<User> users = new ArrayList<>();
        users.add(ali);
        DataManager.saveUsers(users, "users.txt");
        DataManager.saveReservations(history, "reservations.txt");
        System.out.println("✅ Data saved.");
    }
}