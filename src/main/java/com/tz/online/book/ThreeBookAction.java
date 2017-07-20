package com.tz.online.book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tz.online.entity.Book;
import com.tz.online.entity.Category;
import com.tz.online.entity.PageBean;
import com.tz.online.service.IBookService;
import com.tz.online.util.BeanFactory;

@WebServlet(urlPatterns="/book/three")
public class ThreeBookAction extends HttpServlet{

	private static final long serialVersionUID = 7210611912447028652L;
	private IBookService bookService = (IBookService) BeanFactory.getBean("bookService");

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
Category category = null;
		
		String cate = req.getParameter("category");
		
		category = Category.valueOf(cate);
		
		String pageNow = req.getParameter("pageNow");
		
		if(pageNow==null){
			pageNow="1";//默认从第一页开始
		}
		
		String pageSize = req.getParameter("pageSize");
		
		if(null==pageSize){
			pageSize="8";
		}
		
		String bookName = req.getParameter("bookName");
		
		PageBean<Book> pages = bookService.findByPage(bookName, category, Long.valueOf(pageNow), Long.valueOf(pageSize));
		
		req.setAttribute("pages", pages);
		
		req.setAttribute("category", cate);
		
		req.getRequestDispatcher("/jsp/book/three.jsp").forward(req, resp);
		
		}
	}

