package fju.im.sa6.entity;

public class OrderDefault {

	private int orderlistNum;

	private int productNum;

	private int typeNum;

	private int productPrice;

	private int orderAmount;

	private String productName;

	public OrderDefault(int orderlistNum, int productNum, int typeNum, int productPrice, int orderAmount,
			String productName) {
		this.orderlistNum = orderlistNum;
		this.productNum = productNum;
		this.typeNum = typeNum;
		this.productPrice = productPrice;
		this.orderAmount = orderAmount;
		this.productName = productName;
	}

	public OrderDefault() {
		this.orderlistNum = 0;
		this.productNum = 0;
		this.typeNum = 0;
		this.productPrice = 0;
		this.orderAmount = 0;
		this.productName = null;

	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}

	public int getOrderlistNum() {
		return orderlistNum;
	}

	public int getProductNum() {
		return productNum;
	}

	public int getTypeNum() {
		return typeNum;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

}
