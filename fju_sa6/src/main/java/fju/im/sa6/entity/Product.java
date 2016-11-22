package fju.im.sa6.entity;

public class Product {

	private int productNum;

	private int typeNum;

	private String productName;

	private int productPrice;

	private int productCost;

	private int productSellMonth;

	public Product(int productNum, int typeNum, String productName, int productPrice, int productCost,
			int productSellMonth) {
		this.productNum = productNum;
		this.typeNum = typeNum;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCost = productCost;
		this.productSellMonth = productSellMonth;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductCost() {
		return productCost;
	}

	public void setProductCost(int productCost) {
		this.productCost = productCost;
	}

	public int getProductSellMonth() {
		return productSellMonth;
	}

	public void setProductSellMonth(int productSellMonth) {
		this.productSellMonth = productSellMonth;
	}

	public int getProductNum() {
		return productNum;
	}

	public int getTypeNum() {
		return typeNum;
	}

	
	
	
}
