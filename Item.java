package project;

public class Item {
    //properties
    private String itemName;
    private Seller seller;
    private double price;
    //buiders
    public Item(String itemName, Seller sellerName, double price) {
        this.itemName = itemName;
        this.seller = sellerName;
        this.price = price;
    }
    public Item(){
        this.seller = null;
        this.price = 0;
        this.itemName = "";
    }
    public Item(Item item){
        this.itemName = item.getItemName();
        this.seller = item.getSeller();
        this.price = item.getPrice();
    }
    //getters and setters
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

    //methods
    public String basicInfo(){
        return "item's name=" + itemName + ", price=" + price;
    }
    @Override
    public String toString() {
        return "itemName=" + itemName + ", seller=" + seller.getUsername() + ", price=" + price;
    }
}
