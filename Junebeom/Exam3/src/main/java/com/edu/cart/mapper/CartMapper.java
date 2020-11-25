package com.edu.cart.mapper;

import org.springframework.stereotype.Repository;

import com.edu.cart.domain.CartDTO;



@Repository("com.edu.cart.Mapper.CartMapper")
public interface CartMapper {
	
	//추가
	public int addCart(CartDTO cartDTO) throws Exception;
	
	//삭제
	public void deleteCart(CartDTO cartDTO) throws Exception;
}
