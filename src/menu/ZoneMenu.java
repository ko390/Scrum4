package menu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import crud.ZoneCRUD;
import entities.Zone;

public class ZoneMenu {

    public static List<Zone> zones = new ArrayList<>();

    private Scanner scanner = new Scanner(System.in);

    public void displayZoneMenu() {
        int choice;

        do {
            System.out.println("Zone Menu:");
            System.out.println("1. Add Zone");
            System.out.println("2. View Zones");
            System.out.println("3. Remove Zone");
            System.out.println("4. Update Zone");
            System.out.println("0. Back to Main Menu");

            System.out.print("Enter your choice: ");
            try {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        ZoneCRUD.addZone();
                        break;
                    case 2:
                        ZoneCRUD.viewZones();
                        break;
                    case 3:
                        ZoneCRUD.removeZone();
                        break;
                    case 4:
                        ZoneCRUD.updateZone();
                        break;
                    case 0:
                        System.out.println("Returning to Main Menu...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input. Please enter a valid number.");
                scanner.nextLine();
                choice = -1;
            }
        } while (choice != 0);
    }


}
