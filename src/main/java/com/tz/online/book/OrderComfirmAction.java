package com.tz.online.book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns="/order/comfirm")
public class OrderComfirmAction  extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("=========comfirm===========");
	
		request.getRequestDispatcher("/jsp/cart/comfirm_list.jsp").forward(request, response);
	}
}
