package crud;

import entities.Zone;
import menu.ZoneMenu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ZoneCRUD {
    private static Scanner scanner = new Scanner(System.in);
    private static final int MAX_ZONES = 10;
    private static int zoneIdCounter = 1;
    public static void addZone() {
        if (ZoneMenu.zones.size() >= MAX_ZONES) {
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
        ZoneMenu.zones.add(zone);

        System.out.println("Zone added successfully.");
    }

    public static void viewZones() {
        System.out.println("List of zones:");
        System.out.println("ID | Name | Capacity");
        for (Zone zone : ZoneMenu.zones) {
            System.out.println(zone.getId() + " | " + zone.getName() + " | " + zone.getCapacity());
        }
    }

    public static void removeZone() {
        System.out.print("Enter the ID of the zone to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean removed = false;
        for (Zone zone : ZoneMenu.zones) {
            if (zone.getId() == id) {
                ZoneMenu.zones.remove(zone);
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

    public static void updateZone() {
        System.out.print("Enter the ID of the zone to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean updated = false;
        for (Zone zone : ZoneMenu.zones) {
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
