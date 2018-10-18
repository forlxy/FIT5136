import java.util.ArrayList;
import java.util.List;

public class Cart {
    private static List<Product> productList;
    public static boolean addItem(Product product) {
        return productList.add(product);

    }
    /**
     * remove product from the cart
     * @param index
     * @return
     */
    public static boolean removeItem(int index) {
        return productList.remove(index) != null;
    }

    /**
     * update items to the cart.
     * @param index
     * @param num
     * @return
     */
    public static boolean updateCart(int index, int num) {
        if (num == 0)
            return productList.remove(index) != null;
        else {
            Product targetProduct = productList.get(index);
            targetProduct.setProductNumber(num);
            return productList.set(index, targetProduct) != null;
        }
    }

    public static void initialize() {
        if (productList == null)
            productList = new ArrayList<Product>();
    }

    /**
     * clear the cart.
     * @return
     */
    public static boolean clearCart(){
        return productList.removeAll(productList);
    }

    public Cart() {
        initialize();
    }

    static {
        initialize();
    }

    public static List<Product> getProductList() {
        return productList;
    }

    /**
     * caculate total price.
     * @return
     */
    public static double getTotalPrice(){
        double total = 0;
        for (Product p: productList){
            total += p.getPrice() * p.getProductNumber() * p.getDiscountRate();
        }
        return total;
    }
}
