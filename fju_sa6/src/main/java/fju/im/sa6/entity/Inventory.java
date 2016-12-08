package fju.im.sa6.entity;

import java.util.Date;

public class Inventory {

	private int inventoryNum;

	private int purchaseNum;

	private int inventoryAmount;

	private int supplierNum;

	private String inventoryName;

	private Date purchase_date;
	
	private int reorder_point;

	// 2016.11.30 by bing.... add init value
	public Inventory(int inventoryNum, int purchaseNum, int supplierNum, String inventoryName,
			int reorder_point, Date purchase_date) {
		this.inventoryNum = inventoryNum;
		this.purchaseNum = purchaseNum;
		this.inventoryAmount = inventoryAmount;
		this.supplierNum = supplierNum;
		this.inventoryName = inventoryName;
		this.reorder_point = reorder_point;
		this.purchase_date = purchase_date;
	}

	public Inventory() {
		this.inventoryNum = 0;
		this.purchaseNum = 0;
		this.inventoryAmount = 0;
		this.supplierNum = 0;
		this.inventoryName = null;
		this.reorder_point = 0;
		this.purchase_date = null;
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

	public int getPurchaseNum() {
		return purchaseNum;
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

	public Date getPurchaseDate() {
		return purchase_date;
	}

	public void setPurchaseDate(Date purchase_date) {
		this.purchase_date = purchase_date;
	}
	public int getReorderPoint(){
		return reorder_point;
	}
	public void setReorderPoint(int reorder_point){
		this.reorder_point = reorder_point;	
	}

}
