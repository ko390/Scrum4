package app.employeeManager;

public class Employee {
    private int id;
    private String name;
    private String surname;
    private int age;
    private String dni;
    private String job;
    private double pay;

    public Employee(int id, String name, String surname, int age, String dni, String job, double pay) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.dni = dni;
        this.job = job;
        this.pay = pay;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getDni() {
        return dni;
    }

    public String getJob() {
        return job;
    }

    public double getPay() {
        return pay;
    }
}
