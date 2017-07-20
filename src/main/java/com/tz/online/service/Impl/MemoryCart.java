package com.tz.online.service.Impl;

import java.util.HashMap;
import java.util.Map;

import com.tz.online.dao.IOrderItemDao;
import com.tz.online.order.OrderItem;
import com.tz.online.service.ICartService;
import com.tz.online.util.BeanFactory;

public class MemoryCart implements ICartService{
private IOrderItemDao orderitemdao =(IOrderItemDao) BeanFactory.getBean("orderItemDao");

	
	
	@Override
	public void addCart(OrderItem item) {
		orderitemdao.save(item);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyCount(Long bookId, int count) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long bookId) {
		orderitemdao.deleteById(bookId);
	}

	@Override
	public double getTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<Long, OrderItem> getItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderItem find(Long bookId) {
		// TODO Auto-generated method stub
		return null;
	}

}
