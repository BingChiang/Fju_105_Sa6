package fju.im.sa6.entity;

public class ProductList {

	private int productNum;

	private int amount;

	public ProductList(int productNum, int amount) {
		this.productNum = productNum;
		this.amount = amount;
	}

	public int getProductNum() {
		return productNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	

}
