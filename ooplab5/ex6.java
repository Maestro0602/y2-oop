import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Ex6User {
    private final String firstName;
    private final String lastName;
    private final String username;
    private final String email;
    private final String password;

    public Ex6User(String firstName, String lastName, String username, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String toFileFormat() {
        return firstName + "|" + lastName + "|" + username + "|" + email + "|" + password;
    }

    public static Ex6User fromFileFormat(String line) {
        String[] parts = line.split("\\|");
        return new Ex6User(parts[0], parts[1], parts[2], parts[3], parts[4]);
    }
}

class Ex6AuthManager {
    private static final String USER_FILE = "user.txt";
    private final List<Ex6User> users;

    public Ex6AuthManager() {
        this.users = new ArrayList<>();
        loadUsersFromFile();
    }

    private void loadUsersFromFile() {
        File file = new File(USER_FILE);
        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                users.add(Ex6User.fromFileFormat(line));
            }
        } catch (IOException e) {
            System.out.println("Error reading user file: " + e.getMessage());
        }
    }

    private void saveUsersToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FILE))) {
            for (Ex6User user : users) {
                writer.write(user.toFileFormat());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to user file: " + e.getMessage());
        }
    }

    public void register(Scanner sc) {
        System.out.println("==== Register a new user ====");

        System.out.print("First Name: ");
        String firstName = sc.nextLine().trim();

        System.out.print("Last Name: ");
        String lastName = sc.nextLine().trim();

        System.out.print("Username: ");
        String username = sc.nextLine().trim();

        if (findByUsername(username) != null) {
            System.out.println("Username already exists. Please try another.\n");
            return;
        }

        System.out.print("Email: ");
        String email = sc.nextLine().trim();

        if (findByEmail(email) != null) {
            System.out.println("Email already exists. Please try another.\n");
            return;
        }

        System.out.print("Password: ");
        String password = sc.nextLine().trim();

        users.add(new Ex6User(firstName, lastName, username, email, password));
        saveUsersToFile();
        System.out.println("You are successfully registered~\n");
    }

    public void login(Scanner sc) {
        System.out.println("==== Login ====");

        System.out.print("Email or Username: ");
        String emailOrUsername = sc.nextLine().trim();

        System.out.print("Password: ");
        String password = sc.nextLine().trim();

        Ex6User user = findByUsernameOrEmail(emailOrUsername);

        if (user == null || !user.getPassword().equals(password)) {
            System.out.println("User not found. Please try again\n");
            return;
        }

        displayUserInfo(user);
    }

    private Ex6User findByUsername(String username) {
        for (Ex6User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    private Ex6User findByEmail(String email) {
        for (Ex6User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    private Ex6User findByUsernameOrEmail(String input) {
        Ex6User user = findByUsername(input);
        if (user != null) {
            return user;
        }
        return findByEmail(input);
    }

    private void displayUserInfo(Ex6User user) {
        System.out.println("=========== User Info ===========");
        System.out.println("Hi " + user.getFirstName() + ",");
        System.out.println("Your username is: " + user.getUsername());
        System.out.println("Your email is: " + user.getEmail());
        System.out.println();
    }
}

public class ex6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ex6AuthManager authManager = new Ex6AuthManager();

        while (true) {
            System.out.println("==== Menu ====");
            System.out.println("1.  Login");
            System.out.println("2.  Register");
            System.out.println("3.  Quit");
            System.out.print("Choose an option: ");

            String choice = sc.nextLine().trim();
            System.out.println();

            switch (choice) {
                case "1":
                    authManager.login(sc);
                    break;
                case "2":
                    authManager.register(sc);
                    break;
                case "3":
                    System.out.println("BYE BYE!!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option. Please choose 1-3.\n");
                    break;
            }
        }
    }
}
