package menu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import objects.Band;

public class BandMenu {
    private List<Band> bands = new ArrayList<>();
    private int bandIdCounter = 1;
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    public void displayBandMenu() {
        int choice;

        do {
            System.out.println("Band Menu:");
            System.out.println("1. Generate Bands");
            System.out.println("2. View Bands");
            System.out.println("3. Hire Band");
            System.out.println("0. Back to Main Menu");

            System.out.print("Enter your choice: ");
            try {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        generateBands();
                        break;
                    case 2:
                        viewBands();
                        break;
                    case 3:
                        hireBand();
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

    private void generateBands() {
        String[] names = {"BandA", "BandB", "BandC", "BandD", "BandE"};
        String[] styles = {"Rock", "Pop", "Jazz", "Metal", "Folk"};
        String[] countries = {"USA", "UK", "France", "Germany", "Japan"};

        bands.clear();

        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            String style = styles[i];
            String country = countries[i];
            boolean available = random.nextBoolean();

            Band band = new Band(bandIdCounter++, name, style, country, available);
            bands.add(band);
        }

        System.out.println("Bands generated successfully.");
    }

    private void viewBands() {
        System.out.println("List of bands:");
        System.out.println("ID | Name | Style | Country | Available");
        for (Band band : bands) {
            System.out.println(band.getId() + " | " + band.getName() + " | " + band.getStyle() + " | " + band.getCountry() + " | " + (band.isAvailable() ? "Yes" : "No"));
        }
    }

    private void hireBand() {
        System.out.println("Available bands for hire:");
        System.out.println("ID | Name | Style | Country");
        for (Band band : bands) {
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
        for (Band band : bands) {
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
