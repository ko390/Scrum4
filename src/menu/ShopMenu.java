package menu;

import java.util.InputMismatchException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import objects.ShopItem;

public class ShopMenu {
    private List<ShopItem> shopItems = new ArrayList<>();
    private int itemIdCounter = 1;
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
                        addItem();
                        break;
                    case 2:
                        viewItems();
                        break;
                    case 3:
                        removeItem();
                        break;
                    case 4:
                        updateItem();
                        break;
                    case 5:
                        addConsumption();
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

    private void addItem() {
        scanner.nextLine();
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
            return;
        }

        ShopItem item = new ShopItem(itemIdCounter++, name, price);
        shopItems.add(item);

        System.out.println("Item added successfully.");
    }

    private void viewItems() {
        System.out.println("List of items:");
        System.out.println("ID | Name | Price | Total Sold | Total Price");
        for (ShopItem item : shopItems) {
            System.out.println(item.getId() + " | " + item.getName() + " | " + item.getPrice() + " | " + item.getNumberSold() + " | " + item.getTotalPrice());
        }
    }

    private void removeItem() {
        System.out.print("Enter the ID of the item to remove: ");
        int id = scanner.nextInt();
        boolean removed = false;
        for (ShopItem item : shopItems) {
            if (item.getId() == id) {
                shopItems.remove(item);
                removed = true;
                System.out.println("Item removed successfully.");
                break;
            }
        }
        if (!removed) {
            System.out.println("Item with ID " + id + " not found.");
        }
    }

    private void updateItem() {
        System.out.print("Enter the ID of the item to update: ");
        int id = scanner.nextInt();
        boolean updated = false;
        for (ShopItem item : shopItems) {
            if (item.getId() == id) {
                scanner.nextLine();
                System.out.print("Enter new name for the item: ");
                String newName = scanner.nextLine();
                System.out.print("Enter new price for the item: ");
                double newPrice = scanner.nextDouble();
                item.setName(newName);
                item.setPrice(newPrice);
                updated = true;
                System.out.println("Item updated successfully.");
                break;
            }
        }
        if (!updated) {
            System.out.println("Item with ID " + id + " not found.");
        }
    }

    private void addConsumption() {
        System.out.println("Available items:");
        viewItems();
        System.out.print("Select item ID: ");
        int id = scanner.nextInt();
        for (ShopItem item : shopItems) {
            if (item.getId() == id) {
                System.out.print("Enter number of items sold: ");
                int consumption = scanner.nextInt();
                item.setNumberSold(item.getNumberSold() + consumption);
                double totalPrice = item.getTotalPrice() + (consumption * item.getPrice());
                item.setTotalPrice(totalPrice);
                System.out.println("Consumption added successfully.");
                return;
            }
        }
        System.out.println("Item with ID " + id + " not found.");
    }
}
