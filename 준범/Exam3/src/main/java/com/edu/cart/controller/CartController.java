package com.edu.cart.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.eclipse.jdt.internal.compiler.codegen.AttributeNamesConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.edu.cart.service.CartService;



@Controller
@RequestMapping("cart/*")
public class CartController {

	private static final Logger logger
	= LoggerFactory.getLogger(CartController.class);
	
	@Inject
	CartService cartservice;
	
	@RequestMapping(value="/cart", method= RequestMethod.GET)
	public String getCart()throws Exception {
		logger.info("CartController getCart()");
		
		return "/cart";
	}
	
	
//	//추가
//	@RequestMapping(value="/cartlist", method= RequestMethod.GET)
//	public String  addCart( HttpSession session, @RequestParam("cartuserid") int cartuserid, Model model) throws Exception {
//		logger.info("CartController addCart()....");
//		
//		int result = 0 ;
//		
//		if(session.getAttribute("sessionId") == null ) {
//			result = 2;
//			model.addAttribute("attributeName: result", result);
//			model.addAttribute("attributeName: cartuserid", cartuserid);
//			
//		}
//		
//		int sessionId = Integer.parseInt(session.getAttribute("name: sessionId").toString());
//		result = CartService.addCart(cartuserid, sessionId);
//		model.addAttribute("attributeName: result", result);
//		
//		
//		return "/cart/cartChk";
//	}
	
//	//삭제
//	@RequestMapping(value="/cart/deleteCart", method= RequestMethod.GET)
//	public String deleteCart(@RequestParam("cartproductid") int cartproductid) throws Exception {
//		logger.info("CartController deleteCart()....");
//		
//		CartService.deleteCart(cartproductid);
//		
//		return "redirect:/cart/cartlist";
//	}
	
}
