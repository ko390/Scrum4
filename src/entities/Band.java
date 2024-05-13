package entities;

public class Band {
    private int id;
    private String name;
    private boolean available;
    private String genre;
    private String country;

    public Band(int id, String name, String genre, String country, boolean available) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.country = country;
        this.available = available;
    }

    public Band() {

    }

    public Band(int id, String name, String genre, String country, String available) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
