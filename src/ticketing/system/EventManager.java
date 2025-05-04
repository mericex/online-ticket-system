package ticketing.system;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EventManager {
    private List<Event> events;

    public EventManager() {
        events = new ArrayList<>();
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public List<Event> getEvents() {
        return events;
    }

    public List<Event> searchEventsByDate(String startDate, String endDate) {
        List<Event> results = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate start = LocalDate.parse(startDate, formatter);
        LocalDate end = LocalDate.parse(endDate, formatter);

        for (Event e : events) {
            LocalDate eventDate = LocalDate.parse(e.getDate(), formatter);
            if ((eventDate.isEqual(start) || eventDate.isAfter(start)) &&
                (eventDate.isEqual(end) || eventDate.isBefore(end))) {
                results.add(e);
            }
        }
        return results;
    }
}