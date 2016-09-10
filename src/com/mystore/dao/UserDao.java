package com.mystore.dao;

import com.mystore.domain.User;

public interface UserDao {

	/**
	 * 根据用户名和密码查找用户
	 * @return
	 */
	public User findUserByUsernameAndPassword(String username,String password);
	
	/**
	 * 保存用户
	 * @param user
	 * @return
	 */
	public boolean saveUser(User user);
	
	/**
	 * 更新用户
	 * @param user
	 * @return
	 */
	public boolean updateUser(User user);
	
	
	
}
