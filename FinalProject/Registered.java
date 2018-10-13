import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registered {
    private static List<Customer> customerList;

    public Registered() { this.customerList = new ArrayList<Customer>(); }

    public static boolean addCumstomer(Customer customer) {
        return customerList.add(customer); }

    public static boolean removeCustomer(int index) {
        return customerList.remove(index) != null;
    }

    public static boolean validateEmail(String email) {
        String regex = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            //addFormException(new DropletException("Email not valid "));
            return true;
        }
        return false;
    }

    public static boolean validatePassword(String password) {
       return password.length() > 0;
    }

    public static boolean validatePhone(String phone) {
        return (phone.length() == 10) && (phone.charAt(0) == '0' );

    }

    public static Customer getByEmail(String email) {
        for (Customer customer : customerList) {
            if (customer.getEmail() == email) {
                return customer;
            }
        }
        return null;
    }


}
