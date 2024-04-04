package menu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import objects.Zone;

public class ZoneMenu {
    private static final int MAX_ZONES = 10;
    private List<Zone> zones = new ArrayList<>();
    private int zoneIdCounter = 1;
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
                        addZone();
                        break;
                    case 2:
                        viewZones();
                        break;
                    case 3:
                        removeZone();
                        break;
                    case 4:
                        updateZone();
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
        if (zones.size() >= MAX_ZONES) {
            System.out.println("Error: Maximum number of zones reached. Cannot add more zones.");
            return;
        }

        scanner.nextLine();
        System.out.println("Adding a new zone:");
        System.out.print("Enter zone name: ");
        String name = scanner.nextLine();
        System.out.print("Enter zone capacity: ");
        int capacity;
        try {
            capacity = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter a valid capacity.");
            scanner.nextLine();
            return;
        }

        Zone zone = new Zone(zoneIdCounter++, name, capacity, false);
        zones.add(zone);

        System.out.println("Zone added successfully.");
    }

    private void viewZones() {
        System.out.println("List of zones:");
        System.out.println("ID | Name | Capacity");
        for (Zone zone : zones) {
            System.out.println(zone.getId() + " | " + zone.getName() + " | " + zone.getCapacity());
        }
    }

    private void removeZone() {
        System.out.print("Enter the ID of the zone to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean removed = false;
        for (Zone zone : zones) {
            if (zone.getId() == id) {
                zones.remove(zone);
                removed = true;
                break;
            }
        }

        if (removed) {
            System.out.println("Zone removed successfully.");
        } else {
            System.out.println("Error: Zone with ID " + id + " not found.");
        }
    }

    private void updateZone() {
        System.out.print("Enter the ID of the zone to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean updated = false;
        for (Zone zone : zones) {
            if (zone.getId() == id) {
                System.out.println("Updating zone " + zone.getName() + ":");
                System.out.print("Enter new name: ");
                String name = scanner.nextLine();
                System.out.print("Enter new capacity: ");
                int capacity = scanner.nextInt();
                scanner.nextLine();
                zone.setName(name);
                zone.setCapacity(capacity);
                updated = true;
                break;
            }
        }

        if (updated) {
            System.out.println("Zone updated successfully.");
        } else {
            System.out.println("Error: Zone with ID " + id + " not found.");
        }
    }
}
