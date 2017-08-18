<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
<div class="container">
	<div class="container" style="text-align: center; padding-top: 20px;padding-bottom: 20px;"> 
		<label>회사이름 : </label> <input type="text" id="viName" /> 
		<input type="button" id="searchVendor" value="검색" />
	</div>
	<table id="table" data-height="460"
		class="table table-bordered table-hover">
		<thead>
			<tr>
				<th data-field="viNum" class="text-center">회사번호</th>
				<th data-field="viName" class="text-center">회사이름</th>
				<th data-field="viDesc" class="text-center">회사설명</th>
				<th data-field="viAddress" class="text-center">회사주소</th>
				<th data-field="viPhone" class="text-center">회사전화번호</th>
			</tr>
		</thead>
		<tbody id="result_tbody">
		</tbody>
	</table>
	<button id="btnInsert" class="btn btn-primary"  type="button">회사등록</button>
</div>
<script>
$(document).ready(function(){
	var params = {};
	params["command"] = "list";
	movePageWithAjax(params, "/list.vendor", callBack);
});

$("#btnInsert").click(function(){
	location.href="/vendor/vendor_insert.jsp"
});

function callBack(result) {
	var vendorList = result.vendor;
	var resultStr = "";
	for(var i=0, max=vendorList.length;i<max;i++){
		var vendor = vendorList[i];
		resultStr += "<tr data-view='" + vendor.viNum + "'>";
		resultStr +="<td class='text-center'>" + vendor.viNum + "</td>";
		resultStr +="<td class='text-center'>" + vendor.viName + "</td>";
		resultStr +="<td class='text-center'>" + vendor.viDesc + "</td>";
		resultStr +="<td class='text-center'>" + vendor.viAddress + "</td>";
		resultStr +="<td class='text-center'>" + vendor.viPhone + "</td>";
		resultStr +="</tr>";
	}
	$("#result_tbody").html(resultStr);
	$("tbody[id='result_tbody']>tr[data-view]").click(function(){
		var params = {};
		params["viNum"] = this.getAttribute("data-view");
		params["command"] = "view";
		movePageWithAjax(params, "/list.vendor", callBackView);
	});	
}
function callBackView(result) {
	var url = result.url + "?viNum=" +result.view.viNum+ "&viName=" +result.view.viName 
		+ "&viDesc=" +result.view.viDesc+ "&viAddress=" +result.view.viAddress+ "&viPhone=" +result.view.viPhone;
	location.href=url;
}	
</script>
</body>
</html>