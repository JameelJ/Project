package project;  

public class Billing {
	int productId;
	String productName;
	int totalQuantity;
	int productPiecePrice;
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return totalQuantity;
	}

	public void setQuantity(int quantity) {
		this.totalQuantity = quantity;
	}

	public int getPrice() {
		return productPiecePrice;
	}

	public void setPrice(int price) {
		this.productPiecePrice = price;
	}

	public Billing(int productId, String productName, int quantity, int price) {
		this.productId = productId;
		this.productName = productName;
		this.totalQuantity = quantity;
		this.productPiecePrice = price;
	}
	public String toString() {
		return "\t" + productId +"\t" + productName + "\t" + totalQuantity + "\t\t"+ productPiecePrice;
	}	
}
