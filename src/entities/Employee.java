package entities;

public class Employee extends Member {
    private String job;
    private double pay;

    public Employee(int id, String name, String surname, int age, String dni, String job, double pay) {
        super(id, name, surname, age, dni);
        this.job = job;
        this.pay = pay;
    }

    public String getJob() {
        return job;
    }

    public double getPay() {
        return pay;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }
}