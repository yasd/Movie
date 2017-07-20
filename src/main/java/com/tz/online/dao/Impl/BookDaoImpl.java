package com.tz.online.dao.Impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.tz.online.dao.IBookDao;
import com.tz.online.entity.Book;
import com.tz.online.entity.Category;
import com.tz.online.entity.PageBean;
import com.tz.online.util.HibernateCallback;
import com.tz.online.util.HibernateTemplate;

public class BookDaoImpl implements IBookDao {
/*private IBookDao bookdao = (IBookDao) BeanFactory.getBean("bookDao");*/
	@Override
	public PageBean<Book> queryByCondition(Integer now, int size, String cate) {
		return null;
		
	}

	@Override
	public Book queryById(Long id) {
		return (Book) HibernateTemplate.execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session ses) throws HibernateException {
				return ses.createQuery("from Book where id=:bid").setParameter("bid", id).uniqueResult();
			}
		});
	}

	@Override
	public List<Category> getAllCategories() {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> findAll(String bookName, Category category, Long pageNow, Long pageSize) {
		return (List<Book>) HibernateTemplate.execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session ses) throws HibernateException {
				//多条件组合查询优先使用qbc-query by criteria
				Criteria c = ses.createCriteria(Book.class,"b");
				
				
				//判断条件是否存在.
				if(null!=bookName && bookName.trim().length()>0){
					c.add(Restrictions.like("b.name", "%"+bookName+"%"));
				}
				
				if(null!=category && !"-1".equals(String.valueOf(category))){
					c.add(Restrictions.eq("b.category", category));
				}
				
				c.setFirstResult((int)((pageNow-1)*pageSize)).setMaxResults(pageSize.intValue());
				
				return c.list();
			}
		});
	}

	@Override
	public long getRowCount(String bookName, Category category) {
		return (long) HibernateTemplate.execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session ses) throws HibernateException {
				//多条件组合查询优先使用qbc-query by criteria
				Criteria c = ses.createCriteria(Book.class,"b");
				
				
				//判断条件是否存在.
				if(null!=bookName && bookName.trim().length()>0){
					c.add(Restrictions.like("b.name", "%"+bookName+"%"));
				}
				
				if(null!=category && !"-1".equals(String.valueOf(category))){
					c.add(Restrictions.eq("b.category", category));
				}
				
				return c.setProjection(Projections.rowCount()).uniqueResult();
			}
		});
	}

	@Override
	public void deleteById(Long id) {
		
		HibernateTemplate.execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session ses) throws HibernateException {
				Book book = (Book) ses.get(Book.class, id);
				if (book!=null) {
					ses.delete(book);
				}
				return null;
			}
		});
		
		}
	}
	

