<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="bookstore.shopping.MemberDAO"%>
<%@page import="java.io.PrintWriter" %>
<%
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");

//사용자 인증을 하기위해 MemberDAO에 의뢰한다.
MemberDAO memberDAO = MemberDAO.getInstance();
int check=memberDAO.userCheck(id,passwd);

PrintWriter pw = response.getWriter();
//인증 결과에 따라 처리를 다르게 한다.
if(check==1){
	//정상적으로 로그인이 검증되면 세션을 발급한다.
	session.setAttribute("id", id);
	response.sendRedirect("../ShopMain.jsp");
}else if(check==0){
	pw.println("<script>");
	pw.println("alert('비밀번호가 맞지 않습니다.')");
	pw.println("history.go(-1)");
	pw.println("</script>");
}else{
	pw.println("<script>");
	pw.println("alert('아이디가 존재하지 않습니다..')");
	pw.println("history.go(-1)");
	pw.println("</script>");
	
}
%>