package fju.im.sa6.entity;

import java.sql.Date;
import fju.im.sa6.entity.Product;

public class OrderList extends OrderDefault {

	private int orderlistNum;

	private int orderTotal;

	private Date orderDate;

	public OrderList(int orderlistNum, int orderTotal, Date orderDate) {

	}

	public OrderList() {
		this.orderlistNum = 0;
		this.orderTotal = 0;
		this.orderDate = null;
	}

	public int getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(int orderTotal) {
		this.orderTotal = orderTotal;
	}

	public int getOrderistNum() {
		return orderlistNum;
	}

	public void setOrderistNum(int orderistNum) {
		this.orderlistNum = orderistNum;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

}
