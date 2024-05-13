package menu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import crud.EmployeeCRUD;
import entities.Employee;

public class EmployeeMenu {
    public static List<Employee> employees = new ArrayList<>();

    private Scanner scanner = new Scanner(System.in);

    public void displayEmployeeMenu() {
        int choice;

        do {
            System.out.println("Employee Menu:");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Remove Employee");
            System.out.println("4. Update Employee");
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
                    EmployeeCRUD.addEmployee();
                    break;
                case 2:
                    EmployeeCRUD.viewEmployees();
                    break;
                case 3:
                    EmployeeCRUD.removeEmployee();
                    break;
                case 4:
                    EmployeeCRUD.updateEmployee();
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
