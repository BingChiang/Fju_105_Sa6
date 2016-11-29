package fju.im.sa6.webapp.dao;

import fju.im.sa6.entity.OrderDefault;

public interface OrderDefaultDAO {
	public void add(OrderDefault addOrder);

	public void set(OrderDefault setOrder);

	public void remove(OrderDefault removeOrder);

	public OrderDefault get(int searchNum);
}
