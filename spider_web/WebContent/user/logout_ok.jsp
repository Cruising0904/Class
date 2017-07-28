<%@ include file ="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.test.common.DBConn2" %>
<%@ page import="com.test.dto.UserInfo" %>
<%
session.invalidate();
%>
<script>
alert("정상적으로 로그아웃 되셨습니다");
location.href="/user/login.jsp";
</script>
<body>
</body>
</html>