package com.tz.online.dao;

import java.util.List;

import com.tz.online.entity.Book;
import com.tz.online.entity.Category;
import com.tz.online.entity.PageBean;

public interface IBookDao {

	
	PageBean<Book> queryByCondition(Integer now,int size,String cate);
	
	Book queryById(Long id);
	
	List<Category> getAllCategories();
	
	 
	public List<Book> findAll(String bookName,Category category,Long pageNow,Long pageSize);
	
	
	public long getRowCount(String bookName,Category category);
	
	public void deleteById(Long id);

}
