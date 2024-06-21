package project;

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
        cartHistorySize=0;
        cartHistory = new Cart[cartHistorySize];
        actualHistorySize = 0;

    }
    public Buyer(String username, String password) {
        super(username, password);
        currentCart = new Cart();
        cartHistorySize=0;
        cartHistory = new Cart[cartHistorySize];
        actualHistorySize = 0;

    }
    public Buyer(String username, String password, String address, Cart currentCart) {
        super(username, password);
        this.address = address;
        this.currentCart = currentCart;
        cartHistorySize=0;
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
    public void setCartHistory(Cart[] cartHistory) {
        this.cartHistory = cartHistory;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return address;
    }

    //methods
    public void addToCart(Item item) {
        currentCart.addItem(item);
    }
    public void removeFromCart(Item item) {
        currentCart.removeItem(item);
    }
    public void purchaseCart(){
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
        currentCart=null;
    }
    public void displayCartHistory(){
        for(int i=0; i<cartHistorySize; i++){
            if(cartHistory[i]!=null){
                System.out.println(cartHistory[i].toString());
            }
        }
    }
}
