package fju.im.sa6.webapp.dao;

import java.util.ArrayList;
import java.util.Date;

import fju.im.sa6.entity.OrderList;
import fju.im.sa6.entity.Product;
import fju.im.sa6.entity.ProductList;

public interface OrderListDAO {
	public void add(OrderList addODP);

	public void set(OrderList setODP);

	public void remove(OrderList removeODP);

	public Product gettotalprice(Product gettotalprice);

	public ArrayList<ProductList> getOrderList(java.sql.Date searchDate);
}
