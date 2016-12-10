package fju.im.sa6.entity;

import java.util.Date;

public class Purchase {


	private int purchaseNum;

	private double purchasePrice;

	private Date purchaseDate;

	private int inventoryNum;

	private int inventoryAmount;

	private int supplierNum;

	private String inventoryName;

	public Purchase(int inventoryNum, int purchaseNum, int supplierNum, String inventoryName, double purchasePrice,int inventoryAmount, Date purchaseDate) {
		this.inventoryNum = inventoryNum;
		this.purchaseNum = purchaseNum;
		this.inventoryAmount = inventoryAmount;
		this.supplierNum = supplierNum;
		this.inventoryName = inventoryName;
		this.purchasePrice = purchasePrice;
		this.purchaseDate = purchaseDate;
	}

	public Purchase() {
		this.inventoryNum = 0;
		this.purchaseNum = 0;
		this.inventoryAmount = 0;
		this.supplierNum = 0;
		this.inventoryName = null;
		this.purchaseNum = 0;
		this.purchasePrice = 0;
		this.purchaseDate = null;

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
	
	public int getInventoryNum() {
		return inventoryNum;
	}

	public void setInventoryNum(int inventoryNum) {
		this.inventoryNum = inventoryNum;
	}

	public String getInventoryName() {
		return inventoryName;
	}

	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}

	public void setPurchaseNum(int purchaseNum) {
		this.purchaseNum = purchaseNum;
	}

	public int getInventoryAmount() {
		return inventoryAmount;
	}

	public void setInventoryAmount(int inventoryAmount) {
		this.inventoryAmount = inventoryAmount;
	}

	public int getSupplierNum() {
		return supplierNum;
	}

	public void setSupplierNum(int supplierNum) {
		this.supplierNum = supplierNum;
	}

	
}