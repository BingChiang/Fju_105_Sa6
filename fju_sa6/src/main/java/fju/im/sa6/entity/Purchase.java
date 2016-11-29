package fju.im.sa6.entity;

import java.util.Date;

public class Purchase {

	private String purchaseName;

	private int purchaseNum;

	private double purchasePrice;

	private Date purchaseDate;

	public Purchase(int inventoryNum, int purchaseNum, int inventoryAmount, int supplierNum, String inventoryName,
			String purchaseName, int purchaseNum2, double purchasePrice, Date purchaseDate) {
		super(inventoryNum, purchaseNum, inventoryAmount, supplierNum, inventoryName);

		this.purchaseName = purchaseName;
		this.purchaseNum = purchaseNum;
		this.purchasePrice = purchasePrice;
		this.purchaseDate = purchaseDate;
	}

	public String getPurchaseName() {
		return purchaseName;
	}

	public void setPurchaseName(String purchaseName) {
		this.purchaseName = purchaseName;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public int getPurchaseNum() {
		return purchaseNum;
	}

}
