package app.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginManager {
    private List<Login> logins;

    public LoginManager() {
        this.logins = new ArrayList<>();
        logins.add(new Login("admin", "admin123"));
        logins.add(new Login("user", "user123"));
    }

    public boolean login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (Login login : logins) {
            if (login.getUsername().equals(username) && login.getPassword().equals(password)) {
                System.out.println("Login successful!");
                return true;
            }
        }

        System.out.println("Invalid username or password. Please try again.");
        return false;
    }
}
