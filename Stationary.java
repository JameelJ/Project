package project;

public class Stationary {

	int id;
	String  productName;
	int price;
	int quantity;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public   int getQuantity() {
		return quantity;
	}
	public  void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public  void updateQuantity(int quantity) {
		quantity = quantity-quantity;
	}
	public int getupdatedQuantity() {
		return quantity;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Stationary(int id,String productName, int price, int quantity) {
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.quantity=quantity;
	}
	@Override
	public String toString() {
		return "\t" + id +"\t" + productName + "\t" + price + "\t"+quantity;
	}	
}
