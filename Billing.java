package project;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;  

public class Billing {
	String ProductName;
	int Quantity;
	int Price;
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public Billing(String productName, int quantity, int price) {
		super();
		ProductName = productName;
		Quantity = quantity;
		Price = price;
	}
	@Override
	public String toString() {
		return "ProductName=" + ProductName + ", \tQuantity=" + Quantity +",\tPrice="+Price +"";
	}	
}
