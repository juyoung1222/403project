package com.example1.practice1.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;


import com.example1.practice1.domain.CartDetailDTO;
import com.example1.practice1.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Resource(name="com.example1.practice1.service.CartService")
	CartService cartService;
	

	//카트 목록 보여주기
	@RequestMapping("/list/{cartno}")
	private String cartList(int cartno, Model model) throws Exception {
		//카트 목록 보여주기 화면으로 가기 전에 보여줄 데이터를 가져와서 model에 담든다.
		model.addAttribute("list", cartService.cartListService());
		return "/cart/list/{cartno}";
	}
	
	//카트에 담기
	
	@RequestMapping(value = "/insertCart", method = { RequestMethod.GET, RequestMethod.POST})
	public String insertCart(CartDetailDTO cartDetailDTO) throws Exception {
		
		System.out.println(cartDetailDTO);
		
		int result = cartService.insertCart(cartDetailDTO);

		return "/cart/list";
	}

	
	
	//삭제
	@RequestMapping("/cart/{cartno}")
	private String cartDelete(@PathVariable int cartno) throws Exception {
		cartService.cartDeleteService(cartno);
		return "redirect:/cart/list";
	}
	
	
	
}



