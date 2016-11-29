package fju.im.sa6.dao;

import fju.im.sa6.entity.OrderDefault;

public interface OrderDefaultDAO {
	public void add(OrderDefault orderDefault);

	public void set(OrderDefault orderDefault);

	public void remove(OrderDefault orderDefault);

	public OrderDefault get(OrderDefault orderDefault);
}
