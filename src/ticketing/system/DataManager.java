package ticketing.system;

import java.io.*;
import java.util.*;

public class DataManager {

    // === EVENTS ===
    public static void saveEvents(List<Event> events, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Event e : events) {
                writer.write(e.getName() + ";" + e.getDate() + ";" + e.getLocation() + ";" + e.getEventType());
                for (Ticket t : e.getTickets()) {
                    writer.write(";" + t.getCategory() + "," + t.getPrice() + "," + t.getQuantity());
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Event> loadEvents(String filename) {
        List<Event> events = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length < 4) continue;

                Event event = new Event(parts[0], parts[1], parts[2], parts[3]);

                for (int i = 4; i < parts.length; i++) {
                    String[] ticketParts = parts[i].split(",");
                    if (ticketParts.length == 3) {
                        Ticket t = new Ticket(ticketParts[0], Double.parseDouble(ticketParts[1]), Integer.parseInt(ticketParts[2]));
                        event.addTicket(t);
                    }
                }
                events.add(event);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return events;
    }

    // === USERS ===
    public static void saveUsers(List<User> users, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (User u : users) {
                writer.write(u.getName() + ";" + u.getEmail() + ";" + u.isLoggedIn());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // === RESERVATIONS ===
    public static void saveReservations(List<Reservation> reservations, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Reservation r : reservations) {
                writer.write(r.getReservationId() + ";" +
                             r.getEvent().getName() + ";" +
                             r.getTicket().getCategory() + ";" +
                             r.getUserEmail());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}