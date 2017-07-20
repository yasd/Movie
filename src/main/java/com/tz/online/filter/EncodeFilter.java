package com.tz.online.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns="/*",initParams={
		@WebInitParam(name="encoding",value="utf-8"),
		@WebInitParam(name="contentType",value="text/html;charset=utf-8")
})
public class EncodeFilter  implements Filter{
	private String contentType;
	private String encoding;

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
				//设置文档输出类型
		HttpServletRequest req =(HttpServletRequest) request;
		HttpServletResponse res =(HttpServletResponse) response;
		//设置处理post请求的乱码
		res.setContentType(contentType);
		req.setCharacterEncoding(encoding);
		chain.doFilter(req, res);
		System.out.println("=================乱码=====================");
				//放行...
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		encoding=config.getInitParameter("encoding");
		contentType=config.getInitParameter("contentType");
		
	}

}
