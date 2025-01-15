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
            String userChoice;
            do {
                userChoice="";
                try{
                    System.out.print("Please choose an option\n0 - exit\n"+
                                                                "1 - add a seller\t\t\t\t\t2 - add a buyer\t\t\t\t\t3 - add an item to the seller\n" +
                                                                "4 - add an item to the buyer\t\t5 - pay for order\t\t\t\t6 - show details for all buyers\n" +
                                                                "7 - show details for all sellers\t8 - Display Items by Category\t9 - reuse old cart as template \n" +
                                                                "69 - populate Users array UNLIKE THE ORIGINAL PROJECT,THIS ALLOWS DUPLICATES!\n"+
                                                                "99 - show list of names\t\t\t\t100 - show names after hashing\t"+"101 - count strings\n"+
                                                                "102 - turn to Arraylist\n"+
                                                                "Choice: ");
                    userChoice = scanner.nextLine();

                    switch (userChoice) {
                        case "1":
                            userManager.addSeller(scanner);
                            break;
                        case "2":
                            userManager.addBuyer(scanner);
                            break;
                        case "3":
                            itemManager.addItemToSeller(scanner, userManager);
                            break;
                        case "4":
                            itemManager.addItemToBuyer(scanner, userManager);
                            break;
                        case "5":
                            paymentManager.payForOrder(scanner, userManager);
                            break;
                        case "6":
                            userManager.showUsers("buyer");
                            break;
                        case "7":
                            userManager.showUsers("seller");
                            break;
                        case "8":
                            itemManager.displayItemsByCategory(scanner, userManager);
                            break;
                        case "9":
                            userManager.useOldCart(scanner);
                            break;
                        case "0":
                            System.out.println("Exiting...");
                            break;
                        case "69":
                            userManager.populate();
                            break;
                        case "99":
                            userManager.printNames();
                            break;
                        case "100":
                            userManager.hashUsers();
                            break;
                        case "101":
                            userManager.countNames(scanner);
                            break;
                        case "102":
                            userManager.doubleArrayList();
                            break;
                        case "103":
                            userManager.arrangeByLength();
                            break;
                        default:
                            System.out.println("Invalid option");
                    }
                } catch (Exception e){
                    System.out.println(e.getMessage());
                }
                scanner.reset();
            } while (!userChoice.equals("0"));
        }
    }
}

