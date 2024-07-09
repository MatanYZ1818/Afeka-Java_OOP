package project;

import java.util.ArrayList;
import java.util.Scanner;

public class ItemManager {
    private ArrayList<Seller> sellers = new ArrayList<>();

    public void addItemToSeller(Scanner scanner, UserManager userManager) {
        System.out.print("Enter seller username: ");
        String sellerUsername = scanner.nextLine();
        Seller seller = userManager.getSeller(sellerUsername);

        if (seller == null) {
            System.out.println("Seller not found.");
            return;
        }

        System.out.print("Enter item name: ");
        String itemName = scanner.nextLine();
        System.out.print("Enter item price: ");
        double itemPrice = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter item category: ");
        String itemCategory = scanner.nextLine();
        System.out.print("Enter item packaging type: ");
        String packagingType = scanner.nextLine();

        Item newItem = new Item(itemName, seller, itemPrice, itemCategory);
        seller.addSellerItem(newItem, packagingType);
        System.out.println("Item added successfully.");
    }

    public void addItemToBuyer(Scanner scanner, UserManager userManager) {
        System.out.print("Enter buyer username: ");
        String buyerUsername = scanner.nextLine();
        Buyer buyer = userManager.getBuyer(buyerUsername);

        if (buyer == null) {
            System.out.println("Buyer not found.");
            return;
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

    public void displayItemsByCategory(Scanner scanner) {
        System.out.print("Enter category name: ");
        String category = scanner.nextLine().trim().toLowerCase();
        System.out.println("Items from category '" + category + "':");

        for (Seller seller : sellers) {
            for (Item item : seller.getSellerItems()) {
                if (item.getCategory().equalsIgnoreCase(category)) {
                    System.out.println(item.toString());
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
                System.out.println(item.toString());
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
                System.out.println(item.toString());
            }
        }
    }

    public ArrayList<Seller> getSellers() {
        return sellers;
    }

    public void setSellers(ArrayList<Seller> sellers) {
        this.sellers = sellers;
    }
}
