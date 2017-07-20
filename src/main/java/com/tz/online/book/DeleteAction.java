package com.tz.online.book;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tz.online.dao.IOrderItemDao;
import com.tz.online.service.IBookService;
import com.tz.online.service.ICartService;
import com.tz.online.service.IUserService;
import com.tz.online.util.BeanFactory;
@WebServlet(urlPatterns="/book/delete")
public class DeleteAction extends HttpServlet{

	private static final long serialVersionUID = 1248245204782461177L;
	private IBookService bookservice =(IBookService) BeanFactory.getBean("bookService");
	private IOrderItemDao itd = (IOrderItemDao) BeanFactory.getBean("orderItemDao");
	private ICartService cartService = (ICartService) BeanFactory.getBean("cartService");
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out =resp.getWriter();
		
		String uids=req.getParameter("uids");
		
		for (String id : uids.split("\\:")) {
			itd.deleteById(Long.valueOf(id));
		}
		out.print("ok");
	}

}
