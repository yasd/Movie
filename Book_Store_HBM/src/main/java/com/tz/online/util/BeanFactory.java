package com.tz.online.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BeanFactory {

	private static Properties prop = new Properties();

	static {
		try {
			InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("bean.properties");
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Object getBean(String beanName) {
		Object obj = null;
		try {
			Class<?> c = Class.forName(prop.getProperty(beanName));
			obj = c.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
