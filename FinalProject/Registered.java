import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registered {
    private static List<Customer> customerList;

    public Registered() {
        customerList = new ArrayList<>();
        Customer admin = new Customer("adminAddress",9999999,"0999999999","admin@test.com", "12345678");
        customerList.add(admin);
    }

    public static boolean addCustomer(Customer customer) {
        return customerList.add(customer); }

    public static boolean removeCustomer(int index) {
        return customerList.remove(index) != null;
    }

    public static Customer viewCustomer(int index) {
        return customerList.get(index);
    }

    public static boolean validateEmail(String email) {
        String regex = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean validatePassword(String password) {
       return password.length() > 0;
    }

    public static boolean validatePhone(String phone) {
        return (phone.length() == 10) && (phone.charAt(0) == '0' );

    }

    public static Customer getByEmail(String email) {
        for (Customer customer : customerList) {
            if (customer.getEmail().equals(email)) {
                return customer;
            }
        }
        return null;
    }

    public static void readFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("Customer.csv"));
//        scanner.useDelimiter(",");
        String line;
        int tSize;
        if (scanner.hasNext()) {
            line = scanner.next();
            String[] arguments = line.split(",");
            tSize = Integer.parseInt(arguments[0]);
            customerList = new ArrayList<>();
            for (int i = 0; i < tSize; i++) {
                line = scanner.next();
                String[] parts = line.split(",");
                String email = parts[0];
                String password = parts[1];
                String address = parts[2];
                double balance = Double.parseDouble(parts[3]);
                String phone = parts[4];
                Customer tmpCustomer = new Customer(address, balance, phone, email, password);
                customerList.add(tmpCustomer);
            }
        }
        scanner.close();
    }

    public static void writeFile() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File("transactions.csv"));
        StringBuilder sb = new StringBuilder();
        sb.append(customerList.size());
        sb.append('\n');
        for (Customer customer : customerList) {
            sb.append(customer.getEmail());
            sb.append(',');
            sb.append(customer.getPassword());
            sb.append(',');
            sb.append(customer.getAddress());
            sb.append(',');
            sb.append(customer.getBalance());
            sb.append(',');
            sb.append(customer.getPhone());
            sb.append('\n');
        }
        pw.write(sb.toString());
        pw.close();
        System.out.println("Write to CustomerDB done!");
    }
    
     public static int login(String email, String password) {
        if (email.equals("admin@test.com") && password.equals("12345678")) {
            return 0;
        }else {
            for (Customer customer : customerList) {
                if (customer.getEmail().equals(email) && customer.getPassword().equals(password)) {
                    return 1;
                }
            }
        }
        return 2;
    }
}

