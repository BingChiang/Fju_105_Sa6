package fju.im.sa6.entity;

import java.util.Date;

public class Inventory extends Supplier{

	private int inventoryNum;

	private int inventoryAmount;

	private int supplierNum;

	private String inventoryName;
	
	private int reorderPoint;
	
	private Date update_date;
	
	private String supplierName;
	
	private String update;

	public Inventory(int inventoryNum,int inventoryAmount,int supplierNum, String supplierName, String inventoryName,
			int reorderPoint, Date update_date) {
		this.inventoryNum = inventoryNum;
		this.inventoryAmount = inventoryAmount;
		this.supplierNum = supplierNum;
		this.inventoryName = inventoryName;
		this.supplierName = supplierName;
		this.reorderPoint = reorderPoint;
		this.update_date = update_date;
		this.update="";

	}

	public Inventory() {
		this.inventoryNum = 0;
		this.inventoryAmount = 0;
		this.supplierNum = 0;
		this.inventoryName = null;
		this.reorderPoint = 0;
		this.supplierName = null;
		this.update_date = null;
		
		this.update = "";

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
		return reorderPoint;
	}
	public void setReorderPoint(int reorderPoint){
		this.reorderPoint = reorderPoint;	
	}
	public void setUpdateDate(Date update_date){
		this.update_date = update_date;	
	}
	public Date getUpdateDate(){
	return update_date;
	}
	
	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	
	public void setUpdate(String update_date) {
		this.update = update_date;
	}
	public String getUpdate(){
		return this.update;
	}
}
