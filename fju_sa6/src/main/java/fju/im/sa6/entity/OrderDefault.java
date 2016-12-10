package fju.im.sa6.entity;

import fju.im.sa6.entity.OrderList;

public class OrderDefault extends OrderList {

	// private ArrayList<Product> product;

	public OrderDefault(int orderlistNum, int productNum, String productName, int productPrice) {
		super(orderlistNum, orderTotal, orderDate);

	}

	public OrderDefault() {
		this.productNum = 0;
		this.orderlistNum = 0;
		this.productName = null;
		this.productPrice = 0;
	}

}
