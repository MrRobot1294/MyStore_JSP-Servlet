package com.mystore.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mystore.dao.OrderItemDao;
import com.mystore.domain.OrderItem;
import com.mystore.util.C3P0Util;

public class OrderItemDaoImpl implements OrderItemDao {

	public int saveOrderItem(OrderItem orderItem) {
		try {
			QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
			String sql = "insert into orderitem(oid,pid,buynum) values(?,?,?)";
			int update = qr.update(sql, orderItem.getOid(),
					orderItem.getPid(), orderItem.getBuynum());
			return update;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public int deleteOrderItem(int itemid) {
		try {
			QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
			String sql = "delete from orderitem where itemid=?";
			int update = qr.update(sql, itemid);
			return update;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public int updateOrderItem(OrderItem orderItem) {
		try {
			QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
			String sql = "update orderitem set oid=?,pid=?,buynum=? where itemid=?";
			int update = qr.update(sql, orderItem.getOid(), orderItem.getPid(),
					orderItem.getBuynum(), orderItem.getItemid());
			return update;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public OrderItem findOrderItemByItemid(int itemid) {
		try {
			QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
			String sql = "select * from orderitem where itemid=?";
			OrderItem orderItem = qr.query(sql, new BeanHandler<OrderItem>(OrderItem.class), itemid);
			return orderItem;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<OrderItem> findAllOrderItem() {
		try {
			QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
			String sql = "select * from orderitem";
			List<OrderItem> orderItem = qr.query(sql, new BeanListHandler<OrderItem>(OrderItem.class));
			return orderItem;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
