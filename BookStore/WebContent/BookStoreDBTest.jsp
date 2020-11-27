<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- jsp에서 jdbc의 객체를 사용하기 위해서 java.sql 패키지를 import한다. -->
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Connection Pool Test Program</title>
</head>
<body>
	<table width="550" border="1">
<%
Connection			conn	= null;
PreparedStatement	pstmt	= null;
ResultSet			rs		= null;

try {
	//String url = "jdbc:mysql://localhost:3306/bookstoredb?serverTimezone=UTC";
	String url = "jdbc:mysql://localhost:3306/bookstoredb?useSSL=false";
	String id  = "bookmaster";
	String pw  = "class403";
	
	//1. 데이터베이스와 연동하기 위해서 DriverManager에 등록한다.
	Class.forName("com.mysql.jdbc.Driver");
	
	//2. DriverManger 객체 로부터 Connection 객체를 얻어온다.
	conn = DriverManager.getConnection(url, id, pw);
	
	//3. query
	String sql = "select * from manager";
	
	pstmt = conn.prepareStatement(sql);
	rs    = pstmt.executeQuery();
	
	while(rs.next()) {
		String gid = rs.getString("managerId");
		String gpw = rs.getString("managerPassword");
%>
		<tr>
			<td width="250"><%=gid %></td>
			<td width="250"><%=gpw %></td>
		</tr>
<%
	}
} catch(Exception e) {
	e.printStackTrace();
	e.getMessage();
	out.println("manager 테이블을 호출하는데 실패하였습니다.");
} finally {
	//쿼리의 성공과 실패에 상관없이 사용한 자원을 해제한다.(**순서중요**)
	if(rs    != null) try {rs.close();		} catch(SQLException sqle) {}
	if(pstmt != null) try {pstmt.close();	} catch(SQLException sqle) {}
	if(conn  != null) try {conn.close();	} catch(SQLException sqle) {}
}
%>

	</table>

</body>
</html>



