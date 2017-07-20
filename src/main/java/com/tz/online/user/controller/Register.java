/**
 * 
 */
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

/***
 * 本类用来演示
 * @author 代亚顺
 *
 * 2017年6月30日下午2:38:28
 */
@WebServlet(urlPatterns="/user/register")
public class Register extends HttpServlet{

	private static final long serialVersionUID = 2993004069605334636L;
	private IUserService userService = (IUserService) BeanFactory.getBean("userService");
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/*获取Form表单传过来的数据*/
		String username = req.getParameter("rname");
		String password1 = req.getParameter("rpassword");
//		String password2 = req.getParameter("regpwd2");
		String email = req.getParameter("remail");
		String phone = req.getParameter("rphone");
		String company = req.getParameter("rcompany");
		String address = req.getParameter("raddress");
		
		/*创建一个新用户*/
		User u = new User();
		u.setAddress(address);
		u.setCompany(company);
		u.setEmail(email);
		/*u.setGender(null);*/
		u.setPassWord(password1);
		u.setPhone(phone);
		u.setUserName(username);
		
		/*将这个新用户用service方法保存*/
		userService.register(u);
		System.out.println("用户注册成功！");
	resp.sendRedirect(req.getContextPath()+"/book/index?tologin=1");
	}
}
