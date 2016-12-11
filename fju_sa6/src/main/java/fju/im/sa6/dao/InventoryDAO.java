package fju.im.sa6.dao;

import java.util.ArrayList;
import fju.im.sa6.entity.Inventory;
import fju.im.sa6.entity.Supplier;

public interface InventoryDAO {
	public void add(Inventory inventory);

	public void set(Inventory inventory);

	public void remove(Inventory inventory);

	public Inventory get(Inventory inventory);

	public ArrayList<Inventory> getList();

	public ArrayList<Inventory> getList(Supplier supplier);
}
