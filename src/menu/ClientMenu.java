package menu;

import crud.ClientCRUD;
import entities.Client;
import crud.ClientDaoImplements;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ClientMenu {
    public static List<Client> clients = new ArrayList<>();

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
                    ClientCRUD.addClient();
                    break;
                case 2:
                    ClientCRUD.viewClients();
                    break;
                case 3:
                    ClientCRUD.removeClient();
                    break;
                case 4:
                    ClientCRUD.updateClient();
                    break;
                case 0:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }


}
