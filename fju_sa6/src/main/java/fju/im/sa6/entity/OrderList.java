import java.util.ArrayList;
import java.util.Date;

public class OrderList extends OrderDefault {
	
	private ArrayList<ProductList> orderList;

	public OrderList(int orderNum, int productNum, int typeNum, int orderPrice, int orderAmount, int orderTotal,
			Date orderDate, ArrayList<ProductList> orderList) {
		super(orderNum, productNum, typeNum, orderPrice, orderAmount, orderTotal, orderDate);
		this.orderList = orderList;
	}

	public ArrayList<ProductList> getOrderList() {
		return orderList;
	}

	public void setOrderList(ArrayList<ProductList> orderList) {
		this.orderList = orderList;
	}

}
