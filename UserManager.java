package project;

import java.util.ArrayList;
import java.util.Scanner;

public class UserManager {
    private ArrayList<Seller> sellers = new ArrayList<>();
    private ArrayList<Buyer> buyers = new ArrayList<>();

    public void addSeller(Scanner scanner) {
        System.out.print("Enter seller username: ");
        String username = scanner.nextLine();
        System.out.print("Enter seller password: ");
        String password = scanner.nextLine();
        if (userExists(username, "seller")) {
            System.out.println("Seller username already exists. Please choose a different username.");
        } else {
            sellers.add(new Seller(username, password));
            System.out.println("Seller added successfully.");
        }
    }

    public void addBuyer(Scanner scanner) {
        System.out.print("Enter buyer username: ");
        String username = scanner.nextLine();
        System.out.print("Enter buyer password: ");
        String password = scanner.nextLine();
        System.out.print("Enter buyer address: ");
        String address = scanner.nextLine();
        if (userExists(username, "buyer")) {
            System.out.println("Buyer username already exists. Please choose a different username.");
        } else {
            buyers.add(new Buyer(username, password, address));
            System.out.println("Buyer added successfully.");
        }
    }

    public void showUsers(String userType) {
        System.out.println(userType + " list:");
        ArrayList<? extends User> users = userType.equalsIgnoreCase("buyer") ? buyers : sellers;
        for (User user : users) {
            System.out.println(user.getUsername());
        }
    }

    public boolean userExists(String username, String userType) {
        ArrayList<? extends User> users = userType.equalsIgnoreCase("buyer") ? buyers : sellers;
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public Seller getSeller(String username) {
        for (Seller seller : sellers) {
            if (seller.getUsername().equals(username)) {
                return seller;
            }
        }
        return null;
    }

    public Buyer getBuyer(String username) {
        for (Buyer buyer : buyers) {
            if (buyer.getUsername().equals(username)) {
                return buyer;
            }
        }
        return null;
    }

    public void addItemToBuyer(Scanner scanner){
        System.out.println("please choose a buyer from the buyers list");
        System.out.println(sellers);
    }
}
