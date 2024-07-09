package project;

import java.util.Scanner;

public class MatanAndOfek {
    // כיתה של איל איזנשטיין
    // אופק דריבינסקי - 322888264
    // מתן יעקב זכריה - 211824651
    
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        ItemManager itemManager = new ItemManager();
        PaymentManager paymentManager = new PaymentManager();

        try (Scanner scanner = new Scanner(System.in)) {
            int userChoice;
            do {
                System.out.print("Please choose an option\n0 - exit\n1 - add a seller\n2 - add a buyer\n3 - add an item to the seller\n4 - add an item to the buyer\n5 - pay for order\n6 - show details for all buyers\n7 - show details for all sellers\n8 - Display Items by Category\nChoice: ");
                userChoice = Integer.parseInt(scanner.nextLine());

                switch (userChoice) {
                    case 1:
                        userManager.addSeller(scanner);
                        break;
                    case 2:
                        userManager.addBuyer(scanner);
                        break;
                    case 3:
                        itemManager.addItemToSeller(scanner, userManager);
                        break;
                    case 4:
                        itemManager.addItemToBuyer(scanner, userManager);
                        break;
                    case 5:
                        paymentManager.payForOrder(scanner, userManager);
                        break;
                    case 6:
                        userManager.showUsers("Buyer");
                        break;
                    case 7:
                        userManager.showUsers("Seller");
                        break;
                    case 8:
                        itemManager.displayItemsByCategory(scanner);
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid option!");
                }
            } while (userChoice != 0);
        }
    }
}

