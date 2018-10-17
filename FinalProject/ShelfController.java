import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ShelfController {

    public static boolean updateProduct(int index, Product newProduct) {
        return Shelf.updateProduct(index, newProduct);
    }

    public static boolean insertProduct(Product product) {
        return Shelf.insertProduct(product);
    }

    public static boolean removeProduct(int index) {
        return Shelf.removeProduct(index);
    }

    public static List<Product> searchProduct(String productName) {
        return Shelf.searchProduct(productName);
    }
    public static void readFile() throws FileNotFoundException, ParseException {
        Shelf.readFile();
    }
    public static void writeFile() throws FileNotFoundException{
        Shelf.writeFile();
    }

    public static List<Product> getShelfProducts(){
        return Shelf.getShelfProducts();
    }
}
