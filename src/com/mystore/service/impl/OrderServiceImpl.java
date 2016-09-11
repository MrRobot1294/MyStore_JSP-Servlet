package com.mystore.service.impl;

import java.util.List;

import com.mystore.dao.OrderDao;
import com.mystore.dao.impl.OrderDaoImpl;
import com.mystore.domain.Order;
import com.mystore.domain.Page;
import com.mystore.service.OrderService;
import com.mystore.util.TransactionManager;

public class OrderServiceImpl implements OrderService {
	
	private OrderDao orderDao = new OrderDaoImpl();

	public boolean placeOrder(Order order) {
		TransactionManager.startTransaction();
		int placeOrder = orderDao.placeOrder(order);
		if(placeOrder > 0){
			TransactionManager.commit();
			return true;
		}
		TransactionManager.rollback();
		TransactionManager.release();
		return false;
	}

	public boolean updateOrderState(String oid, int state) {
		TransactionManager.startTransaction();
		int updateOrder = orderDao.updateOrderStateByOid(oid, state);
		if(updateOrder > 0){
			TransactionManager.commit();
			return true;
		}
		TransactionManager.rollback();
		TransactionManager.release();
		return false;
	}
	
	public Order findOrderById(String oid) {
		Order findOrderById = orderDao.findOrderById(oid);
		return findOrderById;
	}

	public List<Order> findAllOrder() {
		List<Order> orders = orderDao.findAllOrder();
		return orders;
	}

	public Page findPageRecodes(String num) {
		int pageNum = 1;
		if(num != null){
			pageNum = Integer.parseInt(num);
		}
		int totalRecordNum = orderDao.findRecordCount();
		Page page = new Page(pageNum,totalRecordNum,5);
		List<Order> records = orderDao.findPageRecords(page.getStartIndex(), page.getPageSize());
		page.setRecords(records);
		return page;
	}

	public List<Order> findOrderByUid(int uid) {
		List<Order> orders = orderDao.findOrderByUid(uid);
		return orders;
	}

}
