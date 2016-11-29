package fju.im.sa6.entity;

import java.util.ArrayList;
import java.util.Date;

public class PurchaseList extends Purchase {

	private ArrayList<Inventory> purchaseList;

<<<<<<< HEAD
	public PurchaseList( String purchaseName,
			int purchaseNum, double purchasePrice, Date purchaseDate) {
		super(purchaseName, purchaseNum, purchasePrice,
				purchaseDate);
=======
	public PurchaseList(int inventoryNum, int purchaseNum, int inventoryAmount, int supplierNum, String inventoryName,
			String purchaseName, int purchaseNum2, double purchasePrice, Date purchaseDate,
			ArrayList<Inventory> purchaseList) {
		super(inventoryNum, purchaseNum, inventoryAmount, supplierNum, inventoryName, purchaseName, purchaseNum2,
				purchasePrice, purchaseDate);

>>>>>>> refs/remotes/origin/Cheyu
		this.purchaseList = purchaseList;
	}

	public ArrayList<Inventory> getPurchaseList() {
		return purchaseList;
	}

	public void setPurchaseList(ArrayList<Inventory> purchaseList) {
		this.purchaseList = purchaseList;
	}

}
