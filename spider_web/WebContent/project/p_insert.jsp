<%@ include file="/project/p_head.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <script>
 function docheck(){
	 var title = document.getElementById("bititle");
	 var pwd = document.getElementById("bipwd");
	 var content = document.getElementById("bicontent");
 	 var url = "rootPath+/project/p_insertok.jsp?";
	 if(title.value.trim()==""){
		 alert("제목은 입력 되어야합니다");
		bititle.focus(); 
		
	 }else if(pwd.value.trim()==""){
	 alert("비밀번호가 입력 되어야합니다");
		bipwd.focus(); 
		
	 }else if(content.value.trim()==""){
		 if(confirm("내용없이 작성을 진행하겠습니까?")==true){
			 
		 }else{
			 alert("그럼 빨리 내용 입력해!!")
			 return;
		 }
 }else{
	 location.href=url+"bititle=title&bipwd=pwd&bicontent=content";
 }
 }
 </script>
    
<body>
제목 : <input type="text" name="bititle" id="bititle"/><br/>
내용 : <textarea name="bicontent" id="bicontent"></textarea><br/>
글쓴이 : <input type="text" name="creusr"  id="creusr" disabled value="<%=userId%>"/><br/>
비밀번호 : <input type="password" name="bipwd" id="bipwd" /><br/>
<input type="button" value="글쓰기" onclick ="docheck()"/>
</body>
</html>