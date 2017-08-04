<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action ="/cal/cal_ok.jsp">
<input type ="text" size="3" id="fNum" name ="fNum"/>+
<input type ="text" size="3" id="sNum" name ="sNum"/>
<input type ="submit" value="더하기"/>
</form><br/>
<form action ="/cal/cal_ok.jsp">
<input type ="text" size="3" id="fNum" name ="fNum"/>-
<input type ="text" size="3" id="sNum" name ="sNum"/>
<input type ="submit" value="빼기"/>
</form><br/>
<form action ="/cal/cal_ok.jsp">
<input type ="text" size="3" id="fNum" name ="fNum"/>/
<input type ="text" size="3" id="sNum" name ="sNum"/>
<input type ="submit" value="나누기"/>
</form><br/>
<form action ="/cal/cal_ok.jsp">
<input type ="text" size="3" id="fNum" name ="fNum"/>*
<input type ="text" size="3" id="sNum" name ="sNum"/>
<input type ="submit" value="곱하기"/>
</form>
</body>
</html>