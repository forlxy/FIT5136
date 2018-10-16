import java.util.Date;

public class Product {
	
	int id;
	String name;
	int type;
	double price;
	int shelfLife;
	Date startDate;
	double discountRate;
	int sellType;  
	int productNumber;
	
	public Product() {
		id = 0;
		name = "";
		type = 0;
		price = 0;
		shelfLife = new Date();
		startDate = new Date();
		discountRate = 1;
		sellType = 0;
		productNumber = 0;
		
	}
	
	public Product(int id, String name, int type, double price, int shelfLife, 
				Date startDate, double discountRate, int sellType, int productNumber) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
		this.shelfLife = shelfLife;
		this.startDate = startDate;
		this.discountRate = discountRate;
		this.sellType = sellType;
		this.productNumber = productNumber;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		 this.name = name;
	}
	
	public int getType() {
		return type;
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getShelfLife() {
		return shelfLife;
	}
	
	public void setShelfLife(int shelfLife) {
		this.shelfLife = shelfLife;
	}
	
	public double getDiscountRate() {
		return discountRate;
	}
	
	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public int getSellType() {
		return sellType;
	}
	
	public void setSellType(int sellType) {
		this.sellType = sellType;
	}
	
	public int getProductNumber() {
		return productNumber;
	}
	
	public void setProductNumber(int productNumeber) {
		this.productNumber = productNumeber;
	}
	
}
