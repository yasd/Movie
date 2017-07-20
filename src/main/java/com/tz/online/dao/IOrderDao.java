package com.tz.online.dao;

import com.tz.online.order.Order;

public interface IOrderDao {

	/**
	 * 保存一条购物记录订单
	 */
	public void save(Order order);
	
	/**
	 * 通过购物ID删除购物订单
	 */
	public void deleteById(Long id);
	
	/**
	 * 通过用户ID来查询订单
	 */
	public Order getByUserId(Long userid);
	
	/**
	 * 通过orderID来查询订单
	 */
	public Order getById(Long oid);
}
