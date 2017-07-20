/**
 * 
 */
package com.tz.online.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tz.online.service.IUserService;
import com.tz.online.user.User;
import com.tz.online.util.BeanFactory;


/***
 * 本类用来演示
 * @author 代亚顺
 *
 * 2017年6月30日下午2:38:28
 */
@WebServlet(urlPatterns="/user/checkUserName")
public class CheckUserAction extends HttpServlet{

	private static final long serialVersionUID = -4198370434261327950L;
	
	private IUserService userService = (IUserService) BeanFactory.getBean("userService");
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置文档编码
		resp.setContentType("application/json;charset=utf-8");
		System.out.println("=========进入验证用户名后台============");
		
		PrintWriter out = resp.getWriter();
		
		String username = req.getParameter("username");
		
		User u = userService.login(username);
		
		if(u!=null){
			out.print("0");
			System.out.println("用户名名重复");
		}else{
			out.print("ok");
			System.out.println("用户名可以用");
		}
	}
}
