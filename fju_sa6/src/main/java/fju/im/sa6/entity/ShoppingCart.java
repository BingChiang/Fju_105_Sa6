package fju.im.sa6.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCart implements java.io.Serializable {

	/**
	 * serialVersionUID is generated automatically
	 */
	private static final long serialVersionUID = 3476619468809859762L;
	// private List<Long> productList = new ArrayList<Long>();
	private List<ProductList> productList = new ArrayList<ProductList>();

	public List<ProductList> getCart() {
		return productList;
	}

	public void add(Product product, int amount) {
		productList.add(new ProductList(product.getProductNum(),amount));
	}

	public int count() {
		return productList.size();
	}

	public void cleanup() {
		productList = new ArrayList<ProductList>();
	}

}
