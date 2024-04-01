package app.bandContractor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BandContractorManager {
    private List<Band> bands;
    private int bandIdCounter = 1;

    public BandContractorManager() {
        this.bands = new ArrayList<>();
    }

    public void addBand() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adding a new band:");
        System.out.print("Enter band name: ");
        String name = scanner.nextLine();
        System.out.print("Enter band genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter band country: ");
        String country = scanner.nextLine();
        System.out.print("Is the band available? (true/false): ");
        boolean available = scanner.nextBoolean();

        Band band = new Band(bandIdCounter++, name, available, genre, country);
        bands.add(band);

        System.out.println("Band added successfully.");
    }

    public void viewBands() {
        System.out.println("List of bands:");
        System.out.println("ID | Name | Available | Genre | Country");
        for (Band band : bands) {
            System.out.println(band.getId() + " | " + band.getName() + " | " + band.isAvailable() + " | " +
                    band.getGenre() + " | " + band.getCountry());
        }
    }
}

