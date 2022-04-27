package project;

public class Stationary {

	int productId;
	String  productName;
	int productPiecePrice;
	int totalProductQuantity;
	
	public int getId() {
		return productId;
	}
	public void setId(int id) {
		this.productId = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public   int getQuantity() {
		return totalProductQuantity;
	}
	public  void setQuantity(int quantity) {
		this.totalProductQuantity = quantity;
	}
	public  void updateQuantity(int quantity) {
		totalProductQuantity = totalProductQuantity-quantity;
	}
	public int getupdatedQuantity() {
		return totalProductQuantity;
	}
	public int getPrice() {
		return productPiecePrice;
	}
	public void setPrice(int price) {
		this.productPiecePrice = price;
	}
	public Stationary(int id,String productName, int price, int quantity) {
		this.productId = id;
		this.productName = productName;
		this.productPiecePrice = price;
		this.totalProductQuantity=quantity;
	}
	@Override
	public String toString() {
		return "\t" + productId +"\t" + productName + "\t" + productPiecePrice + "\t"+totalProductQuantity;
	}	
}
