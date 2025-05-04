package ticketing.system;

public class Firm {
    private String name;

    public Firm(String name) {
        this.name = name;
    }

    public Event createEvent(String eventName, String date, String location, String eventType) {
        return new Event(eventName, date, location, eventType);
    }

    public String getName() {
        return name;
    }
}