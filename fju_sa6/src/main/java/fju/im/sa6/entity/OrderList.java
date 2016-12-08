package fju.im.sa6.entity;

import java.util.ArrayList;
import java.util.Date;

public class OrderList extends OrderDefault {

	private ArrayList<ProductList> orderList;

	public OrderList(int orderlist_Num, int product_Num, int type_Num,int order_Total,
			Date order_Date) {
		super(orderlist_Num, product_Num, type_Num, Product_Price, order_Amount, String productName);

	}

	public OrderList(ArrayList<ProductList> orderList) {
		super();

		this.orderList = orderList;
	}

	public OrderList() {
		super();
	}

	public ArrayList<ProductList> getOrderList() {
		return orderList;
	}

	public void setOrderList(ArrayList<ProductList> orderList) {
		this.orderList = orderList;
	}

}
