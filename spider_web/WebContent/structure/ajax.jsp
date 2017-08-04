<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
$("#getInfo").click(function(){ // # 뒤에 실행시킬 버튼의 아이디를 적어준다.#은 ID 를 의미함.
var op = $(s_vendor).val();
// 	return;   <== 얘는 함수를 끝내기 위해 넣어줫었음. 
	var cp = $("#cp").val();     // cp의 값을 가져옴.
	var param = {};				// 제이슨에 넣어줄 값을 배열을 넣어줌.선언
	param["cp"] = cp;
	param["op"] = op
	param = JSON.stringify(param);
	var a = { 
	        		type     : "POST"
	    	    ,   url      : "/car/vendor_ok.jsp"
	    	    ,   dataType : "json" 
	    	    ,   beforeSend: function(xhr) {
	    	        xhr.setRequestHeader("Accept", "application/json");
	    	        xhr.setRequestHeader("Content-Type", "application/json");
	    	    }
	    	    ,   data     : param
	    	    ,   success : function(result){
		    	        $('#table').bootstrapTable({
		    	            data: result
		    	        });
	    	    }
	    	    ,   error : function(xhr, status, e) {
	    		    	alert("에러 : "+e);
	    		},
	    		complete  : function() {
// 	    			alert("실패던지 성공이던지 나랑 무슨상관이냐~ 난 실행할란다~");
	    		}
	    	};
	$.ajax(a);
}); 
</script>