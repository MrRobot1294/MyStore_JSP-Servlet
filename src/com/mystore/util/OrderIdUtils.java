package com.mystore.util;

import java.util.UUID;

public class OrderIdUtils {

	public static String getOid(){
		String oid = UUID.randomUUID().toString().replaceAll("-", "");
		return oid;
	}
	
}
