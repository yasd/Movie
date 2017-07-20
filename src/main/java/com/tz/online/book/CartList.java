package com.tz.online.book;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tz.online.entity.Book;
import com.tz.online.order.OrderItem;
import com.tz.online.service.IBookService;
import com.tz.online.util.BeanFactory;
@WebServlet(urlPatterns="/cart/list")
public class CartList extends HttpServlet{

	private static final long serialVersionUID = -424711950746360298L;
	private IBookService bookService = (IBookService) BeanFactory.getBean("bookService");
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<OrderItem> ots = new ArrayList<>();
		
		@SuppressWarnings("unchecked")
		Map<Long,OrderItem> cart = (Map<Long, OrderItem>) req.getSession().getAttribute("cart");
		List<Book> book  = new ArrayList<>();
		if (null!=cart) {
			Set<Long> set=cart.keySet();
			for (Long l : set) {
				ots.add(cart.get(l));
			}
			req.setAttribute("ots", ots);
		}
		req.getRequestDispatcher("/jsp/cart/listcart.jsp").forward(req, resp);
	}

}
