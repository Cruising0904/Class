<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>

<link rel="stylesheet" href="${rootPath}/resources/ui/signin.css" />
<body>
	<div class="container">
		<form class="form-signin">
			<h2 class="form-signin-heading">Please login</h2>
			<label for="inputEmail" class="sr-only">ID</label> <input type="text"
				id="id" name="id" class="form-control" placeholder="ID" required
				autofocus> <label for="inputPassword" class="sr-only">Password</label>
			<input type="password" name="pwd" id="pwd" class="form-control"
				placeholder="Password" required>
			<div class="checkbox">
				<label> <input type="checkbox" value="remember-me">
					Remember me
				</label>
			</div>
			<button id="btn2" class="btn btn-lg btn-primary btn-block"
				type="button">Login</button>
		</form>

	</div>
	<!-- /container -->
	<script>
	$("#btn2").click(function(){
		var id = $("#id").val();
		var pwd = $("#pwd").val();
		var param = {};
		param["userId"] = id;
		param["userPwd"] = pwd;
		param = JSON.stringify(param);
		var a = { 
		        type     : "POST"
		    	    ,   url      : "${rootPath}/user/login"
		    	    ,   dataType : "json" 
		    	    ,   beforeSend: function(xhr) {
		    	        xhr.setRequestHeader("Accept", "application/json");
		    	        xhr.setRequestHeader("Content-Type", "application/json");
		    	    }
		    	    ,   data     : param
		    	    ,   success : function(result){
		    	    	alert(result.msg);
		    	    	if(result.data=="S"){
		    	    		location.href = "${rootPath}/user/main";
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