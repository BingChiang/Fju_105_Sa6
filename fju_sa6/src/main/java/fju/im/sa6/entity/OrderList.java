package fju.im.sa6.entity;

import java.util.ArrayList;
import java.util.Date;

public class OrderList extends OrderDefault {

	private ArrayList<ProductList> orderList;

	public OrderList(int order_Num, int product_Num, int type_Num, int order_Price, int order_Amount, int order_Total,
			Date order_Date, ArrayList<ProductList> orderList) {
		super(order_Num, product_Num, type_Num, order_Price, order_Amount, order_Total, order_Date);

		this.orderList = orderList;
	}

	public OrderList(ArrayList<ProductList> orderList) {
		super();

		this.orderList = orderList;
	}

	public OrderList() {
		super();
		this.orderList = orderList;
	}

	public ArrayList<ProductList> getOrderList() {
		return orderList;
	}

	public void setOrderList(ArrayList<ProductList> orderList) {
		this.orderList = orderList;
	}

}
