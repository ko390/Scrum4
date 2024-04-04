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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
