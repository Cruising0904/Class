<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*"%>
<%@ page import = "java.util.*"%>
<%@ page import = "com.test.common.DBConn2"%>
<%@ page import = "com.google.gson.*" %>
<body>
<form>
<input type ="text" id = "vinum" name="vinum"/>
<input type ="button" id = "btn" value="회사번호로 검색"/><br/>
Index VINUM =1 기아 자동차 2 현대자동차
</form>
</body>
<script>

</script>
<% 
Connection con;
PreparedStatement ps=null;
String table ="";
try{
	con = DBConn2.getCon();
	String sql = "select vinum,viname,videsc,viaddress,viphone,vicredat,vicretim from vendor_info where 1=1";
	ps = con.prepareStatement(sql);
	ResultSet rs = ps.executeQuery();
	table = "<table border='1'>";
	table = "<thead>";
	table = "<table border='1'>";
	table = "<table border='1'>";
	while(rs.next()){
		table += "<tr>";
		table += "<td>"+rs.getString("vinum")+"</td>";
		table += "<td>"+rs.getString("viname")+"</td>";
		table += "<td>"+rs.getString("videsc")+"</td>";
		table += "<td>"+rs.getString("viaddress")+"</td>";
		table += "<td>"+rs.getString("viphone")+"</td>";
		table += "<td>"+rs.getString("vicredat")+"</td>";
		table += "<td>"+rs.getString("vicretim")+"</td>";
		table += "</tr>";
	}
	table += "</table>";
}catch(Exception e){
	System.out.println(e);
}finally{
	if(ps!=null){
		ps.close();
		ps=null;
	}
	DBConn2.closeCon();
}
System.out.println(table);

// String json = g.toJson(vendList);
out.print(table);
%>