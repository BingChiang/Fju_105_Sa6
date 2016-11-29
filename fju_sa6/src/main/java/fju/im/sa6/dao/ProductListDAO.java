package fju.im.sa6.dao;

import fju.im.sa6.entity.Product;
import fju.im.sa6.entity.ProductList;

public interface ProductListDAO {
	public void set(ProductList setPurlist);

	public void remove(ProductList removePurlist);

	public Product get(ProductList getPurlist);

	public double getSingleTotal(ProductList gettotal);
}
