package fju.im.sa6.webapp.dao;

import java.util.List;

import fju.im.sa6.entity.Purchase;

public interface PurchaseDAO {
	public void add(Purchase addPur);

	public void set(Purchase setPur);

	public void remove(Purchase removePur);

	public List<Purchase> getList();

	public Purchase get(Purchase getPur);
}
