import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List; 


public class Shelf {
	
	private static List<Product> shelfProducts;
	
	public Shelf() {
		Shelf.shelfProducts = new ArrayList<Product>();
	}
	
	public static boolean updateProduct(int index, int productNumeber) {
		shelfProducts.get(index).setProductNumber(productNumeber);
		return shelfProducts.set(index, shelfProducts.get(index)) != null;
	}
	
	public static boolean insertProduct(Product product) {
		return shelfProducts.add(product);
	}
	
	public static boolean removeProduct(int index) {
		return shelfProducts.remove(index) != null;
	}
	
	public static boolean validateProductName(String name) {
		
		return true;
	}
	
	public static boolean validateProductType(int type) {
		
		return true;
	}
	
	public static boolean validateProductPrice(double price) {
		if (price < 0) {
			return false;
		}
		return true;
	}
	
	public static boolean validateProductShelfLife() {
		
		return true;
	}
	
	public static boolean validateProductStartDate(String strStartDate) {
		if (strStartDate.trim().equals(""))
		{
		    return false;
		} else {
			
			SimpleDateFormat dateFormate = new SimpleDateFormat("dd/MM/yyyy");
			try {
				dateFormate.parse(strStartDate);
			}
			catch (Exception e) {
				return false;
			}
			
			return true;
		}
		
	}
	
	public static boolean validateProductDiscountRate(int discountRate) {
		if (discountRate >= 0 || discountRate <= 1) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean validateProductSellType() {
		
		return true;
	}
}
