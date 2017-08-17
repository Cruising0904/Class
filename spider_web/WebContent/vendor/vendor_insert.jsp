<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/common/header.jsp" %>

<title>회사정보등록</title>
	<div class = "container" style="text-align: center; padding-top: 20px;padding-bottom: 20px;">
	<table id="table" data-height="460"
		class="table table-bordered table-hover">
	<thead>
		<tr>
			<th colspan="2" class="text-center"><h5
						class="form-signin-heading">회사 등록 페이지</h5></th>	
		</tr>
		<tr>
			<td class="col-md-2">회사 이름</td>
			<td class="col-md-4"><input type="text" name="viName" id="viName"></td>
		</tr>
		<tr>
			<td>회사 정보</td>
			<td><input type="text" name="viDesc" id="viDesc"></td>
		</tr>
		<tr>
			<td>회사 주소</td>
			<td><input type="text" name="viAddress" id="viAddress"></td>
		</tr>
		<tr>
			<td>회사 연락처</td>
			<td><input type="text" name="viPhone" id="viPhone"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button id="btnInsert" class="btn btn-primary" type ="button">상품등록</button>
			<button id="btnCancel" class="btn" type ="button">취소</button>
				</td>
		</tr>	
		</thead>
		</table>
</div>
<script>
$("#btnInsert").click(function(){
	var params = {};
	params["command"]="insert";
	params["viName"]=$("#viName").val().trim();
	params["viDesc"]=$("#viDesc").val().trim();
	params["viAddress"]=$("#viAddress").val().trim();
	params["viPhone"]=$("#viPhone").val().trim();
	movePageWithAjax(params, "/list.vendor", callbackInsert);
})

$("#btnCancel").click(function(){
	history.back();
})
function callbackInsert(result){
	alert("1");
	location.href = result.url;
	}
</script>