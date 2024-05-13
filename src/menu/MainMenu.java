package menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {
    public void displayMainMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMain Menu:");
            System.out.println("1. Client Menu");
            System.out.println("2. Employee Menu");
            System.out.println("3. Band Menu");
            System.out.println("4. Shop Menu");
            System.out.println("5. Zone Menu");
            System.out.println("0. Exit");

            try {
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                choice = -1;
            }

            switch (choice) {
                case 1:
                    ClientMenu clientMenu = new ClientMenu();
                    clientMenu.displayClientMenu();
                    break;
                case 2:
                    EmployeeMenu employeeMenu = new EmployeeMenu();
                    employeeMenu.displayEmployeeMenu();
                    break;
                case 3:
                    BandMenu bandMenu = new BandMenu();
                    bandMenu.displayBandMenu();
                    break;
                case 4:
                    ShopMenu shopMenu = new ShopMenu();
                    shopMenu.displayShopMenu();
                    break;
                case 5:
                    ZoneMenu zoneMenu = new ZoneMenu();
                    zoneMenu.displayZoneMenu();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
