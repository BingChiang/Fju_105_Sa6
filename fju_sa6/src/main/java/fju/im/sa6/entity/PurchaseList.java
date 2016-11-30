package fju.im.sa6.entity;

import java.util.ArrayList;
import java.util.Date;

public class PurchaseList extends Purchase {

	private ArrayList<Inventory> purchaseList;

	public PurchaseList(String purchaseName, int purchaseNum, double purchasePrice, Date purchaseDate) {
		super(purchaseName, purchaseNum, purchasePrice, purchaseDate);
		this.purchaseList = purchaseList;
	}

	public PurchaseList() {
		super();
		this.purchaseList = null;

	}

	public ArrayList<Inventory> getPurchaseList() {
		return purchaseList;
	}

	public void setPurchaseList(ArrayList<Inventory> purchaseList) {
		this.purchaseList = purchaseList;
	}

}
