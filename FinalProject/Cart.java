import java.util.ArrayList;
import java.util.List;

public class Cart {
    private static List<Product> productList;
    public static boolean addItem(Product product) {
        return productList.add(product);

    }

    public static boolean removeItem(int index) {
         return productList.remove(index) != null;

    }

    public static boolean updateCart(int index, int num) {
        if (num == 0)
            return productList.remove(index) != null;
        else
            return productList.set(index, productList.get(index).setProductNum(num)) != null;
    }

    public static boolean clearCart(){
        return productList.removeAll(productList);
    }

    public Cart() {
        this.productList = new ArrayList<Product>();
    }

    public static List<Product> getProductList() {
        return productList;
    }

    public static void setProductList(List<Product> productList) {
        productList = productList;
    }

    public static double getTotalPrice(){
        double total = 0;
        for (Product p: productList){
            total += p.getPrice() * p.getProductNum();
        }
        return total;
    }
}
