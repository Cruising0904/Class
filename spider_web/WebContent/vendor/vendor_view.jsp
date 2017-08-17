<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container-view">
	<table id="table" data-height="460"
		class="table table-bordered table-hover">
		<thead>
			<tr>
				<th colspan="3" class="text-center"><h5
						class="form-signin-heading">회사정보상세 페이지</h5></th>
			</tr>
			<tr>
				<td class="col-md-2">회사번호</td>
				<td class="col-md-4" colspan="2">${vendor.viNum}</td>
			</tr>
			<tr>
				<td>회사이름</td>
				<td colspan="2">${vendor.viName}</td>
			</tr>
			<tr>
				<td>회사설명</td>
				<td colspan="2">${vendor.giDesc}</td>
			</tr>
			<tr>
				<td>회사주소</td>
				<td colspan="2">${vendor.viAddress}</td>
			</tr>
			<tr>
				<td>회사연락처</td>
				<td colspan="2">${vendor.viPhone}</td>
			</tr>
			<tr>
				<td>회사설립시기</td>
				<td colspan="2">${vendor.viCredat}</td>
			</tr>
			
			<tr>
				<td>
					<button id="btnUpdate" class="btn btn-md-2 btn-block" type="button">수정</button>
				</td>
				<td>
					<button id="btnDelete" class="btn btn-md-2 btn-block" type="button">삭제</button>
				</td>
				<td>
					<button id="btnGoList" class="btn btn-md-2 btn-block" type="button">리스트로</button>
				</td>
			</tr>
		</thead>
	</table>
</div>

<script>
$("#btnDelete").click(function(){
	var isDelete = confirm("해당 상품을 삭제 하시겠습니까?");
	if(isDelete){
		var params = {};
		params["viNum"] = "${vendor.viNum}";
		params["command"] = "delete"
		var page = {};
		page["nowPage"] = "${page.nowPage}";
		params["page"] = page;
		movePageWithAjax(params, "/list.vendor", callBackView);
	}
});

function callBackView(result){
	alert(result.msg);
	if(result.url!=""){
		location.href = result.url + "?nowPage=" + result.page.nowPage;
	}
}
$("#btnUpdate").click(function(){
	location.href="/vendor/vendor_update.jsp?nowPage=" + <%=request.getParameter("nowPage")%> + "&viNum=" + <%=request.getParameter("viNum")%>
})
$("#btnGoList").click(function(){
	location.href="/vendor/vendor_list.jsp?nowPage" + <%=request.getParameter("nowPage")%>
})
</script>