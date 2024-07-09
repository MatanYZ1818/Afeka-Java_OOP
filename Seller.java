package project;

import java.util.Arrays;

public class Seller extends User {
    // Properties
    private Item[] sellerItems;
    private int sellerItemsSize;
    private int actualAmount;

    // Constructors
    public Seller(String username, String password) {
        super(username, password);
        sellerItems = new Item[1];
        sellerItemsSize = 1;
        actualAmount = 0;
    }

    // Getters and Setters
    public Item[] getSellerItems() {
        return sellerItems;
    }

    public int getSellerItemsSize() {
        return sellerItemsSize;
    }

    public int getActualAmount() {
        return actualAmount;
    }

    // Methods
    public void addSellerItem(Item item, String packagingType) {
        if (actualAmount == sellerItemsSize) {
            Item[] newSellerItems = new Item[sellerItems.length * 2];
            System.arraycopy(sellerItems, 0, newSellerItems, 0, sellerItems.length);
            newSellerItems[sellerItems.length] = item;
            sellerItemsSize *= 2;
            sellerItems = newSellerItems;
        } else {
            for (int i = 0; i < sellerItems.length; i++) {
                if (sellerItems[i] == null) {
                    sellerItems[i] = item;
                }
            }
        }
        actualAmount++;
    }

    public void removeSellerItem(Item item) {
        for (int i = 0; i < sellerItems.length; i++) {
            if (sellerItems[i] == item) {
                sellerItems[i] = null;
                actualAmount--;
            }
        }
    }

    public String getSellerItemsStr() {
        StringBuilder str = new StringBuilder("\n");
        for (int i = 0; i < sellerItemsSize; i++) {
            if (sellerItems[i] != null) {
                str.append(sellerItems[i].basicInfo());
                if (i < sellerItemsSize - 1) {
                    str.append("\n");
                }
            }
        }
        return str.toString();
    }

    public String getBasicInfo() {
        return "Seller's name: " + getUsername();
    }

    public boolean hasItem(String itemName) {
        for (int i = 0; i < sellerItems.length; i++) {
            if (sellerItems[i] != null && sellerItems[i].getItemName().equals(itemName)) {
                return true;
            }
        }
        return false;
    }

    public Item getItem(String itemName) {
        for (int i = 0; i < sellerItems.length; i++) {
            if (sellerItems[i] != null && sellerItems[i].getItemName().equals(itemName)) {
                return sellerItems[i];
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Seller username = " + getUsername() + "\nSeller password = " + getPassword() + "\nSeller items: " + getSellerItemsStr();
    }
}

