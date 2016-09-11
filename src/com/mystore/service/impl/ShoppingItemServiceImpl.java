package com.mystore.service.impl;

import com.mystore.dao.ShoppingItemDao;
import com.mystore.dao.impl.ShoppingItemDaoImpl;
import com.mystore.service.ShoppingItemService;
import com.mystore.util.TransactionManager;

public class ShoppingItemServiceImpl implements ShoppingItemService {

	private ShoppingItemDao shoppingItemDao = new ShoppingItemDaoImpl();

	public boolean addShoppingItem(String pid, int sid, int snum) {

		TransactionManager.startTransaction();
		int addShoppingItem = shoppingItemDao.addShoppingItem(pid, sid, snum);
		if (addShoppingItem > 0) {
			TransactionManager.commit();
			return true;
		}
		TransactionManager.rollback();
		TransactionManager.release();
		return false;
	}

	public boolean deleteShoppingItem(int itemid) {

		TransactionManager.startTransaction();
		int deleteShoppingItem = shoppingItemDao.deleteShoppingItem(itemid);
		if (deleteShoppingItem > 0) {
			TransactionManager.commit();
			return true;
		}
		TransactionManager.rollback();
		TransactionManager.release();
		return false;
	}

}
