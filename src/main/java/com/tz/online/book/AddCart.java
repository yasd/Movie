package com.tz.online.book;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tz.online.entity.Book;
import com.tz.online.order.OrderItem;
import com.tz.online.service.IBookService;
import com.tz.online.service.ICartService;
import com.tz.online.service.IOrderService;
import com.tz.online.user.User;
import com.tz.online.util.BeanFactory;
@WebServlet(urlPatterns="/cart/add")
public class AddCart extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
	private IBookService bookService = (IBookService) BeanFactory.getBean("bookService");
	private IOrderService orderservice = (IOrderService) BeanFactory.getBean("orderService");
	private ICartService cartService = (ICartService) BeanFactory.getBean("cartService");
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//定义一个输出流用来响应购物车业务
				PrintWriter out = resp.getWriter();
				
				HttpSession session = req.getSession();
				//从session中获取用户
				User user = (User) session.getAttribute("user");
				System.out.println("========这是user========="+user);
				if(user == null){
					//说明用户没有登录
					resp.sendRedirect(req.getContextPath()+"/book/index");
				}
				//否则说明用户登录了
				//获取从前台传过来的图书的ID以及数量
				Long bookId = Long.valueOf(req.getParameter("bookId"));
				Integer num = Integer.parseInt(req.getParameter("num"));
				
				//Order
				//Map<Book,Integer> map = new HashMap<>(); //Map中键->图书， 值->想要购买的数量
				
				Book book = bookService.findById(bookId);
				if(book==null){
					out.print("0");
					System.out.println("找不到图书");
				}else{
					//这时需要判断Session作用域中的购物车是否存在，如果不存在那就创建
					@SuppressWarnings("unchecked")
					Map<Long,OrderItem> cart = (Map<Long, OrderItem>) req.getSession().getAttribute("cart");
					if(cart==null){
						//如果购物车为空，那么就创建一个购物车
						cart = new HashMap<Long,OrderItem>();
						OrderItem item = new OrderItem();
						item.setBook_isbn(book.getIsbn());
						item.setBook_author(book.getAuthor());
						item.setBook_name(book.getName());
						item.setCount(num);
						item.setCcc(book.getNewPrice());
						item.setAllPrice(book.getNewPrice()*num);
						//保存一条明细
						cartService.addCart(item);
						//cart.put(user.getUserId(), );
						cart.put(book.getBookId(), item);
					}else{
						//判断这个Book是否已经在购物车内
						//Set<Long> set = cart.keySet();
						if(cart.containsKey(book.getBookId())){
//							OrderItem om = cart.get(book.getBookId());
							int oldCount = cart.get(book.getBookId()).getCount();
							double sp = book.getNewPrice();
//							double oldAllPrice = cart.get(book.getBookId()).getAllPrice();
//							om.setCount(om.getCount()+num);
							cart.get(book.getBookId()).setCount(oldCount+num);
							cart.get(book.getBookId()).setAllPrice((oldCount+num)*sp);
						}else{
							OrderItem item = new OrderItem();
							item.setBook_isbn(book.getIsbn());
							item.setBook_author(book.getAuthor());
							item.setBook_name(book.getName());
							item.setCcc(book.getNewPrice());
							item.setCount(num);
							item.setAllPrice(book.getNewPrice()*num);
							//保存一条明细
							cartService.addCart(item);
							cart.put(book.getBookId(), item);
						}
					}
					//将购物车存到Session作用域中
					session.setAttribute("book",book);
					session.setAttribute("cart", cart);
					
					//获取购物车图书的数量
					Integer count = cart.keySet().size();
					session.setAttribute("cartCount", count);
					
				}
			/*	resp.sendRedirect(req.getContextPath()+"/jsp/cart/listcart.jsp");*/
				
			}
}
