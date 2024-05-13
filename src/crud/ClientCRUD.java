package crud;

import menu.ClientMenu;
import entities.Client;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ClientCRUD {

    private static Scanner scanner = new Scanner(System.in);
    private static int clientIdCounter = 1;
    public static void addClient() {
        System.out.println("Adding a new client:");
        System.out.print("Enter client name: ");
        String name = scanner.nextLine();

        System.out.print("Enter client surname: ");
        String surname = scanner.nextLine();

        int age;
        while (true) {
            try {
                System.out.print("Enter client age: ");
                age = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid age.");
                scanner.nextLine();
            }
        }

        System.out.print("Enter client DNI: ");
        String dni = scanner.nextLine();

        System.out.print("Enter client entry type (VIP/GENERAL/FREE): ");
        String entryType = scanner.nextLine();

        Client client = new Client(clientIdCounter++, name, surname, age, dni, entryType);
        ClientMenu.clients.add(client);

        System.out.println("Client added successfully.");
    }

    public static void viewClients() {
        System.out.println("List of clients:");
        System.out.println("ID | Name | Surname | Age | DNI | Entry Type");
        for (Client client : ClientMenu.clients) {
            System.out.println(client.getId() + " | " + client.getName() + " | " + client.getSurname() + " | " + client.getAge() + " | " + client.getDni() + " | " + client.getEntryType());
        }
    }

    public static void removeClient() {
        System.out.print("Enter the ID of the client to remove: ");
        int id = scanner.nextInt();
        boolean removed = false;
        for (Client client : ClientMenu.clients) {
            if (client.getId() == id) {
                ClientMenu.clients.remove(client);
                removed = true;
                System.out.println("Client removed successfully.");
                break;
            }
        }
        if (!removed) {
            System.out.println("Client with ID " + id + " not found.");
        }
    }

    public static void updateClient() {
        System.out.print("Enter the ID of the client to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        boolean updated = false;
        for (Client client : ClientMenu.clients) {
            if (client.getId() == id) {
                System.out.println("Updating client " + client.getName() + ":");
                System.out.print("Enter new name: ");
                String newName = scanner.nextLine();
                System.out.print("Enter new surname: ");
                String newSurname = scanner.nextLine();
                System.out.print("Enter new age: ");
                int newAge = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Enter new DNI: ");
                String newDni = scanner.nextLine();
                System.out.print("Enter new entry type (VIP/GENERAL/FREE): ");
                String newEntryType = scanner.nextLine();

                client.setName(newName);
                client.setSurname(newSurname);
                client.setAge(newAge);
                client.setDni(newDni);
                client.setEntryType(newEntryType);

                updated = true;
                System.out.println("Client updated successfully.");
                break;
            }
        }
        if (!updated) {
            System.out.println("Client with ID " + id + " not found.");
        }
    }
}
