public class Customer extends User{
    private String address;
    private double balance;
    private int phone;

    public Customer(String address, double balance, int phone, String email, String password) {
        this.address = address;
        this.balance = balance;
        this.phone = phone;
        super.setEmail(email);
        super.setPassword(password);
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
