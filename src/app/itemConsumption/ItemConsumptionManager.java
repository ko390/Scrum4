package app.itemConsumption;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ItemConsumptionManager {
    private List<Item> items;
    private int itemIdCounter = 1;

    public ItemConsumptionManager() {
        this.items = new ArrayList<>();
    }

    public void addItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adding a new item:");
        System.out.print("Enter item name: ");
        String name = scanner.nextLine();
        System.out.print("Enter item price: ");
        double price = scanner.nextDouble();

        Item item = new Item(itemIdCounter++, name, price);
        items.add(item);

        System.out.println("Item added successfully.");
    }

    public void viewItems() {
        System.out.println("List of items:");
        System.out.println("ID | Name | Price");
        for (Item item : items) {
            System.out.println(item.getId() + " | " + item.getName() + " | " + item.getPrice());
        }
    }
}
