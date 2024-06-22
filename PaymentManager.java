package project;

import java.util.Scanner;

public class PaymentManager {
    public void payForOrder(Scanner scanner, UserManager userManager) {
        System.out.print("Enter buyer's username to process payment: ");
        String buyerName = scanner.nextLine();
        Buyer buyer = userManager.getBuyer(buyerName);
        if (buyer == null) {
            System.out.println("Buyer does not exist.");
            return;
        }
        double finalPrice=0;
        for (Item item:buyer.getCurrentCart().getItemsCart()){
            finalPrice+=item.getPrice();
        }
        System.out.println("Your final price is $"+finalPrice);
        buyer.purchaseCart();
        System.out.println("Payment for buyer " + buyerName + " processed successfully.");
    }
}
