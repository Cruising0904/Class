<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<div class="container-view"> 
		<table id="table"  data-height="460"	class="table table-bordered table-hover">
		<thead> 
			<tr> 
				<th colspan="2" class="text-center"><h5 class="form-signin-heading">회사정보수정하기</h5></th>
			</tr>
			<tr>
				<td class="col-md-2">회사이름</td>
				<td class="col-md-4"><input type="text" name="viName" id="viName"></td>
			</tr>
			<tr>
				<td>회사정보</td>
				<td><input type="text" name="viDesc" id="viDesc"></td>
			</tr>
			<tr>
				<td>회사주소</td>
				<td><input type="text" name="viAddress" id="viAddress"></td>
			</tr>
			<tr>
				<td>회사연락처</td>
				<td><input type="text" name="viPhone" id="viPhone"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button id="btnUpdate" class="btn btn-primary" 	type="button">정보수정</button>
					<button id="goList" class="btn" 	type="button">취소</button>
				</td>
			</tr>
		</table>
	</div>
	<!-- /container -->

<script>
	$("#btnUpdate").click(function(){
		var params = {};
		params["command"] = "update";
		params["viName"] = $("#viName").val();
		params["viDesc"] = $("#viDesc").val();
		params["viAddress"] = $("#viAddress").val();
		params["viPhone"] = $("#viPhone").val();
		params["viNum"] = "<%=request.getParameter("viNum")%>";
		movePageWithAjax(params, "/list.goods", callbackInsert);
	})
	
	$(document).ready(function(){
		var params = {};
		params["command"] = "vendorlist";
		movePageWithAjax(params, "/list.vendor", callback);
	})
	
	
	function callback(result){
		var vendorList = result.vendorList;
		var selStr = "<option value=''>회사선택</option>";
		for (var i = 0, max = vendorList.length; i < max; i++) {
			var vendor = vendorList[i];
			selStr += "<option value='" + vendor.viNum + "' >" + vendor.viName
					+ "</option>";
		}
		$("#s_vendor").html(selStr);

		var params = {};
		params["command"] = "view";
		params["giNum"] = "<%=request.getParameter("giNum")%>";
		var page = {}
		page["nowPage"] = "<%=request.getParameter("nowPage")%>";
		params["page"] = page;
		movePageWithAjax(params, "/list.goods", callback2);
	}
	function callback2(result){
		$("#giDesc").val(result.goods.giDesc);
		$("#giName").val(result.goods.giName);
		$("#s_vendor").val(result.goods.viNum);
	}
	$("#goList").click(function(){
		history.back();
	})
</script>
</body>
</html>