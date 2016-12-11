package fju.im.sa6.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;


//configuration for session, please refer to: http://tuhrig.de/making-a-spring-bean-session-scoped/
@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class Cart implements java.io.Serializable {
	
	/**
	 * serialVersionUID is generated automatically
	 */
	private static final long serialVersionUID = 3476619468809859762L;
	//private List<Long> productList = new ArrayList<Long>();

	
	private ArrayList<Product> productList = new ArrayList<Product>();
	
	public ArrayList<Product> getProductList() {
		return productList;
	}

	public void setProductList(ArrayList<Product> productList) {
		this.productList = productList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ArrayList<Product> getCart(){
		return productList;
	}
	
	public void add(Product product){
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
