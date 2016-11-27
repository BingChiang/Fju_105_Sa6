package fju.im.sa6.webapp.dao;

import fju.im.sa6.entity.Product;

public interface ProductDAO {
	public void add(Product addPro);

	public void set(Product setPro);

	public void remove(Product removePro);

	public Product get(Product getPro);

	Product getProduct(int searchNum);
}
