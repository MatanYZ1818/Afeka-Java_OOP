package project;

public class Item {
    private static int nextSerialNumber = 1;
    
    // Properties
    private int serialNumber;
    private String itemName;
    private Seller seller;
    private double price;
    private String category;

    // Constructors
    public Item(String itemName, Seller seller, double price, String category) {
        this.itemName = itemName;
        this.seller = seller;
        this.price = price;
        this.category = category;
        this.serialNumber = nextSerialNumber++;
    }

    // Getters and Setters
    public int getSerialNumber() {
        return serialNumber;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // Methods
    public String basicInfo() {
        return "Item: " + itemName + ", Price: $" + price + ", Category: " + category;
    }

    @Override
    public String toString() {
        return "Item: " + itemName + ", Price: $" + price + ", Category: " + category + ", Serial Number: " + serialNumber;
    }
}
