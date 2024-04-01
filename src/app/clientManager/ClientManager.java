package app.clientManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientManager {
    private List<Client> clients;
    private int clientIdCounter = 1;

    public ClientManager() {
        this.clients = new ArrayList<>();
    }

    public void addClient() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adding a new client:");
        System.out.print("Enter client name: ");
        String name = scanner.nextLine();
        System.out.print("Enter client surname: ");
        String surname = scanner.nextLine();
        System.out.print("Enter client age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        System.out.print("Enter client DNI: ");
        String dni = scanner.nextLine();
        System.out.print("Enter client entry type (VIP/GENERAL/FREE): ");
        String entryType = scanner.nextLine();

        Client client = new Client(clientIdCounter++, name, surname, age, dni, entryType);
        clients.add(client);

        System.out.println("Client added successfully.");
    }

    public void viewClients() {
        System.out.println("List of clients:");
        System.out.println("ID | Name | Surname | Age | DNI | Entry Type");
        for (Client client : clients) {
            System.out.println(client.getId() + " | " + client.getName() + " | " + client.getSurname() + " | " +
                    client.getAge() + " | " + client.getDni() + " | " + client.getEntryType());
        }
    }
}
