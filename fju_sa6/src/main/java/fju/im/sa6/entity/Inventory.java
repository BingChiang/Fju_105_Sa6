package fju.im.sa6.entity;

public class Inventory {

	private int inventoryNum;

	private int purchaseNum;

	private int inventoryAmount;

	private int supplierNum;

	private String inventoryName;

	
	//2016.11.30 by bing.... add init value
	public Inventory(int inventoryNum, int purchaseNum, int inventoryAmount, int supplierNum, String inventoryName) {
		this.inventoryNum = inventoryNum;
		this.purchaseNum = purchaseNum;
		this.inventoryAmount = inventoryAmount;
		this.supplierNum = supplierNum;
		this.inventoryName = inventoryName;
	}

	public Inventory(){
		this.inventoryNum = 0;
		this.purchaseNum = 0;
		this.inventoryAmount = 0;
		this.supplierNum = 0;
		this.inventoryName = null;
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

	

}
