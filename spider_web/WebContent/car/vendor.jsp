<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container">
	<table id="table" data-height="460"
		class="table table-bordered table-hover">
		<thead>
			<tr>
				<th data-field="vinum" class="text-center">기업번호</th>
				<th data-field="viname" class="text-center">기업이름</th>
				<th data-field="videsc" class="text-center">기업정보</th>
				<th data-field="viaddress" class="text-center">업체주소</th>
				<th data-field="viphone" class="text-center">전화번호</th>
				<th data-field="vicredat" class="text-center">설립일</th>
				<th data-field="vicretim" class="text-center">시간</th>
			</tr>
		</thead>
		<tbody id="result_tbody">
		</tbody>
	</table>
</div>
<select id="s_vendor">
<option value="">회사선택</option>
</select> 
<input type="text" id="cp" />
<input type="button" id="getInfo" value="검색" />
<div id="result_div" class="container"></div>
<script>

$("#getInfo").click(function(){
	var cp = $("#cp").val();
	var param = {};
	param["cp"] = cp;
	param = JSON.stringify(param);
	var a = { 
	        		type     : "POST"
	    	    ,   url      : "/car/vendor_ok.jsp"
	    	    ,   dataType : "json" 
	    	    ,   beforeSend: function(xhr) {
	    	        xhr.setRequestHeader("Accept", "application/json");
	    	        xhr.setRequestHeader("Content-Type", "application/json");
	    	    }
	    	    ,   data     : null
	    	    ,   success : function(result){
		    	        $('#table').bootstrapTable({
		    	            data: result
		    	        });
	    	    }
	    	    ,   error : function(xhr, status, e) {
	    		    	alert("에러 : "+e);
	    		},
	    		complete  : function() {
	    			alert("실패던지 성공이던지 나랑 무슨상관이냐~ 난 실행할란다~");
	    		}
	    	};
	$.ajax(a);
}); 
$(document).ready(function(){

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
	    	    		alert(results.vinum);
	    	    		alert(results.viname);
	    	    		
	    	    	}
	    	    	alert("성공");
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
