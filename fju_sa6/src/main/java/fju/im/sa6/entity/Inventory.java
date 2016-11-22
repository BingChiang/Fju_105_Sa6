public class Inventory {

	private int inventoryNum;

	private int purchaseNum;

	private int inventoryAmount;

	private int supplierNum;

	public Inventory(int inventoryNum, int purchaseNum, int inventoryAmount, int supplierNum) {
		this.inventoryNum = inventoryNum;
		this.purchaseNum = purchaseNum;
		this.inventoryAmount = inventoryAmount;
		this.supplierNum = supplierNum;
	}

	public int getInventoryNum() {
		return inventoryNum;
	}

	public void setInventoryNum(int inventoryNum) {
		this.inventoryNum = inventoryNum;
	}

	public int getPurchaseNum() {
		return purchaseNum;
	}

	public void setPurchaseNum(int purchaseNum) {
		this.purchaseNum = purchaseNum;
	}

	public int getInventoryAmount() {
		return inventoryAmount;
	}

	public void setInventoryAmount(int inventoryAmount) {
		this.inventoryAmount = inventoryAmount;
	}

	public int getSupplierNum() {
		return supplierNum;
	}

	public void setSupplierNum(int supplierNum) {
		this.supplierNum = supplierNum;
	}

	

}
