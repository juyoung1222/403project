<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="bookstore.shopping.MemberDAO" %>
<%
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	String name = request.getParameter("name");
	String tel = request.getParameter("tel1") + "-" + request.getParameter("tel2") + "-" + request.getParameter("tel3");
	String address = request.getParameter("address");

	//System.out.println("ID:"+id);
	//System.out.println("name:"+name);
%>
<jsp:useBean id="member" scope="page"
           class="bookstore.shopping.MemberDTO">
</jsp:useBean>

<%
member.setId(id);
member.setPasswd(passwd);
member.setName(name);
member.setTel(tel);
member.setAddress(address);
member.setReg_date(new Timestamp(System.currentTimeMillis()));

MemberDAO memberDAO = MemberDAO.getInstance();
memberDAO.insertMember(member);
response.sendRedirect("../ShopMain.jsp");

%>