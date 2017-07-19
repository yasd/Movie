package com.tz.online.service;

import java.util.List;

import javax.security.auth.login.LoginException;

import com.tz.online.entity.Address;
import com.tz.online.user.User;

public interface IUserService {

	//验证用户是否合法
	User login(String name);
	//完成用户的注册功能
	void register(User user);
	//验证某个用户名是否可用，可用返回true，否则返回false
	boolean validate(String name);
	//添加地址
	void addAddress(Address a);
	//更新指定地址信息
	void upAddress(Address a);
	//根据用户查询此用户的所有地址
	List<Address> getAddressByUser(User user);
	//按主键查询地址
	Address getAddrById(Long id);
	public User selectByName(String userName);
}
