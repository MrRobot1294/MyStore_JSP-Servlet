package com.mystore.service.impl;

import java.util.List;

import com.mystore.dao.CategoryDao;
import com.mystore.dao.impl.CategoryDaoImpl;
import com.mystore.domain.Category;
import com.mystore.domain.Page;
import com.mystore.service.CategoryService;
import com.mystore.util.TransactionManager;


public class CategoryServiceImpl implements CategoryService {

	private CategoryDao categoryDao = new CategoryDaoImpl();
	
	public boolean addCategory(Category category) {
		if(category == null){
			throw new IllegalArgumentException("category is null...");
		}
		TransactionManager.startTransaction();
		int addCategory = categoryDao.addCategory(category);
		if(addCategory > 0){
			TransactionManager.commit();
			TransactionManager.release();
			return true;
		}
		TransactionManager.rollback();
		TransactionManager.release();
		return false;
	}

	public boolean deleteCategory(int cid) {
		TransactionManager.startTransaction();
		int deleteCategory = categoryDao.deleteCategory(cid);
		if(deleteCategory > 0){
			TransactionManager.commit();
			TransactionManager.release();
			return true;
		}
		TransactionManager.rollback();
		TransactionManager.release();
		return false;
	}

	public boolean updateCategory(Category category) {
		if(category == null){
			throw new IllegalArgumentException("category is null...");
		}
		TransactionManager.startTransaction();
		int updateCategory = categoryDao.updateCategory(category);
		if(updateCategory > 0){
			TransactionManager.commit();
			TransactionManager.release();
			return true;
		}
		TransactionManager.rollback();
		TransactionManager.release();
		return false;
	}

	public List<Category> findAllCategory() {
		List<Category> categories = categoryDao.findAllCategory();
		return categories;
	}
	
	public Page findPageRecodes(String num){
		int pageNum = 1;
		if(num != null){
			pageNum = Integer.parseInt(num);
		}
		int totalRecordNum = categoryDao.findRecordCount();
		Page page = new Page(pageNum,totalRecordNum,5);
		List<Category> records = categoryDao.findPageRecords(page.getStartIndex(), page.getPageSize());
		page.setRecords(records);
		return page;
		
	}
}
