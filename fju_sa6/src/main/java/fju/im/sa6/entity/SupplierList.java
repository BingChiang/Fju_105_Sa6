import java.util.ArrayList;

public class SupplierList extends Supplier {
	
	private static ArrayList<Inventory> supplierList;


	public SupplierList(int supplierNum, int inventoryNum, int purchaseNum, String supplierName, int supplierPhone,
			String supplierAddress) {
		super(supplierNum, inventoryNum, purchaseNum, supplierName, supplierPhone, supplierAddress);
		this.supplierList = new ArrayList<Inventory>();
		// TODO Auto-generated constructor stub
	}


	public static ArrayList<Inventory> getSupplierList() {
		return supplierList;
	}


	public static void setSupplierList(ArrayList<Inventory> supplierList) {
		SupplierList.supplierList = supplierList;
	}

	

	
	
}
