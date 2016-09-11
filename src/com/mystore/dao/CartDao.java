package com.mystore.dao;

import com.mystore.domain.ShoppingCar;

public interface CartDao {

	ShoppingCar findCart(int uid);
	
	int saveCar(int uid);
	
	
	
}
