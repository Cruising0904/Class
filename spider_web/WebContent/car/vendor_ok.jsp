<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*"%>
<%@ page import = "java.util.*"%>
<%@ page import = "com.test.common.DBConn2"%>
<%@ page import = "com.google.gson.*" %>

<% 
Gson g = new Gson();
HashMap<String, String> hm = g.fromJson(request.getReader(),HashMap.class);
String op = hm.get("op");
String cp = hm.get("cp");
Connection con;
PreparedStatement ps=null;
ArrayList<Map<String, String>> vendList = new ArrayList<Map<String,String>>();

try{
	con = DBConn2.getCon();
	String sql = "select vinum,viname,videsc,viaddress,viphone,vicredat,vicretim from vendor_info where 1=1";
	
	
	ps = con.prepareStatement(sql);
	ResultSet rs = ps.executeQuery();
	while(rs.next()){
		Map<String, String> vif = new HashMap<String, String>();
		vif.put("vinum",rs.getString("vinum"));
		vif.put("viname",rs.getString("viname"));
		vif.put("videsc",rs.getString("videsc"));
		vif.put("viaddress",rs.getString("viaddress"));
		vif.put("viphone",rs.getString("viphone"));
		vif.put("vicredat",rs.getString("vicredat"));
		vif.put("vicretim",rs.getString("vicretim"));
		vendList.add(vif);
	}
}catch(Exception e){
	System.out.println(e);
}finally{
	if(ps!=null){
		ps.close();
		ps=null;
	}
	DBConn2.closeCon();
}
String json = g.toJson(vendList);
System.out.println(vendList);
out.print(json);
%>