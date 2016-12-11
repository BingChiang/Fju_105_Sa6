package fju.im.sa6.dao;

import java.sql.Date;
import java.util.ArrayList;

import fju.im.sa6.entity.Cart;
import fju.im.sa6.entity.OrderList;
import fju.im.sa6.entity.Orderitem;
import fju.im.sa6.entity.Product;

public interface OrderListDAO {
	public void addorderlist(OrderList orderlist);
	

	public ArrayList<OrderList> getorderlist();
	
	public ArrayList<Orderitem> getorderitem(OrderList orderList);
	
	
	public int getordertotal(OrderList orderlist);
	
	public double gettotalcost(Date date);


}