package menu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import objects.Client;

public class ClientMenu {
    private List<Client> clients = new ArrayList<>();
    private int clientIdCounter = 1;
    private Scanner scanner = new Scanner(System.in);

    public void displayClientMenu() {
        int choice;

        do {
            System.out.println("Client Menu:");
            System.out.println("1. Add Client");
            System.out.println("2. View Clients");
            System.out.println("3. Remove Client");
            System.out.println("4. Update Client");
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
                    addClient();
                    break;
                case 2:
                    viewClients();
                    break;
                case 3:
                    removeClient();
                    break;
                case 4:
                    updateClient();
                    break;
                case 0:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private void addClient() {
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
        clients.add(client);

        System.out.println("Client added successfully.");
    }

    private void viewClients() {
        System.out.println("List of clients:");
        System.out.println("ID | Name | Surname | Age | DNI | Entry Type");
        for (Client client : clients) {
            System.out.println(client.getId() + " | " + client.getName() + " | " + client.getSurname() + " | " + client.getAge() + " | " + client.getDni() + " | " + client.getEntryType());
        }
    }

    private void removeClient() {
        System.out.print("Enter the ID of the client to remove: ");
        int id = scanner.nextInt();
        boolean removed = false;
        for (Client client : clients) {
            if (client.getId() == id) {
                clients.remove(client);
                removed = true;
                System.out.println("Client removed successfully.");
                break;
            }
        }
        if (!removed) {
            System.out.println("Client with ID " + id + " not found.");
        }
    }

    private void updateClient() {
        System.out.print("Enter the ID of the client to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        boolean updated = false;
        for (Client client : clients) {
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
