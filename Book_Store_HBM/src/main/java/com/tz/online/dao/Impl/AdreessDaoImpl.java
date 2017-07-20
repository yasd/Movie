package com.tz.online.dao.Impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tz.online.dao.IAddressDao;
import com.tz.online.entity.Address;
import com.tz.online.util.HibernateCallback;
import com.tz.online.util.HibernateTemplate;
import com.tz.online.util.HibernateUtil;

public class AdreessDaoImpl implements IAddressDao {

	//保存地址
	@Override
	public void save(Address a) {
		Session session = null;
		Transaction tx = null;
		session = HibernateUtil.getSession();
		try {
			tx = session.beginTransaction();
			session.save(a);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {	
		}	
	}

	//获取用户指定ID的所有地址
	@SuppressWarnings("unchecked")
	@Override
	public List<Address> findByUserId(Long userId) {
		return (List<Address>) HibernateTemplate.execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session ses) throws HibernateException {
				return ses.get(Address.class, userId);
			}
		});
	}

	//删除某个地址
	@Override
	public void delete(Address a) {
		Session session = null;
		Transaction tx = null;
		session = HibernateUtil.getSession();
		try {
			tx = session.beginTransaction();
			session.delete(a);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {	
		}	
	}

	//根据ID查询
	@Override
	public Address findById(Long id) {
		Session session =null;
		Transaction tx = null;
		Address address = new Address();
		session = HibernateUtil.getSession();
		try {
			tx=session.beginTransaction();
			String hql="from product where id=?";
			Query query=session.createQuery(hql).setLong(0, id);
			address = (Address) query.list().get(0);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return address;
	}

	//更新地址
	@Override
	public void update(Address a) {
		Session session = null;
		Transaction tx = null;
		session = HibernateUtil.getSession();
		try {
			tx = session.beginTransaction();
			session.update(a);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {	
		}	
		
	}

}
