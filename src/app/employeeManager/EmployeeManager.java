package app.employeeManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManager {
    private List<Employee> employees;
    private int employeeIdCounter = 1;

    public EmployeeManager() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adding a new employee:");
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        System.out.print("Enter employee surname: ");
        String surname = scanner.nextLine();
        System.out.print("Enter employee age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        System.out.print("Enter employee DNI: ");
        String dni = scanner.nextLine();
        System.out.print("Enter employee job: ");
        String job = scanner.nextLine();
        System.out.print("Enter employee pay: ");
        double pay = scanner.nextDouble();

        Employee employee = new Employee(employeeIdCounter++, name, surname, age, dni, job, pay);
        employees.add(employee);

        System.out.println("Employee added successfully.");
    }

    public void viewEmployees() {
        System.out.println("List of employees:");
        System.out.println("ID | Name | Surname | Age | DNI | Job | Pay");
        for (Employee employee : employees) {
            System.out.println(employee.getId() + " | " + employee.getName() + " | " + employee.getSurname() + " | " +
                    employee.getAge() + " | " + employee.getDni() + " | " + employee.getJob() + " | " + employee.getPay());
        }
    }
}
