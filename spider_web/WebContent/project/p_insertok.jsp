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
<title>Insert title here</title>
</head>
<%

String biTitle = request.getParameter("bititle");
String biContent = request.getParameter("bicontent");
String creusr = userId;
String biPwd = request.getParameter("bipwd");
	Connection con = null;
	PreparedStatement ps = null;
String result = "저장 안된거 같다?";
int resultNum = 0;
	try{
		con = DBConn2.getCon();
		String sql = "insert into board_info(bititle, bicontent, creusr, bipwd, credat)";
			sql+=	"values(?,?,?,?,now())";
		ps = con.prepareStatement(sql);
		ps.setString(1, biTitle);
		ps.setString(2, biContent);
		ps.setString(3, creusr);
		ps.setString(4, biPwd);
		resultNum = ps.executeUpdate();
		if(resultNum==1){
			result = "입력됨";
			con.commit();
		}
	}catch(Exception e){
		System.out.println(e);
	}finally{
		if(ps!=null){
			ps.close();
			ps = null;
	}
		DBConn2.closeCon();
 }
%>
<script>
	alert("<%=result%>");
	if(<%=resultNum%>==1){
 location.href=rootPath+"/project/board_select.jsp"
	}else{
		history.back();
	}
</script>
<body>

</body>
</html>