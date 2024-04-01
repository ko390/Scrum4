package objects;

public class Client extends Member {
    private String entryType;

    public Client(int id, String name, String surname, int age, String dni, String entryType) {
        super(id, name, surname, age, dni);
        this.entryType = entryType;
    }

    public String getEntryType() {
        return entryType;
    }
}