package com.tz.online.BookTest;

import java.util.List;

import org.junit.Test;

import com.tz.online.dao.IBookDao;
import com.tz.online.entity.Book;
import com.tz.online.entity.Category;
import com.tz.online.service.IBookService;
import com.tz.online.util.BeanFactory;

public class BookTest {
	
	private IBookDao bookdao =(IBookDao) BeanFactory.getBean("bookDao");
	private IBookService bookService =(IBookService) BeanFactory.getBean("bookService");
	
	@Test
	public void queryByConditionTest(){
		
		
	}
	@Test
	public void queryById(){
		Book book1 =bookdao.queryById(3L);
		System.out.println(book1);
		
		
	}
	@Test
	public void getAllCategories(){
		
		
	}
	@Test
	public void findAll(){
		List<Book> books =bookdao.findAll(null, null, 1L, 4L);
		for (Book book : books) {
			System.out.println(book);
		}
	}
	@Test
	public void getRowCount(){
		System.out.println(bookdao.getRowCount(null,null));
		
	}
	
	@Test
	public void findAaaaa(){
		System.out.println(bookService.findAll("北",null,1L, 5L));
	}
}
