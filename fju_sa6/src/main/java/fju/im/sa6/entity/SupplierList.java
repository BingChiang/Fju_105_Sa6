package fju.im.sa6.entity;

import java.util.ArrayList;

public class SupplierList extends Supplier {

	private static ArrayList<Inventory> supplierList;

	// rebuild by bing 2016.11.30 ...and add init value
	public SupplierList(int supplierNum, int inventoryNum, String inventoryName, String supplierName,
			String supplierPhone, String supplierAddress) {
		super(supplierNum, inventoryNum, inventoryName, supplierName, supplierPhone, supplierAddress);
		SupplierList.supplierList = new ArrayList<Inventory>();
		// TODO Auto-generated constructor stub
	}

	public SupplierList() {
		super();
		SupplierList.supplierList = null;

	}

	public static ArrayList<Inventory> getSupplierList() {
		return supplierList;
	}

	public static void setSupplierList(ArrayList<Inventory> supplierList) {
		SupplierList.supplierList = supplierList;
	}

}
