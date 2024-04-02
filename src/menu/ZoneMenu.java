package menu;

import java.util.InputMismatchException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import objects.Zone;

public class ZoneMenu {
    private List<Zone> zones = new ArrayList<>();
    private int zoneIdCounter = 1;

    public void displayZoneMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Zone Menu:");
            System.out.println("1. Add Zone");
            System.out.println("2. View Zones");
            System.out.println("0. Back to Main Menu");

            System.out.print("Enter your choice: ");
            try {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        addZone();
                        break;
                    case 2:
                        viewZones();
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

    private void addZone() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adding a new zone:");
        System.out.print("Enter zone name: ");
        String name = scanner.nextLine();
        System.out.print("Is the zone VIP? (true/false): ");
        boolean vip;
        try {
            vip = scanner.nextBoolean();
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter 'true' or 'false'.");
            scanner.nextLine();
            return; // Return without adding the zone
        }

        Zone zone = new Zone(zoneIdCounter++, name, vip);
        zones.add(zone);

        System.out.println("Zone added successfully.");
    }

    private void viewZones() {
        System.out.println("List of zones:");
        System.out.println("ID | Name | VIP");
        for (Zone zone : zones) {
            System.out.println(zone.getId() + " | " + zone.getName() + " | " + zone.isVip());
        }
    }
}
