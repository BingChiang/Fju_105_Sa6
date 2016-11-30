package fju.im.sa6.dao;

import java.util.ArrayList;
import java.util.List;

import fju.im.sa6.entity.OrderList;
import fju.im.sa6.entity.Product;
import fju.im.sa6.entity.ProductList;

public interface OrderListDAO {
	public void add(OrderList orderList);

	public void set(OrderList orderList);

	public void remove(OrderList orderList);

	//for checking method , not for object type!!
	public double gettotalprice(OrderList orderList);
}
