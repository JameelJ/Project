package project;

import java.util.ArrayList;
import java.util.List;

public class Stationary {
//	static 
	int id;
	String  productName;
	int Price;
	int Quantity;
	
	
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
		return Quantity;
	}
	public  void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public  void updateQuantity(int quantity) {
		Quantity = Quantity-quantity;
	}public int getupdatedQuantity() {
		return Quantity;
	}
	
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public Stationary(int id,String productName, int price, int quantity) {
		this.id = id;
		this.productName = productName;
		Price = price;
		Quantity=quantity;
	}
	@Override
	public String toString() {
		return "id=" + id +", \tproductName=" + productName + ", \tPrice=" + Price + ", \tQuantity=" + Quantity;
	}	
}
