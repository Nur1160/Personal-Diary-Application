import java.util.Scanner;

public class Main {
    private static User currentUser;
    private static Diary diary = new Diary();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Logout");
            System.out.println("4. Create Diary Entry");
            System.out.println("5. View Diary Entries");
            System.out.println("6. Edit Diary Entry");
            System.out.println("7. Delete Diary Entry");
            System.out.println("8. Search Diary Entries");
            System.out.println("9. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    if (User.register(username, password)) {
                        System.out.println("Registration successful!");
                    } else {
                        System.out.println("Username already exists.");
                    }
                    break;
                case 2:
                    System.out.print("Enter username: ");
                    username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    password = scanner.nextLine();
                    currentUser = User.login(username, password);
                    if (currentUser != null) {
                        System.out.println("Login successful!");
                    } else {
                        System.out.println("Invalid credentials.");
                    }
                    break;
                case 3:
                    if (currentUser != null) {
                        currentUser.logout();
                        currentUser = null;
                        System.out.println("Logged out successfully.");
                    } else {
                        System.out.println("No user is logged in.");
                    }
                    break;
                case 4:
                    if (currentUser != null) {
                        System.out.print("Enter title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter content: ");
                        String content = scanner.nextLine();
                        DiaryEntry entry = new DiaryEntry(title, content);
                        diary.addEntry(entry);
                        System.out.println("Diary entry added.");
                    } else {
                        System.out.println("Please login first.");
                    }
                    break;
                case 5:
                    if (currentUser != null) {
                        for (DiaryEntry entry : diary.viewEntries()) {
                            System.out.println("Title: " + entry.getTitle());
                            System.out.println("Content: " + entry.getContent());
                            System.out.println("Date: " + entry.getDate());
                            System.out.println();
                        }
                    } else {
                        System.out.println("Please login first.");
                    }
                    break;
                case 6:
                    if (currentUser != null) {
                        System.out.print("Enter entry index to edit: ");
                        int index = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter new content: ");
                        String newContent = scanner.nextLine();
                        diary.editEntry(index, newContent);
                        System.out.println("Diary entry edited.");
                    } else {
                        System.out.println("Please login first.");
                    }
                    break;
                case 7:
                    if (currentUser != null) {
                        System.out.print("Enter entry index to delete: ");
                        int index = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        diary.deleteEntry(index);
                        System.out.println("Diary entry deleted.");
                    } else {
                        System.out.println("Please login first.");
                    }
                    break;
                case 8:
                    if (currentUser != null) {
                        System.out.print("Enter keyword to search: ");
                        String keyword = scanner.nextLine();
                        for (DiaryEntry entry : diary.searchEntries(keyword)) {
                            System.out.println("Title: " + entry.getTitle());
                            System.out.println("Content: " + entry.getContent());
                            System.out.println("Date: " + entry.getDate());
                            System.out.println();
                        }
                    } else {
                        System.out.println("Please login first.");
                    }
                    break;
                case 9:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
