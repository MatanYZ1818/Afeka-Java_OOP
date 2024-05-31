package project;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    //כיתה של איל איזנשטיין
    // אופק דריבינסקי - 322888264
    // מתן יעקב זכריה - 211824651

    private static ArrayList<String> sellers = new ArrayList<>();
    private static ArrayList<String> buyers = new ArrayList<>();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int userChoice;
            do {
                System.out.print("Please choose an option\n0 - exit\n1 - add a seller\n2 - add a buyer\n3 - add an item to the seller\n4 - add an item to the buyer\n5 - pay for order\n6 - show details for all buyers\n7 - show details for all sellers\nChoice: ");
                userChoice = Integer.parseInt(scanner.nextLine());

                switch (userChoice) {
                    case 1:
                        addUser(scanner, sellers, "seller");
                        break;
                    case 2:
                        addUser(scanner, buyers, "buyer");
                        break;
                    case 3:
                        addItemToSeller(scanner);
                        break;
                    case 4:
                        addItemToBuyer(scanner);
                        break;
                    case 5:
                        payForOrder(scanner);
                        break;
                    case 6:
                        showUsers(buyers, "Buyers");
                        break;
                    case 7:
                        showUsers(sellers, "Sellers");
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

    private static void addUser(Scanner scanner, ArrayList<String> users, String userType) {
        System.out.print("Enter " + userType + " username: ");
        String username = scanner.nextLine();
        if (users.contains(username)) {
            System.out.println(userType + " username already exists. Please choose a different username.");
        } else {
            users.add(username);
            System.out.println(userType + " added successfully.");
        }
    }

    private static void addItemToSeller(Scanner scanner) {
        System.out.print("Enter seller's username: ");
        String sellerName = scanner.nextLine();
        if (!sellers.contains(sellerName)) {
            System.out.println("Seller does not exist.");
            return;
        }
        System.out.print("Enter item name: ");
        String itemName = scanner.nextLine();
        System.out.print("Enter item price: ");
        double itemPrice = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter item category: ");
        String itemCategory = scanner.nextLine();
        // Currently, just collecting the data
        System.out.println("Item " + itemName + " added to seller " + sellerName + " with price " + itemPrice + " in category " + itemCategory + ".");
    }

    private static void addItemToBuyer(Scanner scanner) {
        System.out.print("Enter buyer's username: ");
        String buyerName = scanner.nextLine();
        if (!buyers.contains(buyerName)) {
            System.out.println("Buyer does not exist.");
            return;
        }
        System.out.print("Enter seller's username from whom to buy: ");
        String sellerName = scanner.nextLine();
        if (!sellers.contains(sellerName)) {
            System.out.println("Seller does not exist.");
            return;
        }
        System.out.print("Enter item name: ");
        String itemName = scanner.nextLine();
        // Currently, just collecting the data
        System.out.println("Item " + itemName + " added to buyer " + buyerName + " from seller " + sellerName + ".");
    }

    private static void payForOrder(Scanner scanner) {
        System.out.print("Enter buyer's username to process payment: ");
        String buyerName = scanner.nextLine();
        if (!buyers.contains(buyerName)) {
            System.out.println("Buyer does not exist.");
            return;
        }
        // Currently, just collecting the data
        System.out.println("Payment for buyer " + buyerName + " processed successfully.");
    }

    private static void showUsers(ArrayList<String> users, String userType) {
        System.out.println(userType + " list:");
        for (String user : users) {
            System.out.println(user);
        }
    }
}
