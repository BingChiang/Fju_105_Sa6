package fju.im.sa6.dao;

import java.util.List;

import fju.im.sa6.entity.OrderList;
import fju.im.sa6.entity.Product;

public interface OrderListDAO {
	public void add(OrderList orderList);

	public void remove(OrderList removeorderlist);

	public OrderList getordertotal(OrderList orderList, OrderList order);
	
	public List<Product> addcart(Product product);
	
}
