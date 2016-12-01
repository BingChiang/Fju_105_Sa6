package fju.im.sa6.dao;

import fju.im.sa6.entity.Inventory;

public interface InventoryDAO {
	public void add(Inventory inventory);

	public void set(Inventory inventory);

	public void remove(Inventory inventory);

	public Inventory get(Inventory inventory);
}
