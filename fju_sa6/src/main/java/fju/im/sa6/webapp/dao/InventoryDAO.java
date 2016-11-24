package fju.im.sa6.webapp.dao;

import fju.im.sa6.entity.Inventory;

public interface InventoryDAO {
	public void add(Inventory addInv);

	public void set(Inventory setInv);

	public void remove(Inventory removeInv);

	public Inventory get(Inventory getInv);
}
