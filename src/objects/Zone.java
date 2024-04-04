package objects;

public class Zone {
    private int id;
    private String name;
    private int capacity;
    private boolean vip;

    public Zone(int id, String name, int capacity, boolean vip) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.vip = vip;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isVip() {
        return vip;
    }
}
