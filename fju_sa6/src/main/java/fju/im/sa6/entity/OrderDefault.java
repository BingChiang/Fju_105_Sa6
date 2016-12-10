package fju.im.sa6.entity;

public class OrderDefault {

	// private ArrayList<Product> product;
	private int orderlistNum;
	private int productNum;
	private String productName;
	private int productPrice;

	public OrderDefault(int orderlistNum, int productNum, String productName, int productPrice) {
		this.orderlistNum = orderlistNum;
		this.productNum = productNum;
		this.productNum = productNum;
		this.productPrice = productPrice;
	}

	public OrderDefault() {
		this.productNum = 0;
		this.orderlistNum = 0;
		this.productName = null;
		this.productPrice = 0;
	}

	public int getOrderlistNum() {
		return orderlistNum;
	}

	public void setOrderlistNum(int orderlistNum) {
		this.orderlistNum = orderlistNum;
	}

	public int getProductNum() {
		return productNum;
	}

	public void setProductNum(int productNum) {
		this.productNum = productNum;
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

}
