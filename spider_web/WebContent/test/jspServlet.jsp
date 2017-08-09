<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/common/header.jsp" %>

<title></title>
</head>
<body>
<script>
var testParam = {};
testParam["giNum"] = "1";
testParam["giName"] = "상품명";
testParam["giDesc"] = "상품설명";
testParam["viNum"] = "1";
testParam["viName"] = "회사명";
testParam["viList"] = [{str1:"1"},{str2:"2"}];


function callback(results) { 
   
   for(var i=0, max = results.length; i < max; i++) {
      var result = results[i];
      alert(result.giDesc);
   }
}

goPage([testParam,testParam2],"/test.goods", callback); 
</script>
</body>
</html>