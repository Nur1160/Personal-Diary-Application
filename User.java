import java.util.HashMap;
import java.util.Map;

public class User {
    private String username;
    private String password;
    private static Map<String, User> users = new HashMap<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static boolean register(String username, String password) {
        if (users.containsKey(username)) {
            return false; // User already exists
        }
        users.put(username, new User(username, password));
        return true;
    }

    public static User login(String username, String password) {
        User user = users.get(username);
        if (user != null && user.password.equals(password)) {
            return user;
        }
        return null; // Invalid credentials
    }

    public void logout() {
        // Handle logout logic if necessary
    }

    // Getters and other methods
}
