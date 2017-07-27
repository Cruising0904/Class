<%@ include file="/project/p_head.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.test.common.DBConn2" %>
<%@ page import="com.test.dto.BoardInfo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자료검색</title>
</head>
<%
	String biTitle = request.getParameter("bititle");
	String biContent = request.getParameter("bicontent");
	String biNum = request.getParameter("binum");
	Connection con = null;
	PreparedStatement ps = null;
	try{
		con = DBConn2.getCon();
		String sql = "select binum, bititle,bicontent, creusr, credat from board_info";
		ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		String table ="<table border='1'>";
		table += "<tr>";
		table += "<td>번호</td>";
		table += "<td>제목</td>";
		table += "<td>내용</td>";
		table += "<td>작성자</td>";
		table += "<td>작성일자</td>";
		table += "</tr>";
		while(rs.next()){
			table += "<tr>";
			table += "<td>"+rs.getInt("biNum")+"</td>";
			table += "<td>"+rs.getString("biTitle")+"</td>";
			table += "<td>"+rs.getString("biContent")+"</td>";
			table += "<td>"+rs.getString("creUsr")+"</td>";
			table += "<td>"+rs.getString("credat")+"</td>";
			table += "</tr>";
		}
		table += "</table>";
		out.println(table);
	}catch(Exception e){
		System.out.println(e);
	}
%>
<body>
<input type="button" value="메인이동" onclick="doMovePage('main')"/>
<input type="button" value="게시물 작성" onclick="doMovePage('insert')"/><br/>

</body>
</html>