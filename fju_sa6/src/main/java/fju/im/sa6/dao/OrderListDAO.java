package fju.im.sa6.dao;

import java.util.ArrayList;
import java.util.List;

import fju.im.sa6.entity.OrderList;
import fju.im.sa6.entity.Product;

public interface OrderListDAO {
	public void add(OrderList orderList);

	public void set(OrderList orderList);

	public void remove(OrderList orderList);

	public ArrayList<OrderList> getList();

	public Product getODP(Product product);

	public Product gettotalprice(OrderList orderList);
}
