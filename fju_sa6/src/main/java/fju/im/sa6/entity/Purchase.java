package fju.im.sa6.entity;

import java.util.Date;

public class Purchase {

	private String purchaseName;

	private int purchaseNum;

	private double purchasePrice;

	private Date purchaseDate;

	public Purchase(String purchaseName,int purchaseNum, double purchasePrice, Date purchaseDate) {
		this.purchaseName = purchaseName;
		this.purchaseNum = purchaseNum;
		this.purchasePrice = purchasePrice;
		this.purchaseDate = purchaseDate;
	}
	public Purchase(){
		this.purchaseName = null;
		this.purchaseNum = 0;
		this.purchasePrice = 0;
		this.purchaseDate = null;
		
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
