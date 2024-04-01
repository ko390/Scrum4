package app.zoneManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ZoneManager {
    private List<Zone> zones;
    private int zoneIdCounter = 1;

    public ZoneManager() {
        this.zones = new ArrayList<>();
    }

    public void addZone() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adding a new zone:");
        System.out.print("Enter zone name: ");
        String name = scanner.nextLine();
        System.out.print("Is the zone VIP? (true/false): ");
        boolean vip = scanner.nextBoolean();

        Zone zone = new Zone(zoneIdCounter++, name, vip);
        zones.add(zone);

        System.out.println("Zone added successfully.");
    }

    public void viewZones() {
        System.out.println("List of zones:");
        System.out.println("ID | Name | VIP");
        for (Zone zone : zones) {
            System.out.println(zone.getId() + " | " + zone.getName() + " | " + zone.isVip());
        }
    }
}
