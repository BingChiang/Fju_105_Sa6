package fju.im.sa6.entity;

public class Supplier {

	private int supplierNum;

	private int inventoryNum;

	private int purchaseNum;

	private String supplierName;

	private String supplierPhone;

	private String supplierAddress;
	//rebuild by bing 2016.11.30 ...and add init value
	public Supplier(int supplierNum, int inventoryNum, int purchaseNum, String supplierName, String supplierPhone,
			String supplierAddress) {
		this.supplierNum = supplierNum;
		this.inventoryNum = inventoryNum;
		this.purchaseNum = purchaseNum;
		this.supplierName = supplierName;
		this.supplierPhone = supplierPhone;
		this.supplierAddress = supplierAddress;
	}
	
	public Supplier(){
		this.supplierNum = 0;
		this.inventoryNum = 0;
		this.purchaseNum = 0;
		this.supplierName = null;
		this.supplierPhone = null;
		this.supplierAddress = null;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierPhone() {
		return supplierPhone;
	}

	public void setSupplierPhone(String supplierPhone) {
		this.supplierPhone = supplierPhone;
	}

	public String getSupplierAddress() {
		return supplierAddress;
	}

	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}

	public int getSupplierNum() {
		return supplierNum;
	}

	public int getInventoryNum() {
		return inventoryNum;
	}

	public int getPurchaseNum() {
		return purchaseNum;
	}

	
	
}
