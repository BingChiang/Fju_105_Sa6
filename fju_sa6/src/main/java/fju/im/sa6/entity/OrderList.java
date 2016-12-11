package fju.im.sa6.entity;

import java.sql.Date;
import java.util.ArrayList;

public class OrderList {

	private int orderlistNum;

	private ArrayList<Product> orderList;

	private int orderTotal;

	private Date orderDate;

	private String productName;

	private int productNum;

	private ArrayList<Orderitem> orderList_for_orderitem;

	private int productPrice;

	public OrderList(int orderlistNum, int orderTotal, Date orderDate) {
		this.orderlistNum = orderlistNum;
		this.orderTotal = orderTotal;
		this.orderDate = orderDate;
	}

	public ArrayList<Product> getOrderList() {

		return orderList;
	}

	public ArrayList<Orderitem> getOrderList_for_orderitem() {
		return orderList_for_orderitem;
	}

	public void setOrderList_for_orderitem(ArrayList<Orderitem> orderList_for_orderitem) {
		this.orderList_for_orderitem = orderList_for_orderitem;
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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
}