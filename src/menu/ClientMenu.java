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
        System.out.println("ID | Name | Surname | Age | DNI");
        for (Client client : clients) {
            System.out.println(client.getId() + " | " + client.getName() + " | " + client.getSurname() + " | " + client.getAge() + " | " + client.getDni());
        }
    }
}
