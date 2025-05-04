package ticketing.system;

public class Ticket {
    private String category;
    private double price;
    private int quantity;

    public Ticket(String category, double price, int quantity) {
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}