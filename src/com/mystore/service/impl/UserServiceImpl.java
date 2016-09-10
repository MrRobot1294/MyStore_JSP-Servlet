package com.mystore.service.impl;

import com.mystore.dao.UserDao;
import com.mystore.dao.impl.UserDaoImpl;
import com.mystore.domain.User;
import com.mystore.service.UserService;
import com.mystore.util.TransactionManager;

public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();
	
	public User login(String username, String password) {
		
		User user = userDao.findUserByUsernameAndPassword(username, password);
		
		return user;
	}

	public boolean regist(User user) {
		if(user == null){
			throw new IllegalArgumentException("用户为空");
		}
		TransactionManager.startTransaction();
		userDao.saveUser(user);
		TransactionManager.commit();
		TransactionManager.release();
		return true;
	}

	public boolean updateUserMsg(User user) {
		if(user == null){
			throw new IllegalArgumentException("用户为空");
		}
		TransactionManager.startTransaction();
		userDao.updateUser(user);
		TransactionManager.commit();
		TransactionManager.release();
		return true;
	}

}
