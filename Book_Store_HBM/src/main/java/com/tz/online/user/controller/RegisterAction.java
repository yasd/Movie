package com.tz.online.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.tz.online.service.IUserService;
import com.tz.online.user.User;
import com.tz.online.util.BeanFactory;
@WebServlet(urlPatterns="/user/register")
public class RegisterAction extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private IUserService usersevice = (IUserService) BeanFactory.getBean("userService");
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String rname=request.getParameter("rname");
		String password=request.getParameter("password");
		String checkpwd=request.getParameter("checkpwd");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String company=request.getParameter("company");
		String address=request.getParameter("address");
		
		User u =usersevice.selectByName(rname);
		request.setAttribute("u",u);
		System.out.println("=============后台++============"+u.getUserName());
	/*	User u = new User();
		u.getAddress();
		u.getCompany();
		u.getPhone();
		u.getEmail();
		u.getUserName();
		u.getPassWord();*/
		
		
	}

}
