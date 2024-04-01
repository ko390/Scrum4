package app.zoneManager;
public class Zone {
    private int id;
    private String name;
    private boolean vip;

    public Zone(int id, String name, boolean vip) {
        this.id = id;
        this.name = name;
        this.vip = vip;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isVip() {
        return vip;
    }
}
