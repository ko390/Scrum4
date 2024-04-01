package objects;

public abstract class Member {
    private int id;
    private String name;
    private String surname;
    private int age;
    private String dni;

    public Member(int id, String name, String surname, int age, String dni) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.dni = dni;
    }

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
}
