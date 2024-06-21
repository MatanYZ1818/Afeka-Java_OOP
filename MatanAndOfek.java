package project;

import java.util.Scanner;

public class Application {
    //כיתה של איל איזנשטיין
    // אופק דריבינסקי - 322888264
    // מתן יעקב זכריה - 211824651

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
    }

