package ticketing.system;

public class User {
    private String name;
    private String email;
    private boolean isLoggedIn;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.isLoggedIn = false;
    }

    public void login() {
        isLoggedIn = true;
    }

    public void logout() {
        isLoggedIn = false;
    }

    public boolean isLoggedIn() { return isLoggedIn; }

    public String getName() { return name; }
    public String getEmail() { return email; }
}