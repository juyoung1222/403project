package com.edu.cart.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.edu.cart.controller.CartController;
import com.edu.cart.mapper.CartMapper;

@Repository("com.edu.cart.service.CartService")
public class CartService {

	private static final Logger logger
		= LoggerFactory.getLogger(CartController.class);
	
	@Resource(name="com.edu.cart.mapper.CartMapper")
	CartMapper cartmapper;
	
	
	
//	//추가
//	public static int addCart(int cartuserid, int sessionId) {
//		logger.info("service addCart()...");
//		return 0;
//	}
//	
//	
//	//삭제
//	public static void deleteCart(int cartproductid) {
//		
//		
//	}

	
	
	
	
	
	
}
