package fju.im.sa6.entity;

public class Supplier {

	private int supplierNum;

	private int inventoryNum;

	private String inventoryName;

	private String supplierName;

	private String supplierPhone;

	private String supplierAddress;

	// rebuild by bing 2016.11.30 ...and add init value
	public Supplier(int supplierNum, int inventoryNum, String inventoryName, String supplierName, String supplierPhone,
			String supplierAddress) {
		this.supplierNum = supplierNum;
		this.inventoryNum = inventoryNum;
		this.inventoryName = inventoryName;
		this.supplierName = supplierName;
		this.supplierPhone = supplierPhone;
		this.supplierAddress = supplierAddress;
	}

	public Supplier() {
		this.supplierNum = 0;
		this.inventoryNum = 0;
		this.inventoryName = null;
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

	public String getinventoryName() {
		return inventoryName;
	}

}
