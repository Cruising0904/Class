<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<title>유저 리스트</title>
<body>
환영합니다. 임마.<br>
<input type="button" value="메인으로 이동" data-url="/sp/user/main">
</body>
</head>
<script>
function searchUser(){
	var param = {};
	param["userName"] = $("#userName").val();
	param = JSON.stringify(param);
	var a = { 
	        type     : "POST"
	    	    ,   url      : "${rootPath}/user/list"
	    	    ,   dataType : "json" 
	    	    ,   beforeSend: function(xhr) {
	    	        xhr.setRequestHeader("Accept", "application/json");
	    	        xhr.setRequestHeader("Content-Type", "application/json");
	    	    }
	    	    ,   data     : param
	    	    ,   success : function(result){
	    	    	var userList = result.userList;
	    	    	var resultStr = "";
					$('#table').bootstrapTable('destroy');
	    	    	for(var i=0, max=userList.length;i<max;i++){
	    	    		var user = userList[i];
						resultStr += "<tr data-view='" + user.userNum + "'>";
						resultStr +="<td class='text-center'>" + user.userId + "</td>";
						resultStr +="<td class='text-center'>" + user.userName + "</td>";
						resultStr +="<td class='text-center'>" + user.age + "</td>";
						resultStr +="<td class='text-center'>" + user.gender + "</td>";
						resultStr +="<td class='text-center'>" + user.address + "</td>";
						resultStr +="<td class='text-center'>" + user.hp1 + "-" + user.hp2 +  "-" + user.hp3 + "</td>";
						resultStr +="<td class='text-center'>" + user.departNum + "</td>";
						resultStr +="<td class='text-center'>" + user.userRoleLevel + "</td>";
						resultStr +="</tr>";
	    	    	}
					$('#result_tbody').html(resultStr);
	    	    }
	    	    ,   error : function(xhr, status, e) {
	    		    	alert("에러 : "+e);
	    		},
	    		done : function(e) {
	    		}
	    		};
	$.ajax(a);
}
	$(document).ready(searchUser);
	$(document).ready(function(){
		$("#searchUser").click(function(){
			if($("#userName").val().trim()==""){
				alert("검색할 이름을 입력해주세요.");
				$("#userName").val("");
				$("#userName").focus();
				return;
			}
			searchUser();
		})
	})
	
</script>
<div class="container">
	<table id="table" data-height="460" style="padding-top:20px;"
		class="table table-bordered table-hover">
		<thead>
			<tr>
				<th class="text-center">아이디</th>
				<th class="text-center">이름</th>
				<th class="text-center">나이</th>
				<th class="text-center">성별</th>
				<th class="text-center">주소</th>
				<th class="text-center">전화번호</th>
				<th class="text-center">부서명</th>
				<th class="text-center">권한레벨</th>
			</tr>
		</thead>
		<tbody id="result_tbody">
		</tbody>
	</table>
	<div class="container" style="text-align: center;"> 
		<label>이름 : </label> <input type="text" id="userName" /> 
		<input type="button" id="searchUser" value="검색" />
	<button id="btnInsert" class="btn btn-primary"  type="button">회원등록</button>
	</div>
</div>
</body>
</html>