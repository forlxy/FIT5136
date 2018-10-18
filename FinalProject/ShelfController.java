import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    public static boolean validateProductId(int Id) {
        for (Product product : getShelfProducts()) {
            if (product.getId() == Id) {
                return false;
            }
        }
        return true;
    }

    public static boolean validateProductName(String name) {
        String regex = "^(?=.*[A-Za-z]).{1,10}$";
        return name.matches(regex);
    }

    public static boolean validateProductType(int type) {
        if (type == 0 || type == 1)
            return true;
        else
            return false;
    }

    public static boolean validateProductPrice(double price) {
        if (price < 0) {
            return false;
        }
        return true;
    }

    public static boolean validateProductShelfLife(int shelfLife) {
        if (shelfLife > 0)
            return true;
        return false;
    }

    public static boolean validateProductStartDate(String strStartDate) {
        if (strStartDate.trim().equals("")) {
            return false;
        } else {

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            try {
                dateFormat.parse(strStartDate);
            } catch (Exception e) {
                return false;
            }

            return true;
        }

    }

    public static boolean validateProductDiscountRate(double discountRate) {
        if (discountRate >= 0 || discountRate <= 1) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validateProductSellType(int sellType) {
        if (sellType == 0 || sellType == 1)
            return true;
        else
            return false;
    }

    public static boolean validateProductNum(int productNum) {
        if (productNum > 0)
            return true;
        else
            return false;
    }

}
