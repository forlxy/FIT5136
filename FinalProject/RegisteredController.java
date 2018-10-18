import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileNotFoundException;


public class RegisteredController {
    /**
     * readFile
     * @throws FileNotFoundException
     */
    public static void readFile() throws FileNotFoundException {
        Registered.readFile();
    }

    public static void writeFile() throws FileNotFoundException {
        Registered.writeFile();
    }
    
    public static boolean addCustomer(Customer customer) {
        return Registered.addCustomer(customer);
    }
    
    public static boolean removeCustomer(int index) {
        return Registered.removeCustomer(index);
    }
    
    public static Customer viewCustomer(int index) {
        return Registered.viewCustomer(index);
    }
    
    public static int login(String email, String password){
        return Registered.login(email, password);
    }
    
    public static Customer getByEmail(String email) {
        return Registered.getByEmail(email);
    }

    /**
     * validate Email address.
     * @param email
     * @return
     */
    public static boolean validateEmail(String email) {
        String regex = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /**
     * validate Password.
     * @param password
     * @return
     */
    public static boolean validatePassword(String password) {
       return password.length() > 5 && password.length() < 12;
    }

    /**
     * validate phone number.
     * @param phone
     * @return
     */
    public static boolean validatePhone(String phone) {
        return (phone.length() == 10) && (phone.charAt(0) == '0' );

    }
}