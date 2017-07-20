package com.tz.online.book;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tz.online.entity.Book;
import com.tz.online.entity.Category;
import com.tz.online.service.IBookService;
import com.tz.online.util.BeanFactory;
@WebServlet(urlPatterns="/book/select")
public class IndexSelectAction extends HttpServlet{

	
	private static final long serialVersionUID = 6876792693458651009L;
	private IBookService bookService  =(IBookService) BeanFactory.getBean("bookService");
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Category category = null;
		String bookName = req.getParameter("bookName");
		String category1=req.getParameter("category");
		if (null!=category1) {
			category=Category.valueOf(category1);
		}
		List<Category> categories =bookService.findAll();
		String pageNow =req.getParameter("pageNow");

		if(pageNow==null){
			pageNow="1";//默认从第一页开始
		}
		
		String pageSize =req.getParameter("pageSize");
		if(null==pageSize){
			pageSize="4";
		}
		List<Book> book =bookService.findAll(bookName, category, Long.valueOf(pageNow), Long.valueOf(pageSize));
		System.out.println("++++++++++"+book);
		System.out.println("++++++++++"+bookName);
		req.setAttribute("categories",categories);
		req.setAttribute("book",book);
		req.setAttribute("category", category==null?"":category);
		req.setAttribute("bookName",bookName==null?"":bookName);
		req.getRequestDispatcher("/jsp/book/books_list.jsp").forward(req, resp);
	}

}
