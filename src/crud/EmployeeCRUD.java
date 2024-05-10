package crud;

import menu.EmployeeMenu;
import objects.Employee;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeCRUD {
    private static int employeeIdCounter = 1;

    private static Scanner scanner = new Scanner(System.in);
    public static void addEmployee() {
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
        EmployeeMenu.employees.add(employee);

        System.out.println("Employee added successfully.");
    }

    public static void viewEmployees() {
        System.out.println("List of employees:");
        System.out.println("ID | Name | Surname | Age | DNI | Job | Pay");
        for (Employee employee : EmployeeMenu.employees) {
            System.out.println(employee.getId() + " | " + employee.getName() + " | " + employee.getSurname() + " | " + employee.getAge() + " | " + employee.getDni() + " | " + employee.getJob() + " | " + employee.getPay());
        }
    }

    public static void removeEmployee() {
        System.out.print("Enter the ID of the employee to remove: ");
        int id = scanner.nextInt();
        boolean removed = false;
        for (Employee employee : EmployeeMenu.employees) {
            if (employee.getId() == id) {
                EmployeeMenu.employees.remove(employee);
                removed = true;
                System.out.println("Employee removed successfully.");
                break;
            }
        }
        if (!removed) {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    public static void updateEmployee() {
        System.out.print("Enter the ID of the employee to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        boolean updated = false;
        for (Employee employee : EmployeeMenu.employees) {
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
