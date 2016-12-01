package fju.im.sa6.dao;

import fju.im.sa6.entity.OrderList;

public interface OrderListDAO {
	public void add(OrderList orderList);

	public void set(OrderList orderList);

	public void remove(OrderList orderList);

	// for checking method , not for object type!!
	public double gettotalprice(OrderList orderList);
}
