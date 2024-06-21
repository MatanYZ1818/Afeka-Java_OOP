package project;

import java.util.Scanner;

public class ItemManager {
    public void addItemToSeller(Scanner scanner, UserManager userManager) {
        System.out.print("Enter seller's username: ");
        String sellerName = scanner.nextLine();
        Seller seller = userManager.getSeller(sellerName);
        if (seller == null) {
            System.out.println("Seller does not exist.");
            return;
        }
        System.out.print("Enter item name: ");
        String itemName = scanner.nextLine();
        System.out.print("Enter item price: ");
        double itemPrice = Double.parseDouble(scanner.nextLine());
        // Currently, just collecting the data
        System.out.println("Item " + itemName + " added to seller " + sellerName + " with price " + itemPrice + ".");
    }

    public void addItemToBuyer(Scanner scanner,UserManager userManager){
        System.out.println("please choose a buyer from the buyers list");
        System.out.println(userManager.getSellers());
        String sellerName = scanner.nextLine();

    }
}
