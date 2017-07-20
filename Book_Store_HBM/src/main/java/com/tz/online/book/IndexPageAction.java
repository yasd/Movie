package com.tz.online.book;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.tz.online.entity.Book;
import com.tz.online.entity.PageBean;
import com.tz.online.service.IBookService;
import com.tz.online.util.BeanFactory;
@WebServlet(urlPatterns="/book/page")
public class IndexPageAction  extends HttpServlet{

	private static final long serialVersionUID = 2711518332277862970L;

	private IBookService bookservice = (IBookService) BeanFactory.getBean("bookService");
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				/*String bookName = request.getParameter("bookName");*/
			
				//设置文档编码
				response.setContentType("text/json;charset=utf-8");
				
				PrintWriter out = response.getWriter();
				
				String pageNow = request.getParameter("pageNow");
				
				if(null==pageNow || pageNow.trim().length()==0){
					pageNow="1";
				}
				
				PageBean<Book> pageBeans = bookservice.findByPage(null,null, Long.valueOf(pageNow), 4L);
		
				/*request.setAttribute("bookName", bookName==null?"":bookName);*/
				List<Book> books = pageBeans.getList();
				request.setAttribute("pageBeans", pageBeans);
				request.setAttribute("books", books);
				String arr = JSON.toJSONString(books);
				out.print(arr);
				/*request.getRequestDispatcher("/jsp/book/Nav.jsp").forward(request, response);*/
	}
}
