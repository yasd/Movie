package com.tz.online.dao.Impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.tz.online.dao.IAddressDao;
import com.tz.online.entity.Address;
import com.tz.online.user.User;
import com.tz.online.util.HibernateCallback;
import com.tz.online.util.HibernateTemplate;

public class AdreessDaoImpl implements IAddressDao {

	// 保存地址
	@Override
	public void save(Address a) {
		HibernateTemplate.execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session ses) throws HibernateException {
				return ses.save(a);
			}
		});
	}

	// 获取用户指定ID的所有地址
	@SuppressWarnings("unchecked")
	@Override
	public List<Address> findByUserId(User userId) {
		return (List<Address>) HibernateTemplate.execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session ses) throws HibernateException {
				return ses.createQuery("from Address from book_userId=:uid").setParameter("uid", userId.getUserId()).list();
			}
		});
	}

	// 删除某个地址
	@Override
	public void delete(Address a) {
		HibernateTemplate.execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session ses) throws HibernateException {
				Address addr = (Address) ses.get(Address.class, a.getAddressId());
				if (addr != null) {
					ses.delete(a);
				}
				return null;
			}
		});
	}

	// 根据ID查询
	@Override
	public Address findById(Long id) {
		return (Address) HibernateTemplate.execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session ses) throws HibernateException {
				return ses.get(Address.class, id);
			}
		});
	}

	// 更新地址
	@Override
	public void update(Address a) {
		HibernateTemplate.execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session ses) throws HibernateException {
				Address addr = (Address) ses.get(Address.class, a.getAddressId());
				ses.clear();
				if (addr != null) {
					ses.update(a);
				}
				return null;
			}
		});
	}

}
