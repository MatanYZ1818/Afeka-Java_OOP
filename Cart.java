package project;

import java.util.Date;

public class Cart {
    //properties
    private User usersCart;
    private Item[] itemsCart;
    private Date cartDate;
    private int cartSize;
    private int actualAmount;
    //builders
    public Cart(User usersCart, Item[] itemsCart) {
        this.usersCart = usersCart;
        this.itemsCart = itemsCart;
        this.cartDate = new Date();
        this.cartSize = itemsCart.length;
        this.actualAmount = 0;
    }
    public Cart(User usersCart){
        this.usersCart = usersCart;
        this.itemsCart = new Item[1];
        this.cartDate = new Date();
        this.cartSize = itemsCart.length;
        this.actualAmount = 0;
    }
    public Cart(){
        this.usersCart = null;
        this.itemsCart = new Item[1];
        this.cartDate = new Date();
        this.cartSize = itemsCart.length;
        this.actualAmount = 0;
    }

    // getter and setters
    public User getUsersCart() {
        return usersCart;
    }
    public void setUsersCart(User usersCart) {
        this.usersCart = usersCart;
    }
    public Item[] getItemsCart() {
        return itemsCart;
    }
    public void setItemsCart(Item[] itemsCart) {
        this.itemsCart = itemsCart;
    }
    public Date getCartDate() {
        return cartDate;
    }
    public void setCartDate(Date cartDate) {
        this.cartDate = cartDate;
    }
    public int getCartSize() {
        return cartSize;
    }
    public void setCartSize(int cartSize) {
        this.cartSize = cartSize;
    }
    public int getActualAmount() {
        return actualAmount;
    }

    //methods
    public void addItem(Item item) {
        if(actualAmount < itemsCart.length){
            for(int i = 0; i < itemsCart.length; i++){
                if(itemsCart[i]==null){
                    itemsCart[i] = item;
                    actualAmount++;
                }
            }
        }
        else {
            Item[] newItems = new Item[itemsCart.length*2];
            System.arraycopy(itemsCart, 0, newItems, 0, itemsCart.length);
            newItems[itemsCart.length] = item;
            itemsCart = newItems;
            actualAmount++;
            cartSize*=2;
        }
    }
    public void removeItem(Item item) {
        for(int i = 0; i < itemsCart.length; i++){
            if(itemsCart[i]==item){
                itemsCart[i] = null;
                actualAmount--;
            }
        }
    }
    @Override
    public String toString() {
        String str="\n[";
        for(int i = 0; i < itemsCart.length; i++){
            if(itemsCart[i]!=null){
                str+= itemsCart[i].toString();
                if(i!=itemsCart.length-1){
                    str+=", ";
                }
            }
        }
        str+="]";
        return str;
    }
}
