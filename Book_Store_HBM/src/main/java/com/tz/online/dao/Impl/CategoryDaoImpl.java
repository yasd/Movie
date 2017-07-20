package com.tz.online.dao.Impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.tz.online.dao.ICategoryDao;
import com.tz.online.entity.Category;
import com.tz.online.util.HibernateCallback;
import com.tz.online.util.HibernateTemplate;

public class CategoryDaoImpl implements ICategoryDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return (List<Category>) HibernateTemplate.execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session ses) throws HibernateException {
				return ses.createCriteria(Category.class).list();
			}
		});
	}

	

}
