package fju.im.sa6.dao;

import java.util.ArrayList;

import fju.im.sa6.entity.Cart;
import fju.im.sa6.entity.OrderList;
import fju.im.sa6.entity.Product;

public interface OrderListDAO {
	public void add(Cart cart);

	public OrderList get( );
	
	public ArrayList<OrderList> getList();
	public ArrayList<Product> getOrderDetail(OrderList orderList);
}
