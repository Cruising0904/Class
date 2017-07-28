<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판하기</title>
</head>
<script>
    window.onload = function() {
      setInterval(function() {
        var target = document.getElementsByName("dt_now")[0];
        target.value = new Date();
      }, 1000);
    }
</script>
<input type="text" size="43" name="dt_now" value="00"/><br/>

<%

String userId = (String) session.getAttribute("userid");
String userName = "";
int age =  0;
String address =  "";
String hp1 =  "";
String hp2 =  "";
String hp3 =  "";

int a = 1;
System.out.println(a);
boolean login = false;
if(userId!=null){
	userName =  (String) session.getAttribute("username");
	age =  (int) session.getAttribute("age");
	address =  (String) session.getAttribute("address");
	hp1 =  (String) session.getAttribute("hp1");
	hp2 =  (String) session.getAttribute("hp2");
	hp3 =  (String) session.getAttribute("hp3");
	login = true;
}
String rootPath = request.getContextPath();
Date toDate = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
String toDateStr = sdf.format(toDate); 
String init = request.getParameter("init");
String defaultUrl = "";

if(login){
	out.println("접속시간 : " + toDateStr);
	out.println("<br/>");
	out.println(userId + "님 환영해요~");
	out.println("<br/>");
	out.println("==" + userId + "님 의 정보 ==");
	out.println("<br/>");
	out.println("성명 : " + userName);
	out.println("나이 : " + age);
	out.println("<br/>");
	out.println("주소 : " + address);
	out.println("<br/>"); 
	out.println("전화번호 : " + hp1 + hp2 + hp3);
	out.println("<br/>"); 
	out.println("<input type='button' value='로그아웃' onclick='doLogout()'/>");
	out.println("<input type='button' value='메인이동' onclick='doMovePage(\"main\")'/>");
	out.println("<input type='button' value='게시판이동' onclick='doMovePage(\"board\")'/>");
	out.println("<p/>");
	out.println("<br/>");
}
if(init ==null && !login){
	defaultUrl = rootPath +"/project/p_login.jsp?init=1";
	response.sendRedirect(defaultUrl);
}
	 
%>
<script src="<%=rootPath%>/js/jquery-3.2.1.js"></script>
<script>
function doLogout(){
	location.href=rootPath + "/project/p_loginok.jsp";
}
var rootPath ="<%=rootPath%>";

function doMovePage(pageId){
	var url = "";
	if(pageId=="board"){
		url = rootPath + "/project/board_select.jsp";
	}else if(pageId=="main"){
		url = rootPath + "/project/p_main.jsp";
	}else if(pageId=="insert"){
		url = rootPath + "/project/p_insert.jsp";
	}else if(pageId=="select"){
		url = rootPath + "/project/p_select.jsp";
	}
	location.href=url;
}



</script>