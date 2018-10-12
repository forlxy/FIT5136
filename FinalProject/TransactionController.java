import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.List;

public class TransactionController {
    //For owner
    public static Order viewOrder(int index) {
        return Transaction.viewOrder(index);
    }

    //For customer
    public static Order viewOrder(Customer customer, int index) {
        return Transaction.viewOrder(customer, index);
    }

    //Show All
    public static List<Order> viewOrder(Customer customer) {
        return Transaction.viewOrder(customer);
    }

    public static void readFile() throws FileNotFoundException, ParseException {
        Transaction.readFile();
    }

    public static void writeFile() throws FileNotFoundException {
        Transaction.writeFile();
    }
}
