package fju.im.sa6.entity;

public class ProductList {

	private int productNum;

	private int amount;

	public ProductList(int productNum, int amount) {
		this.productNum = productNum;
		this.amount = amount;
	}

	public ProductList() {
		this.productNum = 0;
		this.amount = 0;
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
