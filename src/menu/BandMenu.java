package menu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import objects.Band;

public class BandMenu {
    private List<Band> bands = new ArrayList<>();
    private int bandIdCounter = 1;
    private Scanner scanner = new Scanner(System.in);

    public void displayBandMenu() {
        int choice;

        do {
            System.out.println("Band Menu:");
            System.out.println("1. Add Band");
            System.out.println("2. View Bands");
            System.out.println("0. Back to Main Menu");

            System.out.print("Enter your choice: ");
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                choice = -1;
                continue;
            }

            switch (choice) {
                case 1:
                    addBand();
                    break;
                case 2:
                    viewBands();
                    break;
                case 0:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private void addBand() {
        System.out.println("Adding a new band:");
        System.out.print("Enter band name: ");
        String name = scanner.nextLine();

        System.out.print("Enter band genre: ");
        String genre = scanner.nextLine();

        System.out.print("Enter band country: ");
        String country = scanner.nextLine();

        boolean available;
        while (true) {
            System.out.print("Is the band available? (true/false): ");
            String availableInput = scanner.nextLine().toLowerCase();
            if (availableInput.equals("true") || availableInput.equals("false")) {
                available = Boolean.parseBoolean(availableInput);
                break;
            } else {
                System.out.println("Invalid input. Please enter 'true' or 'false'.");
            }
        }

        Band band = new Band(bandIdCounter++, name, available, genre, country);
        bands.add(band);

        System.out.println("Band added successfully.");
    }

    private void viewBands() {
        System.out.println("List of bands:");
        System.out.println("ID | Name | Available | Genre | Country");
        for (Band band : bands) {
            System.out.println(band.getId() + " | " + band.getName() + " | " + band.isAvailable() + " | " + band.getGenre() + " | " + band.getCountry());
        }
    }
}
