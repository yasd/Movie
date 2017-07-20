package com.tz.online.dao;

import com.tz.online.user.User;

public interface IUserDao {

	//根据用户名查询用户
	public User selectByName(String userName);
	//保存用户对象
	public void save(User user);
	//更新用户
	public void update(User user);
	
}
