package fju.im.sa6.entity;

import java.sql.Date;
import java.util.ArrayList;

public class OrderList {

	private int orderlistNum;

	private ArrayList<Product> orderList;

	private int orderTotal;

	private Date orderDate;

	private int productPrice;

	public OrderList(int orderlistNum, int orderTotal, Date orderDate,ArrayList<Product> orderList) {
		this.orderlistNum = orderlistNum;
		this.orderTotal = orderTotal;
		this.orderDate = orderDate;
		this.orderList =orderList;
	}

	public ArrayList<Product> getOrderList() {

		return orderList;
	}

	public int getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(int orderTotal) {
		this.orderTotal = orderTotal;
	}

	public int getOrderlistNum() {
		return orderlistNum;
	}

	public void setOrderlistNum(int orderistNum) {
		this.orderlistNum = orderistNum;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}


	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
}