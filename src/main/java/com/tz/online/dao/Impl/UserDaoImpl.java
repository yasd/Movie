package com.tz.online.dao.Impl;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tz.online.dao.IUserDao;
import com.tz.online.user.User;
import com.tz.online.util.HibernateCallback;
import com.tz.online.util.HibernateTemplate;
import com.tz.online.util.HibernateUtil;

public class UserDaoImpl implements IUserDao {

	//根据用户名查询用户
	@Override
	public User selectByName(String userName) {
		return (User) HibernateTemplate.execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session ses) throws HibernateException {
				return ses.createQuery("from User where username=:uname").setParameter("uname", userName).uniqueResult();
			}
		});
	}

	//保存对象
	@Override
	public void save(User user) {
		Session session = null;
		Transaction tx = null;
		session = HibernateUtil.getSession();
		try {
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {	
		}	
	}
	
	//更新用户
	@Override
	public void update(User user) {
		HibernateTemplate.execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session ses) throws HibernateException {
				User u = (User) ses.get(User.class, user.getUserId());
				if(u!=null){
					ses.update(user);
				}
				return null;
			}
		});
	}

}
