package com.tz.online.book;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tz.online.service.IUserService;
import com.tz.online.user.User;
import com.tz.online.util.BeanFactory;
@WebServlet(urlPatterns="/book/login")
public class IndexLoginAction extends HttpServlet{

	
	private static final long serialVersionUID = -3445510512800058370L;
	private IUserService userservice = (IUserService) BeanFactory.getBean("userService");
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("==========进入book，login=============");
		User user = null;
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password =request.getParameter("password");
		
		String ckbox = request.getParameter("ckbox");
		HttpSession session = request.getSession();
		
		System.out.println("姓名："+username+"密码:"+password);
		 user = userservice.login(username);
//		System.out.println("娶到的数据："+user.getUserName());
		 if (null==user) {
				System.out.println("用户名不存在！");
				out.print("0");
			}else if(!user.getPassWord().equals(password)){
				System.out.println("娶到的数据："+user.getUserName());
				
				out.print("1");
			}else {
				System.out.println("登录成功");
				request.getSession().setAttribute("user", user);
				String cookie = request.getParameter("cookie");
				if (null != cookie) {
					String uname = URLEncoder.encode(username, "utf-8");
					// 创建cookie
					Cookie cook = new Cookie("username", uname + ":" + password);
					// 设置过期时间
					cook.setMaxAge(60 * 60 * 24 * 7);
					cook.setPath("/");
					// 吧cookie写入到客户端
					response.addCookie(cook);

					// 否则
				} else {
					Cookie[] cooks = request.getCookies();
					if (null != cooks && cooks.length > 0) {
						for (Cookie coo : cooks) {
							coo.setMaxAge(1);
							coo.setPath("/");
							response.addCookie(coo);
						}
					}
				}
			}
	
		/*User user = userservice.login(username);*/
		/*request.getRequestDispatcher(request.getContextPath()+"/Nav.jsp?user="+user).forward(request, response);*/
	}
	

}
