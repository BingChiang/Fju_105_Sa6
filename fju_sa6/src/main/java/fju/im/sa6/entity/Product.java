package fju.im.sa6.entity;

public class Product {

	private int productNum;

	private int typeNum;

	private String productName;

	private int productPrice;
	
	private int productSellMonth;
	//2016.11.30 by bing....delete cost value and add init value
	public Product(int productNum, int typeNum, String productName, int productPrice,int productSellMonth) {
		this.productNum = productNum;
		this.typeNum = typeNum;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productSellMonth = productSellMonth;
	}
	
	public Product(){
		this.productNum = 0;
		this.typeNum = 0;
		this.productName = null;
		this.productPrice = 0;
		this.productSellMonth = 0;
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

	
	
	
}
