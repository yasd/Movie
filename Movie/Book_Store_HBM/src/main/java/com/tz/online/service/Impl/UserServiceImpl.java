package com.tz.online.service.Impl;

import java.util.List;

import javax.security.auth.login.LoginException;

import com.tz.online.dao.IUserDao;
import com.tz.online.entity.Address;
import com.tz.online.service.IUserService;
import com.tz.online.user.User;
import com.tz.online.util.BeanFactory;

public class UserServiceImpl implements IUserService {

	private IUserDao userdao  =(IUserDao) BeanFactory.getBean("userDao");
	//验证用户是否合法
	@Override
	public User login(String name) {
		
		return userdao.selectByName(name);
	}
	//完成用户的注册功能
	@Override
	public void register(User user) {
		
	}

	//验证某个用户名是否可用，可用返回true，否则返回false
	@Override
	public boolean validate(String name) {
		return false;
	}
	//添加地址
	@Override
	public void addAddress(Address a) {
		
	}
	//更新指定地址信息
	@Override
	public void upAddress(Address a) {
		
	}
	//根据用户查询此用户的所有地址
	@Override
	public List<Address> getAddressByUser(User user) {
		return null;
	}
	//按主键查询地址
	@Override
	public Address getAddrById(Long id) {
		return null;
	}
	@Override
	public User selectByName(String userName) {
		// TODO Auto-generated method stub
		return userdao.selectByName(userName);
	}
	
	
}
