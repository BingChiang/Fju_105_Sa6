package fju.im.sa6.dao;

import java.util.ArrayList;
import java.util.List;

import fju.im.sa6.entity.Purchase;

public interface PurchaseDAO {
	public void add(Purchase purchase);

	public void set(Purchase purchase);

	public void remove(Purchase purchase);

	public ArrayList<Purchase> getList();

	public Purchase get(Purchase purchase);
}
