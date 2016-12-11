package fju.im.sa6.dao;

import java.sql.Date;
import java.util.ArrayList;

import fju.im.sa6.entity.Cart;
import fju.im.sa6.entity.OrderList;
import fju.im.sa6.entity.Orderitem;
import fju.im.sa6.entity.Product;

public interface OrderListDAO {
	public void addorderlist(OrderList orderlist);
	
	public void addorderitem(Orderitem orderitem);

	public OrderList getorderlist(OrderList orderlist);
	
	public ArrayList<Orderitem> getorderitem(Orderitem orderitem);
	
	public ArrayList<OrderList> getList();
	
	public int getordertotal(OrderList orderlist);
	
	public double gettotalcost(Date date);

}