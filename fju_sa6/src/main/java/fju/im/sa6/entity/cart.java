package fju.im.sa6.entity;

import java.util.ArrayList;
import java.util.List;

public class cart {
	
	private List<Product> productList = new ArrayList<Product>();
	
	public List<Product> getCart(){
		return productList;
	}
	
	public void addproduct(Product product){
		productList.add(product);
	}

	public int orderTotal(){
		int total = 0 ;
		for (int i = 0 ; i < productList.size(); i++ ){
			total += productList.get(i).getProductPrice();
		}
		return total;
	}
	
	public void clean(){
		productList = new ArrayList<Product>();
	}

}
