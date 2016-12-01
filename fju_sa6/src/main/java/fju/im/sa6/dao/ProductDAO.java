package fju.im.sa6.dao;

import java.util.ArrayList;

import fju.im.sa6.entity.Product;
import fju.im.sa6.entity.Type;

public interface ProductDAO {
	public void add(Product product);

	public void set(Product product);

	public void remove(Product product);

	public Product get(Product product);
	
	public ArrayList<Product> getTypeList(Type type);
	
	public ArrayList<Product> getList();
	
}
