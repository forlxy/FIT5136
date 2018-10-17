import java.io.FileNotFoundException;

public class RegisteredController {
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
}
