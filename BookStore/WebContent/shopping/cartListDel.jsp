<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="bookstore.shopping.CartDAO"%>

<%
	String cart_id = request.getParameter("cart_id");
	String buyer = (String)session.getAttribute("id");
	String book_kind = request.getParameter("book_kind");
	
	//세션아이디가 없는경우
	//1.로그인을 하지않는 경우
	//2.로그아웃을 한 경우
	//3.커넥션 풀에서 지정한 시간이 경과한 경우
	if(session.getAttribute("id")==null){
		response.sendRedirect("ShopMain.jsp");
	}else{
		CartDAO cartDAO = CartDAO.getInstance();
		
		if(cart_id.equals("all")){//장바구니 모두 비우기
			//cartDAO.deleteAll(buyer);
		}else{
			cartDAO.deleteList(Integer.parseInt(cart_id));
		}
		response.sendRedirect("cartList.jsp?book_kind=" + book_kind);
	}
%>