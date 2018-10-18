import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ShelfController {
    /**
     * update product.
     * @param index
     * @param newProduct
     * @return
     */
    public static boolean updateProduct(int index, Product newProduct) {
        return Shelf.updateProduct(index, newProduct);
    }

    /**
     * Add new product.
     * @param product
     * @return
     */
    public static boolean insertProduct(Product product) {
        return Shelf.insertProduct(product);
    }

    /**
     * remove product
     * @param index
     * @return
     */
    public static boolean removeProduct(int index) {
        return Shelf.removeProduct(index);
    }

    /**
     * search product by name
     * @param productName
     * @return
     */
    public static List<Product> searchProduct(String productName) {
        return Shelf.searchProduct(productName);
    }

    /**
     * import products
     * @throws FileNotFoundException
     * @throws ParseException
     */
    public static void readFile() throws FileNotFoundException, ParseException {
        Shelf.getShelfProducts().clear();
        Shelf.readFile();
    }

    /**
     * record products information.
     * @throws FileNotFoundException
     */
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

    /**
     * check if is the valid product name.
     * @param name
     * @return
     */
    public static boolean validateProductName(String name) {
        String regex = "^(?=.*[A-Za-z]).{1,10}$";
        return name.matches(regex);
    }

    /**
     * check if id the valid product type.
     * @param type
     * @return
     */
    public static boolean validateProductType(int type) {
        if (type == 0 || type == 1)
            return true;
        else
            return false;
    }

    /**
     * check if is the valid product price
     * @param price
     * @return
     */
    public static boolean validateProductPrice(double price) {
        if (price < 0) {
            return false;
        }
        return true;
    }

    /**
     * check if is the valid product
     * @param shelfLife
     * @return
     */
    public static boolean validateProductShelfLife(int shelfLife) {
        if (shelfLife > 0)
            return true;
        return false;
    }

    /**
     * check if is the valid product start date.
     * @param strStartDate
     * @return
     */
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

    /**
     * check if is the valid product discount rate.
     * @param discountRate
     * @return
     */
    public static boolean validateProductDiscountRate(double discountRate) {
        if (discountRate >= 0 && discountRate <= 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * check if is the valid product sell type.
     * @param sellType
     * @return
     */
    public static boolean validateProductSellType(int sellType) {
        if (sellType == 0 || sellType == 1)
            return true;
        else
            return false;
    }


    /**
     * check if is the valid product number.
     * @param productNum
     * @return
     */
    public static boolean validateProductNum(int productNum) {
        if (productNum > 0)
            return true;
        else
            return false;
    }

}
