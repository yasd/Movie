package com.tz.online.BookTest;

import java.util.List;

import org.junit.Test;

import com.tz.online.dao.IBookDao;
import com.tz.online.dao.IOrderItemDao;
import com.tz.online.entity.Book;
import com.tz.online.entity.PageBean;
import com.tz.online.order.Order;
import com.tz.online.order.OrderItem;
import com.tz.online.service.IBookService;
import com.tz.online.service.ICartService;
import com.tz.online.service.IOrderService;
import com.tz.online.util.BeanFactory;

public class BookTest {
	private IOrderItemDao orderitemdao =(IOrderItemDao) BeanFactory.getBean("orderItemDao");
	private ICartService iCartService = (ICartService) BeanFactory.getBean("cartService");
	private IBookDao bookdao =(IBookDao) BeanFactory.getBean("bookDao");
	private IBookService bookService =(IBookService) BeanFactory.getBean("bookService");
	private ICartService cartService = (ICartService) BeanFactory.getBean("cartService");
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
		System.out.println(bookdao.findAll("北",null,1L, 5L));
	}
	
	
	@Test
	public void findAlls(){
		PageBean<Book> pages = bookService.findByPage(null, null, 1L, 5L);
		System.out.println("取到的数据长度:"+pages.getList().size());
		for (Book b : pages.getList()) {
			System.out.println(b);
		}
	}
}
