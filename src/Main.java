import menu.MainMenu;
import app.login.LoginManager;

public class Main {
    public static void main(String[] args) {
        LoginManager loginManager = new LoginManager();

        boolean loggedIn = loginManager.login();

        if (loggedIn) {
            MainMenu mainMenu = new MainMenu();
            mainMenu.displayMainMenu();
        } else {
            System.out.println("Login failed. Exiting...");
        }
    }
}
