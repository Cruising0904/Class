<%@ include file="/project/p_head.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link rel="stylesheet" href="<%=rootPath%>/ui/signin.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="/main.jsp" flush="false">
	<jsp:param name="login" value="<%=login%>"></jsp:param>
</jsp:include>
    <div class="container">
      <form class="form-signin"  action="<%=rootPath%>/project/p_loginok.jsp">
        <h2 class="form-signin-heading">
        
        Please sign in</h2>
        <label for="inputID" class="sr-only">ID</label>
        <input type="text" id="id" name="id" class="form-control" placeholder="ID" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password"  name="pwd" id="pwd" class="form-control" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>

    </div> <!-- /container -->



</form> 
</body>
</html>