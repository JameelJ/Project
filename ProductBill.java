package project;  

public class ProductBill {
	int productId;
	String productName;
	int totalQuantity;
	int piecePrice;
	int productPiecePrice;
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getPiecePrice() {
		return piecePrice;
	}

	public void setPiecePrice(int piecePrice) {
		this.piecePrice = piecePrice;
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

	public ProductBill(int productId, String productName, int totalQuantity, int piecePrice, int productPiecePrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.totalQuantity = totalQuantity;
		this.piecePrice = piecePrice;
		this.productPiecePrice = productPiecePrice;
	}

	public String toString() {
		return "\t" + productId +"\t" + productName + "\t" + totalQuantity + "\t\t"+piecePrice+"\t\t"+ productPiecePrice;
	}	
}
