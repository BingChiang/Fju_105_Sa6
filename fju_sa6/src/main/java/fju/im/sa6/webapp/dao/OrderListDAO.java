package fju.im.sa6.webapp.dao;

import java.util.ArrayList;
import java.util.List;

import fju.im.sa6.entity.OrderList;
import fju.im.sa6.entity.Product;

public interface OrderListDAO {
	public void add(OrderList addODP);

	public void set(OrderList setODP);

	public void remove(OrderList removeODP);

	public ArrayList<OrderList> getList();

	public Product getODP(int serachNum);

	public Product gettotalprice(OrderList gettotalprice);
}
