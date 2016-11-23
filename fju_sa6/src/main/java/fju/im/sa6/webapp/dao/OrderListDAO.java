package fju.im.sa6.webapp.dao;

import java.util.List;

import fju.im.sa6.entity.OrderList;
import fju.im.sa6.entity.Product;

public interface OrderListDAO {
	public void add(OrderList addODP);

	public void set(OrderList setODP);

	public void remove(OrderList removeODP);

	public List<OrderList> getList();

	public Product getODP(OrderList getODP);

	public Product gettotalprice(OrderList gettotalprice);
}
