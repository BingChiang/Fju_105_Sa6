package fju.im.sa6.entity;

import java.sql.Date;
import java.util.ArrayList;

public class OrderList  {

	private int orderlistNum;
	private ArrayList<Product> orderList ;
	
	private int orderTotal;

	private Date orderDate;

	public OrderList(int orderlistNum, int orderTotal, Date orderDate, ArrayList<Product> orderList) {
		this.orderlistNum = orderlistNum;
		this.orderTotal =orderTotal;
		this.orderDate = orderDate;
		this.orderList =  new ArrayList<Product>();
	
	}

	public OrderList() {
		super();
		this.orderlistNum = 0;
		this.orderTotal = 0;
		this.orderDate = null;
		orderList = new ArrayList<Product>();
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
