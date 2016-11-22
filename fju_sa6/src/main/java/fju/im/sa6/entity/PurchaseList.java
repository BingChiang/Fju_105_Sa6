import java.util.ArrayList;
import java.util.Date;

public class PurchaseList extends Purchase {

	private ArrayList<Inventory> purchaseList;

	public PurchaseList(int inventoryNum, int purchaseNum, int inventoryAmount, int supplierNum, String purchaseName,
			int purchaseNum2, double purchasePrice, Date purchaseDate, ArrayList<Inventory> purchaseList) {
		super(inventoryNum, purchaseNum, inventoryAmount, supplierNum, purchaseName, purchaseNum2, purchasePrice,
				purchaseDate);
		this.purchaseList = purchaseList;
	}

	public ArrayList<Inventory> getPurchaseList() {
		return purchaseList;
	}

	public void setPurchaseList(ArrayList<Inventory> purchaseList) {
		this.purchaseList = purchaseList;
	}
	

}
