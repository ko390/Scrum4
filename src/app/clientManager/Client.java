package app.clientManager;

public class Client {
    private int id;
    private String name;
    private String surname;
    private int age;
    private String dni;
    private String entryType;

    public Client(int id, String name, String surname, int age, String dni, String entryType) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.dni = dni;
        this.entryType = entryType;
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

    public String getEntryType() {
        return entryType;
    }
}
