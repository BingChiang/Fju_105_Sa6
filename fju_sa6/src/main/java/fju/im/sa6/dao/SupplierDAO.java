package fju.im.sa6.dao;

import java.util.ArrayList;
import java.util.List;

import fju.im.sa6.entity.Supplier;

public interface SupplierDAO {
	public void add(Supplier addSup);

	public void set(Supplier setSup);

	public void remove(Supplier removeSup);

	public ArrayList<Supplier> getList();

	public Supplier get(Supplier getSup);
}
