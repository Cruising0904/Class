<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>%>
<%@ page import="com.test.common.DBConn2" %>
<%@ page import="com.test.dto.UserInfo" %>
<link rel="stylesheet" href="<%=rootPath%>/ui/signin.css"/>
	<div class="container" >
		<form class="form-signin" action="<%=rootPath%>/user/login_ok.jsp" >
			<h2 class="form-signin-heading"><img src ="/images/Koko.jpg" ><br/>노그인해줘잉</h2>
			<label for="inputEmail" class="sr-only">ID</label> <input type="text"
				id="id" name="id" class="form-control" placeholder="ID를 입력해줘잉" required
				autofocus> <label for="inputPassword" class="sr-only">Password</label>
			<input type="password" name="pwd" id="pwd" class="form-control"
				placeholder="Password를 입력해줘잉" required>
			<div class="checkbox">
				<label> <input type="checkbox" value="remember-me">
					Remember me
				</label>
			</div>
			<button id="btn2" class="text-hide btn btn-lg btn-primary btn-block"
            type="button">Login<img src="/images/login.jpg" width="290" height="70" border="0"class="img-responsive" alt="Responsive image"></button>
		</form>

	</div>
	<!-- /container -->
	<script>
	
	$("button.btn").click(function(){
		var id = $("#id").val();
		var pwd = $("#pwd").val();
		var param = {};
		param["userId"] = id;
		param["userPwd"] = pwd;
		param = JSON.stringify(param);
		var a = { 
		        type     : "POST"
		    	    ,   url      : "/user/login_ok.jsp"
		    	    ,   dataType : "json" 
		    	    ,   beforeSend: function(xhr) {
		    	        xhr.setRequestHeader("Accept", "application/json");
		    	        xhr.setRequestHeader("Content-Type", "application/json");
		    	    }
		    	    ,   data     : param
		    	    ,   success : function(result){
		    	    	alert(result.msg);
		    	    	if(result.login=="ok"){
		    	    		location.href = "<%=rootPath%>/main.jsp";
		    	    	}else{
		    	    		$("#id").val("");
		    	    		$("#pwd").val("");
		    	    	}
		    	    }
		    	    ,   error : function(xhr, status, e) {
		    		    	alert("에러 : "+e);
		    		},
		    		done : function(e) {
		    		}
		    		};
		$.ajax(a);
	});
</script>

</body>
</html>