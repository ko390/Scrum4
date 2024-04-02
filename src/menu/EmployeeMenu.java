package menu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import objects.Employee;

public class EmployeeMenu {
    private List<Employee> employees = new ArrayList<>();
    private int employeeIdCounter = 1;
    private Scanner scanner = new Scanner(System.in);

    public void displayEmployeeMenu() {
        int choice;

        do {
            System.out.println("Employee Menu:");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
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
                    addEmployee();
                    break;
                case 2:
                    viewEmployees();
                    break;
                case 0:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

    }

    private void addEmployee() {
        System.out.println("Adding a new employee:");
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();

        System.out.print("Enter employee surname: ");
        String surname = scanner.nextLine();

        int age;
        while (true) {
            try {
                System.out.print("Enter employee age: ");
                age = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid age.");
                scanner.nextLine();
            }
        }

        System.out.print("Enter employee DNI: ");
        String dni = scanner.next();
        scanner.nextLine();

        System.out.print("Enter employee job: ");
        String job = scanner.nextLine();

        double pay;
        while (true) {
            try {
                System.out.print("Enter employee pay: ");
                pay = scanner.nextDouble();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid pay.");
                scanner.nextLine();
            }
        }

        Employee employee = new Employee(employeeIdCounter++, name, surname, age, dni, job, pay);
        employees.add(employee);

        System.out.println("Employee added successfully.");
    }

    private void viewEmployees() {
        System.out.println("List of employees:");
        System.out.println("ID | Name | Surname | Age | DNI | Job | Pay");
        for (Employee employee : employees) {
            System.out.println(employee.getId() + " | " + employee.getName() + " | " + employee.getSurname() + " | " + employee.getAge() + " | " + employee.getDni() + " | " + employee.getJob() + " | " + employee.getPay());
        }
    }
}
