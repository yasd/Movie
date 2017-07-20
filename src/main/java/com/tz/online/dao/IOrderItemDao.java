package com.tz.online.dao;

import com.tz.online.order.OrderItem;

public interface IOrderItemDao {

	
	public void save(OrderItem item);
	
	public void deleteById(Long id);	
}
