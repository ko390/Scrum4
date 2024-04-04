package objects;

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

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getStyle() {
        return genre;
    }
}
