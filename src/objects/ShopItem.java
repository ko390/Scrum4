package objects;

public class ShopItem {
    private int id;
    private String name;
    private double price;
    private int numberSold;
    private double totalPrice;

    public ShopItem(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.numberSold = 0;
        this.totalPrice = 0.0;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberSold() {
        return numberSold;
    }

    public void setNumberSold(int numberSold) {
        this.numberSold = numberSold;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
