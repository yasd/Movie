package com.tz.online.dao.Impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.tz.online.dao.IOrderDao;
import com.tz.online.entity.Book;
import com.tz.online.order.Order;
import com.tz.online.util.HibernateCallback;
import com.tz.online.util.HibernateTemplate;

public class OrderDaoImpl implements IOrderDao {

	@Override
	public void save(Order order) {
		HibernateTemplate.execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session ses) throws HibernateException {
				return ses.save(order);
			}
		});
	}

	@Override
	public void deleteById(Long id) {
		HibernateTemplate.execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session ses) throws HibernateException {
				Book book =(Book) ses.get(Book.class, id);
				if (book!=null) {
					ses.delete(id);
				}
				return null;
			}
		});
	}

	@Override
	public Order getByUserId(Long userid) {
		return (Order) HibernateTemplate.execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session ses) throws HibernateException {
				return ses.createQuery("from Order where id=:uid").setParameter("uid", userid).uniqueResult();
			}
		});
	}

	@Override
	public Order getById(Long oid) {
		return (Order) HibernateTemplate.execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session ses) throws HibernateException {
				return ses.createQuery("from Order where id=:did").setParameter("did", oid).uniqueResult();
			}
		});
	}

}
