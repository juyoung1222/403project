package com.example1.practice1.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example1.practice1.domain.CartDetailDTO;
import com.example1.practice1.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(CartController.class);
	@Resource(name="com.example1.practice1.service.CartService")
	CartService cartService;
	

	//카트 목록 보여주기
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	private String cartList(int cartno, Model model) throws Exception {
		
		model.addAttribute("list", cartService.cartListService());
		return "/cart/list";
	}
	
	//카트에 담기
	
	@RequestMapping(value = "/insertCart", method = { RequestMethod.GET, RequestMethod.POST})
	public String insertCart(CartDetailDTO cartDetailDTO, Model model) throws Exception {
		
		System.out.println(cartDetailDTO);
		
		int result = cartService.insertCart(cartDetailDTO);
		model.addAttribute("list", cartService.cartListService());

		return "/cart/list";
	}

	
	
	//삭제
	@RequestMapping("/cartDelete/{cartno}")
	private String cartDelete(@RequestParam int cartno, Model model) throws Exception {
		
		logger.info("delete" + cartno);
		cartService.cartDeleteService(cartno);
		return "redirect:/cart/list";
	}
	
	
	
}



