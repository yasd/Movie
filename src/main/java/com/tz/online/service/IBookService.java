package com.tz.online.service;

import java.util.List;

import com.tz.online.entity.Book;
import com.tz.online.entity.Category;
import com.tz.online.entity.PageBean;

public interface IBookService  {

	//根据商品的类别，分页查询商品
	public List<Book> selectByCondition(Integer now,int size,String cate);
	
	//根据商品的ID，查询商品的对象
	public Book findById(Long id);
	
	/*
	 * 统计图的总数量
	 * @param cate 分类，如果参数为null，则查询所有记录的数量，否则查询出满足条件的记录数
	 * */
	
	public int rowCount(String cate);

	public List<Book> findAll(String bookName,Category category,Long pageNow,Long pageSize);
	
	public List<Category> findAll();
	
	public PageBean<Book> findByPage(String bookName,Category category,Long pageNow,Long pageSize);
	
	public void deleteById(Long id);
}
