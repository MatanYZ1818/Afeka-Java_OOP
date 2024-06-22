package project;

public class Seller extends User {
    //properties
    private Item[] sellerItems;
    private int sellerItemsSize;
    private int actualAmount;
    //builders
    public Seller(String username, String password)
    {
        super(username, password);
        sellerItems = new Item[1];
        sellerItemsSize = 1;
        actualAmount = 0;
    }
    //getters and setters

    public Item[] getSellerItems() {
        return sellerItems;
    }
    public String getSellerItemsStr(){
        String str = "\n";
        for (int i = 0; i < sellerItemsSize; i++) {
            if(sellerItems[i] != null){
                str += sellerItems[i].basicInfo();
                if (i < sellerItemsSize - 1){
                    str += "\n";
                }
            }
        }
        return str;
    }
    public void addSellerItem(Item item) {
        if (actualAmount == sellerItemsSize){
            Item[] newSellerItems = new Item[sellerItems.length*2];
            System.arraycopy(sellerItems, 0, newSellerItems, 0, sellerItems.length);
            newSellerItems[sellerItems.length] = item;
            sellerItemsSize*=2;
            sellerItems = newSellerItems;
        }
        else{
            for (int i = 0; i < sellerItems.length; i++){
                if (sellerItems[i] == null){
                    sellerItems[i] = item;
                }
            }
        }
        actualAmount++;
    }
    public void removeSellerItem(Item item) {
        for(int i = 0; i < sellerItems.length; i++){
            if (sellerItems[i] == item){
                sellerItems[i] = null;
                actualAmount--;
            }
        }
    }
    public int getSellerItemsSize() {
        return sellerItemsSize;
    }
    public int getActualAmount() {
        return actualAmount;
    }
    //method
    public String getBasicInfo(){
        return "seller's name: " + getUsername();
    }
    public boolean hasItem(String itemName){
        for (int i = 0; i < sellerItems.length; i++){
            if (sellerItems[i].getItemName().equals(itemName)){
                return true;
            }
        }
        return false;
    }
    public Item getItem(String itemName){
        for (int i = 0; i < sellerItems.length; i++){
            if (sellerItems[i].getItemName().equals(itemName)){
                return sellerItems[i];
            }
        }
        return null;
    }
    public String toString(){
        return "seller username = " + getUsername()+"\nseller password = " + getPassword()+"\nseller items: " + getSellerItemsStr();
    }
}
