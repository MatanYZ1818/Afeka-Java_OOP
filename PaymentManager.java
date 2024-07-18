package project;

import java.util.Scanner;

public class PaymentManager {
    public void payForOrder(Scanner scanner, UserManager userManager) throws Exception {
        System.out.print("Enter buyer's username to process payment: ");
        String buyerName = scanner.nextLine();
        Buyer buyer;
        try{
            buyer= userManager.getBuyer(buyerName);
            String test=buyer.getUsername();
        } catch (Exception e){
            throw new Exception("buyer name invalid! The name is either incorrect or this buyer does not exist");
        }
        double finalPrice=0;
        if(buyer.getCurrentCart().getActualAmount()==0){
            throw new Exception("buyer's current cart is empty. Please add items to your cart");
        }
        for (Item item:buyer.getCurrentCart().getItemsCart()){
            if (item!=null){
                finalPrice+=item.getPrice();
            }
        }
        System.out.println("Your final price is $"+finalPrice);
        buyer.purchaseCart();
        System.out.println("Payment for buyer " + buyerName + " processed successfully.");
    }
}
