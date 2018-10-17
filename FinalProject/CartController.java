import java.util.Date;
import java.util.List;
import java.util.UUID;

public class CartController {

    public static boolean addItem(Product product) {
        return Cart.addItem(product);

    }

    public static boolean removeItem(int index) {
        return Cart.removeItem(index);

    }

    public static boolean updateCart(int index, int num) {
        return Cart.updateCart(index, num);
    }

    public static boolean clearCart(){
        return Cart.clearCart();
    }

    public static boolean purchase() {
        Order newOrder = new Order(UUID.randomUUID().toString(), Registered.getCurrentUser(), Cart.getProductList(), new Date(), Cart.getTotalPrice());
        return Transaction.addOrder(newOrder);
    }


    public static List<Product> getProductList() {
        return Cart.getProductList();
    }

}
