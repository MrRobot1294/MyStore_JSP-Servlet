package com.mystore.service.impl;

import com.mystore.dao.OrderItemDao;
import com.mystore.dao.impl.OrderItemDaoImpl;
import com.mystore.domain.OrderItem;
import com.mystore.service.OrderItemService;
import com.mystore.util.TransactionManager;

public class OrderItemServiceImpl implements OrderItemService {

	private OrderItemDao orderItemDao = new OrderItemDaoImpl();
	
	public boolean addOrderItem(OrderItem orderItem) {
		TransactionManager.startTransaction();
		int placeOrder = orderItemDao.saveOrderItem(orderItem);
		if(placeOrder > 0){
			TransactionManager.commit();
			return true;
		}
		TransactionManager.rollback();
		TransactionManager.release();
		return false;
	}

}
