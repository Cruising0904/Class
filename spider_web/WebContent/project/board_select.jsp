<%@ include file="/project/p_head.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="com.test.common.DBConn2" %>
    <%@ page import="com.test.dto.BoardInfo" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판</title>
</head>
<script>
function goBoard(biNum,param2){
	location.href ="<%=rootPath%>/project/p_view.jsp?binum=" + biNum;
}
function doSearch(){
	var searchTarget = document.getElementById("searchTarget").value;
	var searchStr = document.getElementById("searchStr").value;
	location.href ="<%=rootPath%>/project/board_select.jsp?searchTarget=" + searchTarget + "&searchStr=" + searchStr;
}
</script>
<%
	String searchTarget = request.getParameter("searchTarget");
	String searchStr = request.getParameter("searchStr");
	Connection con = null;
	PreparedStatement ps = null;
	try{
		con = DBConn2.getCon();
		String sql = "select binum, bititle,bicontent, creusr, credat from board_info where 1=1 ";
		
		if(searchTarget!=null){
			if(searchTarget.equals("bititle")){
				sql += " and bititle like ?";
			}else if(searchTarget.equals("bicontent")){
				sql += " and bicontent like ?";
			}else if(searchTarget.equals("bicontent")){
				sql+= " and bicontent like ?";
			}else if(searchTarget.equals("creusr")){
				sql+= " and creusr like ?";
			}else if(searchTarget.equals("bicontitle")){
				sql+= " and bicontent like ? or bititle like ?";
			}
		}
		ps = con.prepareStatement(sql);
		if(searchTarget!=null){
			ps.setString(1, "%"+searchStr+"%");
			if(searchTarget.equals("bicontitle")){
				ps.setString(2, "%"+searchStr+"%");
			}
		}
		ResultSet rs = ps.executeQuery();
		String table ="<table border='1'>";
		table += "<tr>";
		table += "<td>번호</td>";
		table += "<td>제목</td>";
		table += "<td>내용</td>";
		table += "<td>작성자</td>";
		table += "<td>작성일자</td>";
		table += "</tr>";
		boolean existData = false;
		while(rs.next()){
			existData = true;
			table += "<tr>";
			table += "<td>"+rs.getInt("biNum")+"</td>";
			table += "<td><a href='#javascript' onclick='goBoard("+rs.getInt("binum")+")'>"+rs.getString("biTitle")+"</td>";
			table += "<td>"+rs.getString("biContent")+"</td>";
			table += "<td>"+rs.getString("creUsr")+"</td>";
			table += "<td>"+rs.getString("credat")+"</td>";
			table += "</tr>";
		}
		if(!existData){
			table += "<tr>";
			table += "<td colspan='6' align ='center'>데이터가 아무것도 없다!!!</td>";
			table += "</tr>";
		}else{
			table += "<tr>";
			table += "<td colspan='6' align='center'>";
			table += "<select name='searchTarget' id='searchTarget'>";
			table += "<option value='bititle'>제목</option>";
			table += "<option value='creusr'>작성자</option>";
			table += "<option value='bicontent'>내용</option>";
			table += "<option value='bicontitle'>제목 + 내용</option>";
			table += "</select> ";
			table += " <input type='text' name='searchStr' id='searchStr'/> ";
			table += " <input type='button' value='검색' onclick='doSearch()'/>";
			table += "</td>";
			table += "</tr>";
		}
		table += "</table>";
		out.println(table);
	}catch(Exception e){
		System.out.println(e);
	}finally{
		if(ps!=null){
			ps.close();
			ps=null;
		}
		DBConn2.closeCon();
	}
%>

<body>
<input type="button" value="게시물 작성" onclick="doMovePage('insert')"/><br/>


</body>
</html>