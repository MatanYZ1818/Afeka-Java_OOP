package project;

import java.util.Scanner;

public class ItemManager {
    public void addItemToSeller(Scanner scanner, UserManager userManager) {
        System.out.print("Enter chosen seller's username: ");
        String sellerName = scanner.nextLine();
        Seller chosenSeller = userManager.getSeller(sellerName);
        if (chosenSeller == null) {
            System.out.println("Seller does not exist.");
            return;
        }
        System.out.print("Enter item name: ");
        String itemName = scanner.nextLine();
        System.out.print("Enter item price: ");
        double itemPrice = Double.parseDouble(scanner.nextLine());
        Item sellersItem=new Item(itemName,chosenSeller,itemPrice);
        chosenSeller.addSellerItem(sellersItem);
        System.out.println("Item " + itemName + " added to seller " + sellerName + " with price " + itemPrice + ".");

    }

    public void addItemToBuyer(Scanner scanner,UserManager userManager){
        if(userManager.getBuyers().isEmpty()||userManager.getSellers().isEmpty()){
            System.out.println("Invalid request. You do not have any buyers or seller");
            return;
        }
        System.out.println("please choose a buyer from the buyers list");
        System.out.println(userManager.getBuyersNames());
        System.out.print("Enter chosen buyer's username: ");
        String buyerName = scanner.nextLine();
        while(buyerName.isEmpty() || !(userManager.userExists(buyerName,"buyers"))) {
            System.out.print("Enter a valid buyer's username: ");
            buyerName = scanner.nextLine();
        }
        System.out.println("please choose a seller from the sellers list");
        System.out.println(userManager.getSellersNames());
        System.out.print("Enter chosen seller's username: ");
        String sellerName = scanner.nextLine();
        while(sellerName.isEmpty() || !(userManager.userExists(sellerName,"seller"))) {
            System.out.print("Enter a valid seller's username: ");
            sellerName = scanner.nextLine();
        }
        Buyer chosenBuyer = userManager.getBuyer(buyerName);
        Seller chosenSeller = userManager.getSeller(sellerName);
        System.out.println(chosenSeller.getUsername()+" is selling:\n"+chosenSeller.getSellerItemsStr());
        System.out.print("please pick an item from the seller's list: ");
        String buyerItemName = scanner.nextLine();
        while(buyerItemName.isEmpty()||!(chosenSeller.hasItem(buyerItemName))) {
            System.out.print("Enter a valid item's name: ");
            buyerItemName = scanner.nextLine();
        }
        Item chosenItem=new Item(chosenSeller.getItem(buyerItemName));
        chosenBuyer.addToCart(chosenItem);
    }
}
