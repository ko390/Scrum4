package crud;

import entities.Client;
import menu.BandMenu;
import entities.Band;
import menu.ClientMenu;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BandCRUD {
    private static int bandIdCounter = 1;
    private static Scanner scanner = new Scanner(System.in);

    public static void generateBands() {
        System.out.println("Adding a new band:");
        System.out.print("Enter band name: ");
        String name = scanner.nextLine();

        System.out.print("Enter band genre: ");
        String genre = scanner.nextLine();

        System.out.print("Enter client country: ");
        String country = scanner.nextLine();

        System.out.print("Estan disponibles? ");
        String available = scanner.nextLine();

        Band band = new Band(bandIdCounter++, name, genre, country, available);
        BandMenu.bands.add(band);

        System.out.println("Band added successfully.");
    }

    public static void viewBands() {
        System.out.println("List of bands:");
        System.out.println("ID | Name | Style | Country | Available");
        for (Band band : BandMenu.bands) {
            System.out.println(band.getId() + " | " + band.getName() + " | " + band.getGenre() + " | " + band.getCountry() + " | " + (band.isAvailable() ? "Yes" : "No"));
        }
    }

    public static void hireBand() {
        System.out.println("Available bands for hire:");
        System.out.println("ID | Name | Style | Country");
        for (Band band : BandMenu.bands) {
            if (band.isAvailable()) {
                System.out.println(band.getId() + " | " + band.getName() + " | " + band.getGenre() + " | " + band.getCountry());
            }
        }

        System.out.print("Enter the ID of the band you want to hire (or 0 to cancel): ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (id == 0) {
            System.out.println("Hiring canceled.");
            return;
        }

        boolean hired = false;
        for (Band band : BandMenu.bands) {
            if (band.getId() == id && band.isAvailable()) {
                hired = true;
                band.setAvailable(false);
                System.out.println("Band " + band.getName() + " hired successfully.");
                break;
            }
        }

        if (!hired) {
            System.out.println("Error: Band not available or ID not found.");
        }
    }
}
