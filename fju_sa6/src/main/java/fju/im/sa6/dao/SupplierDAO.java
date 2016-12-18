package fju.im.sa6.dao;

import java.util.ArrayList;
import fju.im.sa6.entity.SupplierList;
import fju.im.sa6.entity.Supplier;

public interface SupplierDAO {
	public void add(Supplier supplier);

	public void set(Supplier supplier);

	public void remove(Supplier supplier);

	public ArrayList<Supplier> getList();

	public Supplier get(Supplier supplier);
}
