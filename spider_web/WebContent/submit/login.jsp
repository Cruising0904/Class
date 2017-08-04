
<%@ include file="/submit/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.test.common.DBConn2" %>
<%@ page import="com.test.dto.UserInfo" %>
    <link rel="stylesheet" href="/ui/signin.css"/>
<title>프로젝트1</title>
	<div class="container" >
		<form class="form-signin" action="/submit/login_ok.jsp" >
			<h2 class="form-signin-heading"><img src ="/images/Koko.jpg" ><br/>노그인해줘잉</h2>
			<label for="inputEmail" class="sr-only">ID</label> <input type="text"
				id="id" name="id" class="form-control" placeholder="ID를 입력해줘잉" required
				autofocus> <label for="inputPassword" class="sr-only">Password</label>
			<input type="password" name="pwd" id="pwd" class="form-control"
				placeholder="Password를 입력해줘잉" required>
			<div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <a href=url>
        <img src="/images/login.jpg" width="290"  border="0" onclick="imgClick()"/></a>
        
      </form>

    </div> <!-- /container -->



</form> 
</body>
</html>