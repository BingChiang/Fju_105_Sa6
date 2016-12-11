package fju.im.sa6.entity;

import java.sql.Date;
import java.util.ArrayList;

public class Orderitem {
	
	private int orderlistNum;

	private String productName;
	
	private int productNum;
	
	private int productPrice;
	
	
	public Orderitem(int productNum, int orderlistNum, String productName, int productPrice){
		this.productNum = productNum;
		this.orderlistNum = orderlistNum;
		this.productName = productName;
		this.productPrice = productPrice;
	}
	
	public int orderTotal(){
		int total = 0 ;
		ArrayList<Orderitem> orderitem  = new ArrayList<Orderitem>();
		for (int i = 0 ; i < orderitem.size(); i++ ){
			total += orderitem.get(i).getProductPrice();
		}
		return total;
	}
	
	

	public void setOrderlistNum(int orderlistNum) {
		this.orderlistNum = orderlistNum;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductNum() {
		return productNum;
	}

	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	
}