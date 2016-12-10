package fju.im.sa6.entity;

import java.util.Date;

public class Inventory {

	private int inventoryNum;

	private int inventoryAmount;

	private int supplierNum;

	private String inventoryName;
	
	private int reorder_point;
	
	private Date update_date;
	

	// 2016.11.30 by bing.... add init value
	public Inventory(int inventoryNum,int inventoryAmount,int supplierNum, String inventoryName,
			int reorder_point, Date update_date) {
		this.inventoryNum = inventoryNum;
		this.inventoryAmount = inventoryAmount;
		this.supplierNum = supplierNum;
		this.inventoryName = inventoryName;
		this.reorder_point = reorder_point;
		this.update_date = update_date;
	}

	public Inventory() {
		this.inventoryNum = 0;
		this.inventoryAmount = 0;
		this.supplierNum = 0;
		this.inventoryName = null;
		this.reorder_point = 0;
		this.update_date = null;
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
	public int getReorderPoint(){
		return reorder_point;
	}
	public void setReorderPoint(int reorder_point){
		this.reorder_point = reorder_point;	
	}
	public void setUpdateDate(Date update_date){
		this.update_date = update_date;	
	}
	public Date getUpdateDate(){
	return update_date;
	}
}
