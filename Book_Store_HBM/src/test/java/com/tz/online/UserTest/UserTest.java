package com.tz.online.UserTest;

import org.junit.Test;

import com.tz.online.dao.IUserDao;
import com.tz.online.user.User;
import com.tz.online.util.BeanFactory;

public class UserTest {
	
	IUserDao userdao = (IUserDao) BeanFactory.getBean("userDao");
	
	@Test
	public void findByNameTest(){
		User user = userdao.selectByName("admin");
		System.out.println(user);
			}
	@Test
	public void saveTest(){
		User user = new User("admin", "123456", "123@1qq.com", "15156417820", "天智", "烽火路");
		userdao.save(user);
		
	}
	/*@Test
	public void UpdateTest(){
		User user = userdao.selectByName(userName);
		
	}*/

}
