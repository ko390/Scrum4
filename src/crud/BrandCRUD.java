package crud;

import menu.BandMenu;
import entities.Band;

import java.util.Random;
import java.util.Scanner;

public class BrandCRUD {
    private static int bandIdCounter = 1;
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void generateBands() {
        String[] names = {"BandA", "BandB", "BandC", "BandD", "BandE"};
        String[] styles = {"Rock", "Pop", "Jazz", "Metal", "Folk"};
        String[] countries = {"USA", "UK", "France", "Germany", "Japan"};

        BandMenu.bands.clear();

        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            String style = styles[i];
            String country = countries[i];
            boolean available = random.nextBoolean();

            Band band = new Band(bandIdCounter++, name, style, country, available);
            BandMenu.bands.add(band);
        }

        System.out.println("Bands generated successfully.");
    }

    public static void viewBands() {
        System.out.println("List of bands:");
        System.out.println("ID | Name | Style | Country | Available");
        for (Band band : BandMenu.bands) {
            System.out.println(band.getId() + " | " + band.getName() + " | " + band.getStyle() + " | " + band.getCountry() + " | " + (band.isAvailable() ? "Yes" : "No"));
        }
    }

    public static void hireBand() {

        System.out.println("Available bands for hire:");
        System.out.println("ID | Name | Style | Country");
        for (Band band : BandMenu.bands) {
            if (band.isAvailable()) {
                System.out.println(band.getId() + " | " + band.getName() + " | " + band.getStyle() + " | " + band.getCountry());
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
