package project;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        //מתן יעקב זכריה
        //אופק דריבינסקי

        try (Scanner scanner = new Scanner(System.in)){
            int userChoice=10;
            System.out.print("please choose an option\n0 - exit\n1 - add a seller    2 - add a buyer\n3 - add an item to the seller    4 - add an item to the buyer\n5 - pay for order\n6 - show details for all buyers    7 - show details for all sellers\nchoice : ");
            userChoice=Integer.parseInt(scanner.nextLine());
            while(userChoice!=0){
                switch(userChoice){
                    case 1:
                        //TODO : run the Method that gets a seller's username ad adds it to the array
                        //this method also checks if the username is already taken. if so, it asks for a new name
                        break;
                    case 2:
                        //TODO : run the Method that gets a buyer's username ad adds it to the array
                        //this method also checks if the username is already taken. if so, it asks for a new name
                        break;
                    case 3:
                        //TODO:choose a seller and get from the user an item to add to the seller with the item's name , price and category
                        break;
                    case 4:
                        //TODO: choose a buyer and get the item's name, which seller  he wants it from
                        break;
                    case 5:
                        //TODO: choose a buyer and pay for the order
                        break;
                    case 6:
                        //TODO: go through all the sellers and show their details
                        break;
                    case 7:
                        //TODO: go through all the buyers and show their details
                        break;
                    default:
                        System.out.println("invalid option !");
                }
                System.out.print("please choose an option\n0 - exit\n1 - add a seller    2 - add a buyer\n3 - add an item to the seller    4 - add an item to the buyer\n5 - pay for order\n6 - show details for all buyers    7 - show details for all sellers\nchoice : ");
                userChoice=Integer.parseInt(scanner.nextLine());
            }
        }
    }
}
