package fju.im.sa6.entity;

import java.util.Date;

public class OrderDefault {

	private int orderNum;

	private int productNum;

	private int typeNum;

	private int orderPrice;

	private int orderAmount;

	private int orderTotal;

	private Date orderDate;

	//2016.11.30 by bing ...and add init value
	public OrderDefault(int orderNum, int productNum, int typeNum, int orderPrice, int orderAmount, int orderTotal,
			Date orderDate) {
		this.orderNum = orderNum;
		this.productNum = productNum;
		this.typeNum = typeNum;
		this.orderPrice = orderPrice;
		this.orderAmount = orderAmount;
		this.orderTotal = orderTotal;
		this.orderDate = orderDate;
	}

	public OrderDefault() {
		this.orderNum = 0;
		this.productNum = 0;
		this.typeNum = 0;
		this.orderPrice = 0;
		this.orderAmount = 0;
		this.orderTotal = 0;
		this.orderDate = null;
	}

	public int getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}

	public int getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}

	public int getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(int orderTotal) {
		this.orderTotal = orderTotal;
	}

	public java.sql.Date getOrderDate() {
		return (java.sql.Date) orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public int getProductNum() {
		return productNum;
	}

	public int getTypeNum() {
		return typeNum;
	}

}
