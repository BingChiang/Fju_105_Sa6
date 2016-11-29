package fju.im.sa6.dao;

import fju.im.sa6.entity.Product;

public interface ProductDAO {
	public void add(Product product);

	public void set(Product product);

	public void remove(Product product);

	public Product getProduct(Product product);
}
