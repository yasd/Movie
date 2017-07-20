package com.tz.online.dao.Impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.tz.online.dao.IOrderItemDao;
import com.tz.online.entity.Book;
import com.tz.online.order.OrderItem;
import com.tz.online.util.HibernateCallback;
import com.tz.online.util.HibernateTemplate;

public class OrderItemDaoImpl implements IOrderItemDao {

	@Override
	public void save(OrderItem item) {
		HibernateTemplate.execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session ses) throws HibernateException {
				return ses.save(item);
			}
		});

	}

	@Override
	public void deleteById(Long id) {
		HibernateTemplate.execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session ses) throws HibernateException {
				OrderItem  order =(OrderItem) ses.get(OrderItem.class, id);
				ses.clear();
				if (order!=null) {
					ses.delete(id);
				}
				return null;
			}
		});
	}

}
