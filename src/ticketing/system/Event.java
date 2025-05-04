package ticketing.system;

import java.util.ArrayList;
import java.util.List;

public class Event {
    private String name;
    private String date;
    private String location;
    private String eventType; // concert, sports, theatre
    private List<Ticket> tickets; // different categories

    public Event(String name, String date, String location, String eventType) {
        this.name = name;
        this.date = date;
        this.location = location;
        this.eventType = eventType;
        this.tickets = new ArrayList<>();
    }

    public String getName() { return name; }
    public String getDate() { return date; }
    public String getLocation() { return location; }
    public String getEventType() { return eventType; }

    public List<Ticket> getTickets() { return tickets; }

    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }

    public void setName(String name) { this.name = name; }
    public void setDate(String date) { this.date = date; }
    public void setLocation(String location) { this.location = location; }
    public void setEventType(String eventType) { this.eventType = eventType; }
}