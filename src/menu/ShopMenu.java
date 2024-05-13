package menu;

import java.util.InputMismatchException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import crud.ShopCRUD;
import entities.ShopItem;

public class ShopMenu {
    public static List<ShopItem> shopItems = new ArrayList<>();

    private Scanner scanner = new Scanner(System.in);

    public void displayShopMenu() {
        int choice;

        do {
            System.out.println("Shop Menu:");
            System.out.println("1. Add Item");
            System.out.println("2. View Items");
            System.out.println("3. Remove Item");
            System.out.println("4. Update Item");
            System.out.println("5. Add Consumption");
            System.out.println("0. Back to Main Menu");

            System.out.print("Enter your choice: ");
            try {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        ShopCRUD.addItem();
                        break;
                    case 2:
                        ShopCRUD.viewItems();
                        break;
                    case 3:
                        ShopCRUD.removeItem();
                        break;
                    case 4:
                        ShopCRUD.updateItem();
                        break;
                    case 5:
                        ShopCRUD.addConsumption();
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
