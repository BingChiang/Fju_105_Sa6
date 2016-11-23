package fju.im.sa6.webapp.dao;
import java.util.List;

import fju.im.sa6.entity.Product;

public interface ProductDAO {
	public void insert(Product aProduct);
	public void delete(Product aProduct);
	public void update(Product aProduct);
	public List<Product> getList();
	public List<Product> getReorderList();
	public List<Product> getAvailableList();
	public Product get(Product aProduct);
}
