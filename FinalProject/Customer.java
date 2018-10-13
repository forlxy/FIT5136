public class Customer extends User{
    private String address;
    private double balance;
    private String phone;

    public Customer(String address, double balance, String phone, String email, String password) {
        this.address = address;
        this.balance = balance;
        this.phone = phone;
        super.setEmail(email);
        super.setPassword(password);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
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
