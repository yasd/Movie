package com.tz.online.listenner;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.tz.online.util.HibernateUtil;


/**
 * 
 * 本类用来演示:该监听器负责在启动tomcat的时候
 * 				将上下文路径放入到application作用域
 *  
 * @author success
 *
 * 2017年6月21日下午3:20:18
 */
@WebListener
public class CreateContextPath implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//在容器启动的时候,为我们加载hibernate.cfg.xml
		//主要目的是为了提前创建SessionFactory对象.
		HibernateUtil.getSession();
		
		
		//获取ServletContext对象
		ServletContext sc = sce.getServletContext();
		
		//获取上下文路径
		String path = sc.getContextPath();
		
		//System.out.println("path:"+path);
		
		//将path放入到ServletContext作用域中[就是application作用域]
		sc.setAttribute("path", path);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
