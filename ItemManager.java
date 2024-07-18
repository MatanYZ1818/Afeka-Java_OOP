package project;

import java.util.Scanner;

public class ItemManager {

    public void addItemToSeller(Scanner scanner, UserManager userManager) throws Exception {
        System.out.print("Enter seller username: ");
        String sellerUsername = scanner.nextLine();
        Seller seller = userManager.getSeller(sellerUsername);

        if (seller == null) {
            System.out.println("Seller not found.");
            return;
        }

        System.out.print("Enter item name: ");
        String itemName = scanner.nextLine();
        if (itemName == null || itemName.equals("")) {
            throw new Exception("Invalid item name.");
        }
        if(checkIfSellerHadItem(itemName,seller)){
            throw new Exception("this item already exists. please give it a different name");
        }
        System.out.print("Enter item price: ");
        double itemPrice;
        try {
            itemPrice = Double.parseDouble(scanner.nextLine());
        } catch (Exception e){
            throw new Exception("Invalid item price. please try again.");
        }
        System.out.print("Enter item category: ");
        String itemCategory = scanner.nextLine();
        System.out.print("Enter item packaging type: ");
        String packagingType = scanner.nextLine();

        Item newItem = new Item(itemName, seller, itemPrice, itemCategory);
        seller.addSellerItem(newItem, packagingType);
        System.out.println("Item added successfully.");
    }

    public void addItemToBuyer(Scanner scanner, UserManager userManager) throws Exception {
        Seller[] sellers = userManager.getSellers();
        System.out.print("Enter buyer username: ");
        String buyerUsername = scanner.nextLine();
        Buyer buyer;
        try{
            buyer = userManager.getBuyer(buyerUsername);
            String t=buyer.getUsername();
        } catch (Exception e){
            throw new Exception("Buyer not found.");
        }

        System.out.print("Enter item name: ");
        String itemName = scanner.nextLine();
        Item sellerItem = null;

        for (Seller seller : sellers) {
            if (seller.hasItem(itemName)) {
                sellerItem = seller.getItem(itemName);
                break;
            }
        }

        if (sellerItem == null) {
            System.out.println("Item not found.");
            return;
        }

        buyer.addToCart(sellerItem);
        System.out.println("Item added to buyer's cart.");
    }

    public void displayItemsByCategory(Scanner scanner,UserManager userManager) {
        System.out.print("Enter category name: ");
        String category = scanner.nextLine().trim().toLowerCase();
        Seller[] sellers= userManager.getSellers();
        System.out.println("Items from category '" + category + "':");

        for (Seller seller : sellers) {
            for (Item item : seller.getSellerItems()) {
                if (item.getCategory().equalsIgnoreCase(category)) {
                    System.out.println(item);
                }
            }
        }
    }

    public void displayItemsBySeller(Scanner scanner, UserManager userManager) {
        System.out.print("Enter seller username: ");
        String sellerUsername = scanner.nextLine();
        Seller seller = userManager.getSeller(sellerUsername);

        if (seller == null) {
            System.out.println("Seller not found.");
            return;
        }

        System.out.println("Items from seller '" + seller.getUsername() + "':");
        for (Item item : seller.getSellerItems()) {
            if (item != null) {
                System.out.println(item);
            }
        }
    }

    public void displayItemsBySellerCategory(Scanner scanner, UserManager userManager) {
        System.out.print("Enter seller username: ");
        String sellerUsername = scanner.nextLine();
        Seller seller = userManager.getSeller(sellerUsername);

        if (seller == null) {
            System.out.println("Seller not found.");
            return;
        }

        System.out.print("Enter category name: ");
        String category = scanner.nextLine().trim().toLowerCase();

        System.out.println("Items from seller '" + seller.getUsername() + "' in category '" + category + "':");
        for (Item item : seller.getSellerItems()) {
            if (item != null && item.getCategory().equalsIgnoreCase(category)) {
                System.out.println(item);
            }
        }
    }

    public boolean checkIfSellerHadItem(String checkItemName, Seller s){
        for (Item item : s.getSellerItems()) {
            if(item!=null && item.getItemName().equals(checkItemName)){
                return true;
            }
        }
        return false;
    }
}
