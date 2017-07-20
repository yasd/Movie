package com.tz.online.service;

import java.util.Map;

import com.tz.online.order.OrderItem;

public interface ICartService {

	void addCart(OrderItem item);

	// 清空购物车
	void clear();

	// 修改数量
	void modifyCount(Long bookId, int count);

	// 删除某个条目
	void delete(Long bookId);

	// 获取总价
	double getTotal();

	// 获取商品数量
	int getCount();
	
	//获取购物车数据
	Map<Long, OrderItem> getItems();
	
	//获取购物车的商品详情
	OrderItem find(Long bookId);
}
