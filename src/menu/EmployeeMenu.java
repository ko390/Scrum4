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
                    addEmployee();
                    break;
                case 2:
                    viewEmployees();
                    break;
                case 3:
                    removeEmployee();
                    break;
                case 4:
                    updateEmployee();
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

    private void removeEmployee() {
        System.out.print("Enter the ID of the employee to remove: ");
        int id = scanner.nextInt();
        boolean removed = false;
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employees.remove(employee);
                removed = true;
                System.out.println("Employee removed successfully.");
                break;
            }
        }
        if (!removed) {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    private void updateEmployee() {
        System.out.print("Enter the ID of the employee to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        boolean updated = false;
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                System.out.println("Updating employee " + employee.getName() + ":");
                System.out.print("Enter new name: ");
                String newName = scanner.nextLine();
                System.out.print("Enter new surname: ");
                String newSurname = scanner.nextLine();
                System.out.print("Enter new age: ");
                int newAge = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Enter new DNI: ");
                String newDni = scanner.nextLine();
                System.out.print("Enter new job: ");
                String newJob = scanner.nextLine();
                System.out.print("Enter new pay: ");
                double newPay = scanner.nextDouble();
                scanner.nextLine(); // Consume newline

                employee.setName(newName);
                employee.setSurname(newSurname);
                employee.setAge(newAge);
                employee.setDni(newDni);
                employee.setJob(newJob);
                employee.setPay(newPay);

                updated = true;
                System.out.println("Employee updated successfully.");
                break;
            }
        }
        if (!updated) {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }
}
