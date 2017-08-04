<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<body>
<form action="exam01_ok.jsp">
<input type="text" name="id" id="id"/><br/>
<input type="text" name="name" id="name"/><br/>
<input type="text" name="age" id="age"/><br/>
<input type="text" name="address" id="address"/><br/>
<input type="text" name="address2" id="address2"/><br/>
<input type="text" name="hp1" id="hp1"/><br/>
<input type="text" name="hp2" id="hp2"/><br/>
<input type="text" name="hp3" id="hp3"/><br/>
<input type="text" name="zipcode" id="zipcode"/><br/>
<input type="text" name="password" id="password"/><br/>
<input type="button" value="값확인" onclick="doCheckValue()"/>
</form>
<script>

var AjaxUtil = function(p_url, params){
	this.params = params;
	
	getHttpXmlObj = function(){
		if(window.XMLHttpRequest){
	  		return new XMLHttpRequest();
	 	}else if(window.ActiveXObject){
	  		return new ActiveXObject("Microsoft.XMLHTTP");
	 	}
		alert("해당 브라우져가  Ajax를 지원하지 않습니다.");
	}
	this.xhr = getHttpXmlObj();
	var method = "get";
	var url = p_url;
	var aSync = true;
	this.xhr.onreadystatechange=function(){
   		if (this.readyState==4){
   			if(this.status==200){
	   			var result = decodeURIComponent(this.responseText);
	   			document.getElementById("result_div").innerHTML = result;
   			}
   		}
	}
	this.changeCallBack = function(func){
		this.xhr.onreadystatechange = func;
	}
   	this.xhr.open(method, url+this.params, aSync);
   	this.send = function(){
   		this.xhr.send.arguments = this;
   	   	this.xhr.send();
   	}
} 
function doCheckValue(){
	var test1 = document.getElementById("id").value;
	var test2 = document.getElementById("name").value;
	var test3 = document.getElementById("age").value;
	var test4 = document.getElementById("address").value;
	var test5 = document.getElementById("address2").value;
	var test6 = document.getElementById("hp1").value;
	var test7 = document.getElementById("hp2").value;
	var test8 = document.getElementById("hp3").value;
	var test9 = document.getElementById("zipcode").value;
	var test10 = document.getElementById("password").value;
	var params = "?";
// 	for(var i=1;i>=10;i++){
// 		if(i=10){
// 			params+="test[i]"+"="+test[i];
// 		}
// 		params+= "test[i]"+"="+test[i]+"&";
// 	}
 params += "&id="+test1;
 params += "&name="+test2;
 params += "&age="+test3;
 params += "&address="+test4;
 params += "&address2="+test5;
 params += "&hp1="+test6;
 params += "&hp2="+test7;
 params += "&hp3="+test8;
 params += "&zipcode="+test9;
 params += "&password="+test10;
	var au = new AjaxUtil("/test/exam01_ok.jsp", params);
	au.send();
}
</script>
<div id ="result_div"></div>
</body>
</html>