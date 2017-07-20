package com.tz.online.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * 本类用来演示:实现安全退出[主要目的就是为了清空session作用域]
 *  
 * @author success
 *
 * 2017年6月15日下午2:19:33
 */
@WebServlet(urlPatterns="/user/safeExit")
public class SafeExitAction extends HttpServlet{

	private static final long serialVersionUID = -7710233846246252696L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().invalidate();//清空session
		
		//重定向到登陆界面
		resp.sendRedirect(req.getContextPath()+"/book/index");
	}
}
