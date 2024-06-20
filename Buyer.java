package project;

public class Buyer extends User {
    private String address;

    public Buyer(String username, String password, String address) {
        super(username, password);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
