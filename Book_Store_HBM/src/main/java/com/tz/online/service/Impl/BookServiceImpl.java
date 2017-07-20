package com.tz.online.service.Impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.tz.online.dao.IBookDao;
import com.tz.online.dao.ICategoryDao;
import com.tz.online.entity.Book;
import com.tz.online.entity.Category;
import com.tz.online.entity.PageBean;
import com.tz.online.service.IBookService;
import com.tz.online.util.BeanFactory;
import com.tz.online.util.HibernateCallback;
import com.tz.online.util.HibernateTemplate;

public class BookServiceImpl implements IBookService {
	
	/*private IBookDao bookDao = (IBookDao) BeansFactory.getBean("bookDao");*/
	
	private  IBookDao bookdao = (IBookDao) BeanFactory.getBean("bookDao");
	
	private ICategoryDao catedao =(ICategoryDao) BeanFactory.getBean("categoryDao");
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Book> selectByCondition(Integer now, int size, String cate) {
		return (List<Book>) HibernateTemplate.execute(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session ses) throws HibernateException {
				Criteria c = ses.createCriteria(Book.class, "b");
				//
				if (cate != null && cate.trim().length() > 0) {
					c.add(Restrictions.eq("b.cate", "%" + cate + "%"));
				}
				// 返回
				c.setFirstResult((now - 1) * size);
				c.setMaxResults(size);
				return c.list();
			}
		});
	}



	@Override
	public int rowCount(String cate) {
		Long count = (Long) HibernateTemplate.execute(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session ses) throws HibernateException {
				return HibernateTemplate.execute(new HibernateCallback() {

					@Override
					public Object doInHibernate(Session ses) throws HibernateException {
						Criteria c = ses.createCriteria(Book.class, "b");
						// 判断
						if (cate != null) {
							c.createAlias("b.category", "c").add(Restrictions.eq("c.name", cate));
						}
						return c.setProjection(Projections.rowCount()).setCacheable(true).uniqueResult();
					}
				});
			}
		});
		return count.intValue();
	}

	@Override
	public PageBean<Book> findByPage(String bookName, Category category, Long pageNow, Long pageSize) {
		//1.创建一个PageBean<Book>对象
				PageBean<Book> page = new PageBean<Book>();
				
				//2.封装满足条件需要的books集合
				List<Book> books = bookdao.findAll(bookName, category, pageNow, pageSize);
				
				page.setList(books);
				
				//3.封装每页显示多少条.
				page.setPageSize(pageSize);
				
				//4.封装当前页
				page.setPageNow(pageNow);
				
				//5.处理总的页数...
				
				//6.必须要得到总的条数.
				//从性能上面考虑,不推荐调用集合的size方法.
				long rowCount = bookdao.getRowCount(bookName, category);
				
				Long pageCount = rowCount/pageSize;
				
				if(rowCount%pageSize!=0)
					pageCount++;
				
				page.setPageCount(pageCount);
				
				return page;
			}



	@Override
	public Book findById(Long id) {
		return bookdao.queryById(id);
		}



	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return catedao.findAll();
	}



	@Override
	public List<Book> findAll(String bookName, Category category, Long pageNow, Long pageSize) {
		return bookdao.findAll(bookName, category, pageNow, pageSize);
		}

	}

