package project;

import java.util.Arrays;
import java.util.Scanner;

public class UserManager {
    private Seller[] sellers = new Seller[1];
    private Buyer[] buyers = new Buyer[1];

    public void addSeller(Scanner scanner) {
        System.out.print("Enter seller username: ");
        String username = scanner.nextLine();
        System.out.print("Enter seller password: ");
        String password = scanner.nextLine();
        if (userExists(username, "seller")) {
            System.out.println("Seller username already exists. Please choose a different username.");
        } else {
            for (int i = 0; i < sellers.length; i++) {
                if(sellers[i]==null){
                    sellers[i] = new Seller(username, password);
                    System.out.println("Seller added successfully.");
                    return;
                }
            }
            Seller[] newArr=new Seller[sellers.length*2];
            int i=0;
            for (; i < sellers.length; i++) {
                newArr[i] = sellers[i];
            }
            newArr[i] = new Seller(username, password);
            sellers = newArr;
        }
    }
    public void addBuyer(Scanner scanner) {
        System.out.print("Enter buyer username: ");
        String username = scanner.nextLine();
        System.out.print("Enter buyer password: ");
        String password = scanner.nextLine();
        System.out.print("Enter buyer address: ");
        String address = scanner.nextLine();
        if (userExists(username, "seller")) {
            System.out.println("Seller username already exists. Please choose a different username.");
        } else {
            for (int i = 0; i < buyers.length; i++) {
                if(buyers[i]==null){
                    buyers[i] = new Buyer(username,password,address);
                    System.out.println("Seller added successfully.");
                    return;
                }
            }
            Buyer[] newArr=new Buyer[buyers.length*2];
            int i=0;
            for (; i < buyers.length; i++) {
                newArr[i] = buyers[i];
            }
            newArr[i] = new Buyer(username,password,address);
            buyers = newArr;
        }
    }
    public void showUsers(String userType) {
        if(userType.equals("seller")){
            sellers=sortSellers(sellers);
            for (Seller seller : sellers) {
                if (seller != null) {
                    System.out.println(seller);
                }
            }
        }
        else if(userType.equals("buyer")){
            buyers=sortBuyers(buyers);
            for (Buyer buyer : buyers) {
                if (buyer != null) {
                    System.out.println(buyer);
                }
            }
        }
    }
    public void useOldCart(Scanner scanner) throws Exception {
        System.out.print("please enter buyer username: ");
        String username = scanner.nextLine();
        if (!userExists(username, "buyer")) {
            throw new Exception("Seller username does not exist. Please choose a valid username.");
        }
        Buyer buyer=getBuyer(username);
        System.out.print("showing past carts:");
        buyer.displayCartHistory();
        System.out.print("please enter the cart you'd like to use again: ");
        int cartNum = scanner.nextInt();
        if(cartNum==0 || cartNum>buyer.getActualHistorySize() || buyer.getCartHistory()[cartNum-1]==null){
            throw new Exception("this cart number doesn't exist.");
        }
        System.out.println("replacing current cart with chosen cart...");
        Cart restoreCart=buyer.getCartHistory()[cartNum-1];
        buyer.setCurrentCart(restoreCart);
    }

    public boolean userExists(String username, String userType) {
        if(userType.equalsIgnoreCase("seller")) {
            for (Seller s : sellers) {
                if (s != null && username.equals(s.getUsername())) {
                    return true;
                }
            }
        }
        else if(userType.equalsIgnoreCase("buyer")) {
            for (Buyer s : buyers) {
                if (s!=null && username.equals(s.getUsername())) {
                    return true;
                }
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

    public Buyer[] getBuyers(){
        return buyers;
    }
    public Seller[] getSellers(){
        return sellers;
    }
    private Seller[] sortSellers(Seller[] sellers) {
        int n = sellers.length;
        for (int i = 1; i < n; ++i) {
            Seller key = sellers[i];
            int j = i - 1;

            // Move elements of arr[0..i-1], that are
            // greater than key, to one position ahead
            // of their current position
            while (j >= 0 && sellers[j].getActualAmount() > key.getActualAmount()) {
                sellers[j + 1] = sellers[j];
                j = j - 1;
            }
            sellers[j + 1] = key;
        }
        return sellers;
    }
    private Buyer[] sortBuyers(Buyer[] buyers) {
        String[] namesArray = new String[buyers.length];
        for (int i = 0; i < buyers.length; i++) {
            if (buyers[i] != null) {
                namesArray[i] = buyers[i].getUsername();
            }
        }
        Arrays.sort(namesArray);
        Buyer[] newBuyers = new Buyer[buyers.length];
        for (int i = 0; i < namesArray.length; i++) {
            newBuyers[i]=getBuyer(namesArray[i]);
        }
        return newBuyers;
    }
}
