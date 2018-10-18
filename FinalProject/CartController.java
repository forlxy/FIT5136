import java.util.ArrayList;
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
        Order newOrder = new Order(UUID.randomUUID().toString(), MainInterface.getCurrentUser(), new ArrayList<>(Cart.getProductList()), new Date(), Cart.getTotalPrice());
        boolean result = Transaction.addOrder(newOrder);
        for(Order o: Transaction.getOrderList()){
            System.out.println(o);
        }
        for (Product pInCart: Cart.getProductList()) {
            Product pOnShelf= Shelf.getProductById(pInCart.getId());
            if (pOnShelf != null) {
                pOnShelf.setProductNumber(pOnShelf.getProductNumber() - pInCart.getProductNumber());
            }
        }
        clearCart();
        return result;
    }

    public static List<Product> getProductList() {
        return Cart.getProductList();
    }

}
