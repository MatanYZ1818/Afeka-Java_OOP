package project;

import java.util.Arrays;
import java.util.Date;

public class Buyer extends User {
    //properties
    private String address;
    Cart currentCart;
    Cart[] cartHistory;
    int cartHistorySize;
    int actualHistorySize;

    //builders
    public Buyer(String username, String password, String address) {
        super(username, password);
        this.address = address;
        currentCart = new Cart();
        cartHistorySize=1;
        cartHistory = new Cart[cartHistorySize];
        actualHistorySize = 0;

    }
    public Buyer(String username, String password) {
        super(username, password);
        currentCart = new Cart();
        cartHistorySize=1;
        cartHistory = new Cart[cartHistorySize];
        actualHistorySize = 0;

    }
    public Buyer(String username, String password, String address, Cart currentCart) {
        super(username, password);
        this.address = address;
        this.currentCart = currentCart;
        cartHistorySize=1;
        cartHistory = new Cart[cartHistorySize];
        actualHistorySize = 0;
    }

    //getters and setters
    public Cart getCurrentCart() {
        return currentCart;
    }
    public void setCurrentCart(Cart currentCart) {
        this.currentCart = currentCart;
    }
    public Cart[] getCartHistory() {
        return cartHistory;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return address;
    }
    public int getCartHistorySize() {
        return cartHistorySize;
    }
    public void setCartHistorySize(int cartHistorySize) {
        this.cartHistorySize = cartHistorySize;
    }
    public int getActualHistorySize() {
        return actualHistorySize;
    }
    public void setActualHistorySize(int actualHistorySize) {
        this.actualHistorySize = actualHistorySize;
    }

    //methods
    public void addToCart(Item item) {
        currentCart.addItem(item);
    }
    public void removeFromCart(Item item) {
        currentCart.removeItem(item);
    }
    public void newCart(){
        this.currentCart= new Cart(this);
    }
    public void purchaseCart(){
        currentCart.setCartDate(new Date());
        if(actualHistorySize<cartHistorySize){
            for(int i=0; i<cartHistorySize; i++){
                if(cartHistory[i]==null){
                    cartHistory[i]=currentCart;
                    actualHistorySize++;
                }
            }
        }
        else {
            Cart[] newCartHistory = new Cart[cartHistorySize*2];
            System.arraycopy(cartHistory, 0, newCartHistory, 0, cartHistorySize);
            newCartHistory[cartHistorySize]=currentCart;
            cartHistory = newCartHistory;
            actualHistorySize++;
            cartHistorySize*=2;
        }
        newCart();
    }
    public void displayCartHistory(){
        for(int i=0; i<cartHistorySize; i++){
            if(cartHistory[i]!=null){
                System.out.println(cartHistory[i].toString());
            }
        }
    }
    public String getBasicInfo(){
        return "buyer's name: "+getUsername()+"\n current cart"+ currentCart.toString()+"\n cart history: "+ Arrays.toString(cartHistory) +"\n";
    }
    @Override
    public String toString() {
        return "username: " + getUsername() + "\n password: " + getPassword() + "\n address: " + getAddress() + "\n current cart = " + getCurrentCart() + "\n cart history = " + Arrays.toString(getCartHistory()) + "\n cart history size = " + getCartHistorySize() + "\n";
    }
}
