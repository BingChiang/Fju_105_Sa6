package fju.im.sa6.entity;

import java.util.ArrayList;

public class SupplierList extends Supplier {
	
	private static ArrayList<Inventory> supplierList;


	
	//rebuild by bing 2016.11.30 ...and add init value
	public SupplierList(int supplierNum, int inventoryNum, int purchaseNum, String supplierName, String supplierPhone,
			String supplierAddress) {
		super(supplierNum, inventoryNum, purchaseNum, supplierName, supplierPhone, supplierAddress);
		this.supplierList = new ArrayList<Inventory>();
		// TODO Auto-generated constructor stub
	}
	
	public SupplierList(){
		super();
		this.supplierList = null;

	}


	public static ArrayList<Inventory> getSupplierList() {
		return supplierList;
	}


	public static void setSupplierList(ArrayList<Inventory> supplierList) {
		SupplierList.supplierList = supplierList;
	}

	

	
	
}
