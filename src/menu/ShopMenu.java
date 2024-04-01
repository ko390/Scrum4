package menu;

import java.util.InputMismatchException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import objects.ShopItem;

public class ShopMenu {
    private List<ShopItem> shopItems = new ArrayList<>();
    private int itemIdCounter = 1;

    public void displayShopMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Shop Menu:");
            System.out.println("1. Add Item");
            System.out.println("2. View Items");
            System.out.println("0. Back to Main Menu");

            System.out.print("Enter your choice: ");
            try {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        addItem();
                        break;
                    case 2:
                        viewItems();
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
                choice = -1; // Reset choice to force re-prompt
            }
        } while (choice != 0);

        scanner.close();
    }

    private void addItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adding a new item:");
        System.out.print("Enter item name: ");
        String name = scanner.nextLine();
        System.out.print("Enter item price: ");
        double price;
        try {
            price = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter a valid price.");
            scanner.nextLine();
            return; // Return without adding the item
        }

        ShopItem item = new ShopItem(itemIdCounter++, name, price);
        shopItems.add(item);

        System.out.println("Item added successfully.");
    }

    private void viewItems() {
        System.out.println("List of items:");
        System.out.println("ID | Name | Price");
        for (ShopItem item : shopItems) {
            System.out.println(item.getId() + " | " + item.getName() + " | " + item.getPrice());
        }
    }
}
