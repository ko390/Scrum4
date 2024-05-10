package crud;

import menu.ShopMenu;
import objects.ShopItem;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ShopCRUD {
    private static int itemIdCounter = 1;
    private static Scanner scanner = new Scanner(System.in);
    public static void addItem() {
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
        ShopMenu.shopItems.add(item);

        System.out.println("Item added successfully.");
    }

    public static void viewItems() {
        System.out.println("List of items:");
        System.out.println("ID | Name | Price | Total Sold | Total Price");
        for (ShopItem item : ShopMenu.shopItems) {
            System.out.println(item.getId() + " | " + item.getName() + " | " + item.getPrice() + " | " + item.getNumberSold() + " | " + item.getTotalPrice());
        }
    }

    public static void removeItem() {
        System.out.print("Enter the ID of the item to remove: ");
        int id = scanner.nextInt();
        boolean removed = false;
        for (ShopItem item : ShopMenu.shopItems) {
            if (item.getId() == id) {
                ShopMenu.shopItems.remove(item);
                removed = true;
                System.out.println("Item removed successfully.");
                break;
            }
        }
        if (!removed) {
            System.out.println("Item with ID " + id + " not found.");
        }
    }

    public static void updateItem() {
        System.out.print("Enter the ID of the item to update: ");
        int id = scanner.nextInt();
        boolean updated = false;
        for (ShopItem item : ShopMenu.shopItems) {
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

    public static void addConsumption() {
        System.out.println("Available items:");
        viewItems();
        System.out.print("Select item ID: ");
        int id = scanner.nextInt();
        for (ShopItem item : ShopMenu.shopItems) {
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
