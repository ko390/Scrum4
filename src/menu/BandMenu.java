package menu;

import crud.BrandCRUD;
import objects.Band;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BandMenu {
    public static List<Band> bands = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

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
                        BrandCRUD.generateBands();
                        break;
                    case 2:
                        BrandCRUD.viewBands();
                        break;
                    case 3:
                        BrandCRUD.hireBand();
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
