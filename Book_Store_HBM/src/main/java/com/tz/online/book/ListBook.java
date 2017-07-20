package com.tz.online.book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tz.online.entity.Book;
import com.tz.online.service.IBookService;
import com.tz.online.util.BeanFactory;
@WebServlet(urlPatterns="/list/book")
public class ListBook extends HttpServlet{

	private static final long serialVersionUID = 4668594748549673487L;
	private IBookService bookservice = (IBookService) BeanFactory.getBean("bookService");
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Long bookid =Long.valueOf(request.getParameter("bookid"));
		Book book = bookservice.findById(bookid);
		request.setAttribute("book",book);
				
		/*response.sendRedirect(request.getContextPath()+"/jsp/index.jsp");*/
	System.out.println("++++++++++++++++++sasas+++++++++++++"+book.getName());
	request.getRequestDispatcher("/jsp/book/details.jsp").forward(request, response);
	}

}
