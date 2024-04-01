package objects;

public class Band {
    private int id;
    private String name;
    private boolean available;
    private String genre;
    private String country;

    public Band(int id, String name, boolean available, String genre, String country) {
        this.id = id;
        this.name = name;
        this.available = available;
        this.genre = genre;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getGenre() {
        return genre;
    }

    public String getCountry() {
        return country;
    }
}
