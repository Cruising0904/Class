<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script>
    window.onload = function() {
      setInterval(function() {
        var target = document.getElementsByName("dt_now")[0];
        target.value = new Date();
      }, 1000);
    }
</script>
 
<input type="text" size="32" name="dt_now" value="00"/>
<body>

</body>
</html>