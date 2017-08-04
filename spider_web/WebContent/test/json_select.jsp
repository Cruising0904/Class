<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>    
<%@ page import="com.test.common.DBConn2" %>    
<%@ page import="com.google.gson.*" %>    
<%@ page import="java.util.*" %>    

<%
	Gson g = new Gson();
	HashMap<String, String> hm = g.fromJson(request.getReader(), HashMap.class);
	String jason = "";
	if(hm!=null){
		jason= hm.get("jason");
	}
	Connection con = null;
	PreparedStatement ps = null;
	ArrayList<Map<String, String>> jsonList = new ArrayList<Map<String, String>>();
	try{
		con = DBConn2.getCon();
		String sql = "select jtnum,jttext from json_test where 1=1";
		
//  		if(jason!=null && !jason.equals("")){
// 			sql += " and jason = ?";
//  		}
 		ps = con.prepareStatement(sql);
//  		if(jason!=null && !jason.equals("")){
//  			ps.setString(1,jason);
//  		}
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Map<String, String>rhm = new HashMap<String, String>();
			rhm.put("jtnum", rs.getString("jtnum"));
			rhm.put("jttext", rs.getString("jttext"));
			jsonList.add(rhm);
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
	
String json = g.toJson(jsonList);
System.out.println(json);
out.print(json);
%>    
