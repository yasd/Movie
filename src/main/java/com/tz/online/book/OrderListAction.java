package com.tz.online.book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns="/order/list")
public class OrderListAction extends HttpServlet{

	private static final long serialVersionUID = -3918140558571927117L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("=============list=====================");
		request.getRequestDispatcher("/jsp/cart/order_list.jsp").forward(request, response);
	}

}
