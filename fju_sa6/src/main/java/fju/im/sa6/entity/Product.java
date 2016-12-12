package fju.im.sa6.entity;

public class Product {

	private int productNum;

	private int typeNum;

	private String productName;

	private int productPrice;

	private int productSellMonth;

	private int productCost;

	private String typeName;

	public Product(int productNum, int typeNum, String typeName, String productName, int productPrice,
			int productSellMonth, int productCost) {
		this.productNum = productNum;
		this.typeNum = typeNum;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productSellMonth = productSellMonth;
		this.productCost = productCost;
		this.typeName = typeName;

	}

	public Product() {
		this.productNum = 0;
		this.typeNum = 0;
		this.productName = null;
		this.productPrice = 0;
		this.productSellMonth = 0;
		this.productCost = 0;
		this.typeName = null;
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

	public int getProductCost() {
		return productCost;
	}

	public void setProductCost(int productCost) {
		this.productCost = productCost;
	}

	public String getTypeName() {
		return typeName;
	}
	public void setTypeNum(int num) {
		this.typeNum = num;
	}

	public void setTypeName(String typeName) {

		this.typeName = typeName;
	}

}
