package com.example1.practice1.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example1.practice1.domain.CartDetailDTO;

@Repository("com.example1.practice1.mapper.CartMapper")
public interface CartMapper {

	//장바구니 목록 보기
	public List<CartDetailDTO> cartList() throws Exception;
	
	//장바구니 등록
	public int insertCart(CartDetailDTO cartDetailDTO) throws Exception;
	
	//삭제
	public int cartDelete(int cartno) throws Exception;
	
}
