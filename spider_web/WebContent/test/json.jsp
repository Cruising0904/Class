<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp" %>

	<div class="container">
		<table id="table" data-height="460"
		class="table table-bordered table-hover">
		<thead>
			<tr>
				<th data-field="jtnm" class="text-center">번호</th>
				<th data-field="jttext" class="text-center">내용</th>
			</tr>	
		</thead>
		<tbody id="result_tbody"></tbody>
		</table>
	</div>
출력 : <input type="text" id="select"/><input type="button" id="getSelect" value="불러오기"/>
<div id="result_div" class="container"></div>
<script>
$("#getSelect").click(function(){
	var select = $("#select").val();
	var param = {};
	param["select"]=select;
	param = JSON.stringify(param);
	var a = {
			type	:"POST"
			,	url		: "/test/json_select.jsp"
			,	dataType : "json"
			,	beforeSend : function(xhr) {
				xhr.setRequestHeader("Accept","application/json");
				xhr.setRequestHeader("Content-Type","application/json");
			}
			,	data		:param
			,	success : function(result){
					$('#table').bootstrapTable({
						data: result
					});
			}
			,	error : function(xhr, status, e){
				alert("에러: "+e);
			},
			complete : function(e){
			}
	}
	$.ajax(a);
});

// $("input[id*='json']").click(function(){
// 	var id = this.id;
// 	var idx = id.substring(id.length-1);
// 	var num1 = $("#num"+ idx + "_1").val();
// 	var num2 = $("#num"+ idx + "_2").val();
	
// 	var param = {};
// 	param["num1"] = num1;
// 	param["num2"] = num2;
// 	param["op"] = ops[idx];
// 	param = JSON.stringify(param);
// 	var a = {
// 			type	: "POST"
// 			,	url		:"/test/json_ok.jsp"
// 			,	dataType : "json"
// 			,	beforeSend : function(xhr){
// 				xhr.setRequestHeader("Accept","application/json");
// 				xhr.setRequestHeader("Content-Type", "application/json");
// 			}
// 			,	data	: param
// 			,	success : function(result){
// 				alert(result.insert);
// 				$("#result"+idx).val(result.num);
// 			}
// 			,	error : function(xhr, status, e){
// 					alert("에러 : " +e);
// 			}
// 			};
// 	$.ajax(a);
// })
</script>
</body>
</html>