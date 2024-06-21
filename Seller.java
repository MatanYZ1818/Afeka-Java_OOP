package project;

public class Seller extends User {
    private Item[] sellerItems;
    private int sellerItemsSize;
    private int actualAmount;
    public Seller(String username, String password)
    {
        super(username, password);
        sellerItems = new Item[1];
        sellerItemsSize = 0;
        actualAmount = 0;
    }

    public Seller(String username, String password, int sellerItemsSize){
        super(username, password);
        this.sellerItemsSize = sellerItemsSize;
        sellerItems = new Item[sellerItemsSize];
        actualAmount = 0;
    }

    public Item[] getSellerItems() {
        return sellerItems;
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
                    return;
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

    public String toString(){
        return "seller username = " + getUsername();
    }
}
