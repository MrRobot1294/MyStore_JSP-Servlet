package com.mystore.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mystore.domain.Category;
import com.mystore.domain.Product;
import com.mystore.service.CategoryService;
import com.mystore.service.ProductService;
import com.mystore.service.impl.CategoryServiceImpl;
import com.mystore.service.impl.ProductServiceImpl;

public class MainServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CategoryService categoryService = new CategoryServiceImpl();
		List<Category> categories = categoryService.findAllCategory();
		request.getSession().setAttribute("categories", categories);
		
		ProductService productService = new ProductServiceImpl();
		List<Product> productTop = productService.selectTop(4);
		request.getSession().setAttribute("productTop", productTop);
		
		List<Product> hotProducts = productService.selectTop(6, 5);
		request.getSession().setAttribute("hotProducts", hotProducts);
		
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}

}
