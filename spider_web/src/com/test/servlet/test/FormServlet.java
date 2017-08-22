package com.test.servlet.test;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet extends CommonServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html; charset = UTF-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		String result = "입력한 값:" + id;
		result += "<br>비밀번호 :"+pwd;
		doProcess(response, result);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset = UTF-8");
		HashMap<String, String> hm = g.fromJson(request.getReader(), HashMap.class);
		String id = hm.get("id");
		String pwd = hm.get("pwd");
		
		String  result = "id ="+id;
		result += "<br>pwd ="+pwd;
		String jsonS= g.toJson(result);
		System.out.println(result);
		doProcess(response, jsonS);
	}
}
