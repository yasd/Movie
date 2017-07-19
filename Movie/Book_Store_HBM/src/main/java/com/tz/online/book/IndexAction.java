package com.tz.online.book;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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

@WebServlet(urlPatterns="/book/index")
public class IndexAction  extends HttpServlet{

	private static final long serialVersionUID = 5055973860077975673L;
	
	private IBookService bookservice =(IBookService) BeanFactory.getBean("bookService");
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("===============进入BOOK index================");
		
		Category category = null;
		String bookName=request.getParameter("bookName");
		String category1=request.getParameter("category");
		if (null!=category1) {
			category=Category.valueOf(category1);
		}
		String pageNow=request.getParameter("pageNow");
		if(pageNow==null){
			pageNow="1";//默认从第一页开始
		}
		String pageSize=request.getParameter("pageSize");
		if(null==pageSize){
			pageSize="4";
		}
		//获取图书的类型信息
				List<Category> categories =bookservice.findAll();
				
				PageBean<Book> book = bookservice.findByPage(bookName,category.精选图书,Long.valueOf(pageNow) ,Long.valueOf(pageSize));
				//放入到request作用域中
				PageBean<Book> book1 = bookservice.findByPage(bookName, category.推荐图书,Long.valueOf(pageNow) ,Long.valueOf(pageSize));
				PageBean<Book> book2 = bookservice.findByPage(bookName, category.特价图书,Long.valueOf(pageNow) ,Long.valueOf(pageSize));
				request.setAttribute("book", book);
				request.setAttribute("book1", book1);
				request.setAttribute("book2", book2);

				request.setAttribute("categories", categories);
				
				//将刚刚查询的添加放入到作用域中
				request.setAttribute("bookName", bookName==null?"":bookName);
				
				request.setAttribute("category", category==null?"":category);
				request.setAttribute("category", category==null||"-1".equals(category)?"-1":category);
				
				
				System.out.println("===============出来BOOK index================");
		
		/*response.sendRedirect(request.getContextPath()+"/jsp/index.jsp");*/
	request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
	}

}
