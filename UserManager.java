package project;

import java.util.*;

public class UserManager {
    private Seller[] sellers = new Seller[1];
    private Buyer[] buyers = new Buyer[1];
    private User[] users = new User[1];
    private LinkedHashMap<String,Integer> hashMap=new LinkedHashMap<>();

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
                    break;
                }
            }
            Seller[] newArr=new Seller[sellers.length*2];
            int i=0;
            for (; i < sellers.length; i++) {
                newArr[i] = sellers[i];
            }
            newArr[i] = new Seller(username, password);
            sellers = newArr;
            //add a new seller to users list
            for (int j = 0; j < users.length; j++) {
                if(users[j]==null){
                    users[j] = new Seller(username, password);
                    System.out.println("User added successfully.");
                    return;
                }
            }
            User[] usersNewArr=new Seller[users.length*2];
            int j=0;
            for (; j < users.length; j++) {
                usersNewArr[j] = users[j];
            }
            usersNewArr[j] = new Seller(username, password);
            users = usersNewArr;
        }
    }
    public void addSeller(String username,String password) {
        for (int i = 0; i < sellers.length; i++) {
            if(sellers[i]==null){
                sellers[i] = new Seller(username, password);
                break;
            }
        }
        Seller[] newArr=new Seller[sellers.length*2];
        int i=0;
        for (; i < sellers.length; i++) {
            newArr[i] = sellers[i];
        }
        newArr[i] = new Seller(username, password);
        sellers = newArr;
        //add a new seller to users list
        for (int j = 0; j < users.length; j++) {
            if(users[j]==null){
                users[j] = new Seller(username, password);
                System.out.println("User added successfully.");
                return;
            }
        }
        User[] usersNewArr=new User[users.length*2];
        int j=0;
        for (; j < users.length; j++) {
            usersNewArr[j] = users[j];
        }
        usersNewArr[j] = new Seller(username, password);
        System.out.println("User added successfully.");
        users = usersNewArr;
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
            for (int i = 0; i < buyers.length; i++) {
                if(buyers[i]==null){
                    buyers[i] = new Buyer(username,password,address);
                    System.out.println("Buyer added successfully.");
                    break;
                }
            }
            Buyer[] newArr=new Buyer[buyers.length*2];
            int i=0;
            for (; i < buyers.length; i++) {
                newArr[i] = buyers[i];
            }
            newArr[i] = new Buyer(username,password,address);
            buyers = newArr;
            //adding a new buyer to the users list
            for (int j = 0; j < users.length; j++) {
                if(users[j]==null){
                    users[j] = new Seller(username, password);
                    System.out.println("User added successfully.");
                    return;
                }
            }
            User[] usersNewArr=new Seller[users.length*2];
            int j=0;
            for (; j < users.length; j++) {
                usersNewArr[j] = users[j];
            }
            usersNewArr[j] = new Seller(username, password);
            users = usersNewArr;
        }

    }
    public void addBuyer(String username,String password,String address) {
        for (int i = 0; i < buyers.length; i++)
        {
            if(buyers[i]==null){
                buyers[i] = new Buyer(username,password,address);
                break;
            }
        }
        Buyer[] newArr=new Buyer[buyers.length*2];
        int i=0;
        for (; i < buyers.length; i++) {
            newArr[i] = buyers[i];
        }
        newArr[i] = new Buyer(username,password,address);
        buyers = newArr;
        //adding a new buyer to the users list
        for (int j = 0; j < users.length; j++) {
            if(users[j]==null){
                users[j] = new Seller(username, password);
                System.out.println("User added successfully.");
                return;
            }
        }
        User[] usersNewArr=new Seller[users.length*2];
        int j=0;
        for (; j < users.length; j++) {
            usersNewArr[j] = users[j];
        }
        usersNewArr[j] = new Seller(username, password);
        System.out.println("User added successfully.");
        users = usersNewArr;
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
    public void printNames(){
        for(User user : users){
            if(user!=null){
                System.out.println(user.getUsername());
            }
        }
    }
    public void countNames(Scanner scanner){
        System.out.print("please enter the name you want to count:");
        String username = scanner.nextLine();
        int count = 0;
        for(User user : users){
            if(user.getUsername().equals(username)){
                count++;
            }
        }
        System.out.println("the name "+username+" appears "+count+" times \n");
    }

    public void populate(){
        String[] names={"Alice","Bob","Charlie","Delta","Echo","Fred","Greg","Hugo"};
        Random rand = new Random();
        int index = rand.nextInt(0,names.length);
        String password="bb";
        String address="ccc";
        for (int i = 0; i < 8; i++) {
            String name = names[index];
            if(i%2==0) {
                addSeller(name, password);
            } else {
                addBuyer(name, password, address);
            }
            index=rand.nextInt(0,names.length);
        }
        System.out.println(users);
    }

    public void arrangeByLength(){
        if(users.length==0){
            System.out.println("Users array is empty. Please choose a valid username.");
            return;
        }
        ArrayList<String> usersNewArr=new ArrayList<>();
        for(User user : users){
            if(!usersNewArr.contains(user.getUsername()))
                usersNewArr.add(user.getUsername());
        }
        usersNewArr.sort((name1, name2) -> {
            return name1.length() - name2.length();
        });
        usersNewArr.forEach(u ->System.out.println(u.toUpperCase()));
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

    public void doubleArrayList(){
        ArrayList<User> usersArrayList=new ArrayList<>();
        ListIterator<User> Li=usersArrayList.listIterator();
        for (User user : users) {
            Li.add(user);
            Li.add(user);
        }
        while(Li.hasPrevious()){
            System.out.println(Li.previous().getUsername());
        }
    }

    public void hashUsers(){
        for (User user : users) {
            if(hashMap.containsKey(user.getUsername().toLowerCase())){
                hashMap.compute(user.getUsername().toLowerCase(), (k, counter) -> counter + 1);
            }
            else
                hashMap.put(user.getUsername().toLowerCase(),1);
        }
        for(Map.Entry<String,Integer> element:hashMap.entrySet()){
            String output=element.getKey()+".........."+element.getValue().toString();
            System.out.println(output);
        }
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
