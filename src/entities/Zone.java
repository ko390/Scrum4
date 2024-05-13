package entities;

public class Zone {
    private int id;
    private String name;
    private int capacity;
    private int vip;

    public Zone(int id, String name, int capacity, int vip) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.vip = vip;
    }

    public int getVip() {
        return vip;
    }

    public void setVip(int vip) {
        this.vip = vip;
    }

    public Zone() {
    }

    public void setId(int id) {
        this.id = id;
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

}
