package com.mystore.service.impl;

import com.mystore.dao.CartDao;
import com.mystore.dao.impl.CartDaoImpl;
import com.mystore.domain.ShoppingCar;
import com.mystore.service.CartService;
import com.mystore.util.TransactionManager;

public class CartServiceImpl implements CartService{

	private CartDao cartDao = new CartDaoImpl();
	
	public ShoppingCar findCart(int uid) {
		ShoppingCar sc = cartDao.findCart(uid);
		return sc;
	}
	
	public boolean addCart(int uid) {
		TransactionManager.startTransaction();
		int saveCar = cartDao.saveCar(uid);
		if(saveCar > 0){
			TransactionManager.commit();
			TransactionManager.release();
			return true;
		}
		TransactionManager.rollback();
		TransactionManager.release();
		return false;
	}

	

}
