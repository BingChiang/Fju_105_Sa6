package fju.im.sa6.entity;

public class Supplier {

	private int supplierNum;

	private String supplierName;

	private String supplierPhone;

	private String supplierAddress;
	
	private int availableNum;

	// rebuild by bing 2016.11.30 ...and add init value
	public Supplier(int supplierNum, String supplierName, String supplierPhone,
			String supplierAddress, int availableNum) {
		this.supplierNum = supplierNum;
		this.supplierName = supplierName;
		this.supplierPhone = supplierPhone;
		this.supplierAddress = supplierAddress;
		this.availableNum = availableNum;
	}

	public Supplier() {
		this.supplierNum = 0;
		this.supplierName = null;
		this.supplierPhone = null;
		this.supplierAddress = null;
		this.availableNum = 0;
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


	public int getavailableNum(){
		return availableNum;
	}
	public void setavailableNum(int availableNum){
		this.availableNum = availableNum;
	}
}
