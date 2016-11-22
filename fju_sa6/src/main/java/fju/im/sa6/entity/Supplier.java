package fju.im.sa6.entity;

public class Supplier {

	private int supplierNum;

	private int inventoryNum;

	private int purchaseNum;

	private String supplierName;

	private int supplierPhone;

	private String supplierAddress;

	public Supplier(int supplierNum, int inventoryNum, int purchaseNum, String supplierName, int supplierPhone,
			String supplierAddress) {
		this.supplierNum = supplierNum;
		this.inventoryNum = inventoryNum;
		this.purchaseNum = purchaseNum;
		this.supplierName = supplierName;
		this.supplierPhone = supplierPhone;
		this.supplierAddress = supplierAddress;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public int getSupplierPhone() {
		return supplierPhone;
	}

	public void setSupplierPhone(int supplierPhone) {
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
