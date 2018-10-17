
public class ShelfController {

	public static boolean updateProduct(int index, int productNumber) {
        return Shelf.updateProduct(index, productNumber);
     }
	
	public static boolean insertProduct(Product product) {
        return Shelf.insertProduct(product);
     }
	
	public static boolean removeProduct(int index) {
        return Shelf.removeProduct(index);
     }
}
