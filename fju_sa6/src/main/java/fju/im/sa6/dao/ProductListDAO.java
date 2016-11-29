package fju.im.sa6.dao;

import fju.im.sa6.entity.Product;
import fju.im.sa6.entity.ProductList;

public interface ProductListDAO {
	public void set(ProductList productList);

	public void remove(ProductList productList);

	public Product get(ProductList productList);

	public double getSingleTotal(ProductList productList);
}
