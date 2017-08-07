<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container">
	<table id="table" data-height="460"
		class="table table-bordered table-hover">
		<thead>
			<tr>
				<th data-field="ginum" class="text-center">상품번호</th>
				<th data-field="giname" class="text-center">상품이름</th>
				<th data-field="gidesc" class="text-center">상품설명</th>
				<th data-field="vinum" class="text-center">생산자번호</th>
				<th data-field="viname" class="text-center">생산자이름</th>
			</tr>
		</thead>
		<tbody id="result_tbody">
		</tbody>
	</table>
</div>
<div class = "jib-center" style = "text-align: center">
	<ul class = "pagination" id = "page">
	</ul>
	</div>
	
<select id="s_vendor">
<option value="">회사선택</option>
</select> 
<input type="text" id="cp" />
<input type="button" id="getInfo" value="검색" />
<div id="result_div" class="container"></div>
<script>
$(document).ready(function(){
	var params = {};
	params["nowPage"] = "12";
	params = JSON.stringify(params);
	var a = { 
    		type     : "POST"
	    ,   url      : "/car/vendor_select.jsp"
	    ,   dataType : "json" 
	    ,   beforeSend: function(xhr) {
	        xhr.setRequestHeader("Accept", "application/json");
	        xhr.setRequestHeader("Content-Type", "application/json");
	    }
	    ,   data     : params
	    ,   success : function(result){
	    	var vendorList = result.vendorList;
	    	var viList = result.viList;
	    	var pageInfo = result.pageInf;

	    	var pageStr = "	<li><a>◀◀</a></li>";
	    	pageStr += "<li><a>◀</a></li>";
	    	var blockCnt = new Number(pageInfo.blockCnt);
	    	var nowPage = new Number(pageInfo.nowPage);
	    	var startBlock = Math.floor((nowPage-1)/blockCnt)*10+1;
	    	var endBlock = startBlock+blockCnt-1;
	    	var totalPageCnt = new Number(pageInfo.totalPageCnt);
	    	if(endBlock>totalPageCnt){
	    		endBlock = totalPageCnt;
	    	}
	    	for(var i =startBlock, max=endBlock;i<=max;i++){
	    		if(i==pageInfo.nowPage){
	    			pageStr += "<li class ='active'><a>"+i+"</a></li>";	
	    		}else{
	    		pageStr += "<li><a>"+i+"</a></li>";
	    		}
	    	}
	    	pageStr += "<li><a>▶</a></li>";
	    	pageStr += "<li><a>▶▶</a></li>";

	    	
	    	$("#page").html(pageStr);
	    	for(var i=0, max=viList.length;i<max;i++){
	    		$("#s_vendor").append("<option value='" + viList[i].vinum + "'>"+viList[i].viname +"</option>")
	    	}
    	        $('#table').bootstrapTable({
    	            data: vendorList 
    	        });
    	            alert("리스트 받기 성공");
	    }
	    ,   error : function(xhr, status, e) {
		    	alert("에러 : "+e);
		},
		complete  : function() {
// 			alert("실패던지 성공이던지 나랑 무슨상관이냐~ 난 실행할란다~");
		}
	};
$.ajax(a);
}); 

// $("#getInfo").click(function(){
// var op = $(s_vendor).val();
// // 	return;
// 	var cp = $("#cp").val();
// 	var param = {};
// 	param["cp"] = cp;
// 	param["op"] = op
// 	param = JSON.stringify(param);
// 	var a = { 
// 	        		type     : "POST"
// 	    	    ,   url      : "/car/vendor_ok.jsp"
// 	    	    ,   dataType : "json" 
// 	    	    ,   beforeSend: function(xhr) {
// 	    	        xhr.setRequestHeader("Accept", "application/json");
// 	    	        xhr.setRequestHeader("Content-Type", "application/json");
// 	    	    }
// 	    	    ,   data     : param
// 	    	    ,   success : function(result){
// 		    	        $('#table').bootstrapTable({
// 		    	            data: result
// 		    	        });
// 	    	    }
// 	    	    ,   error : function(xhr, status, e) {
// 	    		    	alert("에러 : "+e);
// 	    		},
// 	    		complete  : function() {
// // 	    			alert("실패던지 성공이던지 나랑 무슨상관이냐~ 난 실행할란다~");
// 	    		}
// 	    	};
// 	$.ajax(a);
// }); 
$(document).ready(function(){
// 	$(s_vendor).val();
	

	var a = { 
	        type     : "POST"
	    	    ,   url      : "/car/vendor_select.jsp"
	    	    ,   dataType : "json" 
	    	    ,   beforeSend: function(xhr) {
	    	        xhr.setRequestHeader("Accept", "application/json");
	    	        xhr.setRequestHeader("Content-Type", "application/json");
	    	    }
	    	    ,   data     : null
	    	    ,   success : function(result){ 
	    	    	for(var i =0, max =result.length;i<max;i++){
	    	    		var results= result[i];
	    	    		$("#s_vendor").append("<option value='"+results.vinum+"'>"+results.viname+"</option>");
// 	    	    		alert(results.vinum);
// 	    	    		alert(results.viname);
	    	    		
	    	    	}
	    	    	alert("목록받기 성공");
// 	    	    	$("#result" + idx).val(result.num);  
	    	    }
	    	    ,   error : function(xhr, status, e) {
	    		    	alert("에러 : "+e);
	    		},
	    		complete : function(e) {
	    		}
	    		};
	$.ajax(a);
});
</script>
