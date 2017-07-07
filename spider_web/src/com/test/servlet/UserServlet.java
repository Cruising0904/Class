package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.service.UserService;

public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resq) throws IOException, ServletException{		
		req.setCharacterEncoding("UTF-8");
		
		String name1 = req.getParameter("name");
		String pwd1 = req.getParameter("pass");
		System.out.println("input html에서 너님이 던진값 ->"+name1+pwd1);
		//html 화면에서 던진 값을 각각 String 변수로 받기 시작
		String command = req.getParameter("command");
		if(command==null){
			return;
		}
		UserService us = new UserService();
		//UserService에 있는 insertUser(HashMap hm)이라는 함수를 호출하기 위해
		//UserService로 us 레퍼런스 변수를 생성
		HashMap hm;
		
		
		if(command.equals("SIGNIN")){
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			String name = req.getParameter("name");
			String class_num = req.getParameter("class_num");
			String age = req.getParameter("age");
		//위에서 받은 String 변수를 출력해줌(Tomcat 콘솔창에)
		System.out.println(id + "," + pwd + "," + name + "," + class_num + ", " + age);
		
		//해쉬맵 생성
		hm = new HashMap();
		//html 화면에서 던진 id값을 "id"라는 키로 해쉬맵에 저장
		hm.put("id", id);
		//html 화면에서 던진 pwd값을 "pwd"라는 키로 해쉬맵에 저장
		hm.put("pwd", pwd);
		//html 화면에서 던진 name값을 "name"라는 키로 해쉬맵에 저장
		hm.put("name", name);
		//html 화면에서 던진 class_num값을 "class_num"라는 키로 해쉬맵에 저장
		hm.put("class_num", class_num);
		//html 화면에서 던진 age값을 "age"라는 키로 해쉬맵에 저장
		hm.put("age", age);
		
		
		//위에서 생성한 us레퍼런스 변수를 사용해 insertUser함수를 호출하는데 파라메터값은
		//위에서 생성하고 값을 저장한 HashMap인 hm 레퍼런스 변수를 같이 던짐.
		if(us.insertUser(hm)){
			System.out.println("저장 잘 되었군");
			doProcess(resq, "저장 잘 되었군");
		}else{
			System.out.println("값 똑바로 입력하쇼");
			doProcess(resq,"값 똑바로 입력하쇼");
		}
	}else if(command.equals("DELETE")){
		
	
		hm = new HashMap();
		String user_num = req.getParameter("user_num");
		System.out.println("삭제할 번호 : " + user_num);
		hm.put("user_num", user_num);
		if(us.deleteUser(hm)){
			System.out.println("삭제되었군");
			doProcess(resq, "삭제되었군");
		}else{
			System.out.println("값 똑바로 입력하쇼");
			doProcess(resq,"값 똑바로 입력하쇼");
		}
	}else if(command.equals("UPDATE")){
		
	
		hm = new HashMap();
		String user_num = req.getParameter("user_num");
		String name = req.getParameter("name");
		String class_num = req.getParameter("class_num");
		String age = req.getParameter("age");
		System.out.println(user_num + "," + name + "," + class_num + "," +  age);
		hm.put("user_num", user_num);
		hm.put("name", name);
		hm.put("class_num", class_num);
		hm.put("age", age);
		if(us.updateUser(hm)){
			System.out.println("수정되었군");
			doProcess(resq, "수정되었군");
		}else{
			System.out.println("값 똑바로 입력하쇼");
			doProcess(resq,"값 똑바로 입력하쇼");
		}
		}else if(command.equals("SELECT")){
			
			
			hm = new HashMap();
			String user_name = req.getParameter("user_name");
			System.out.println("불러올 이름"+user_name);
			
			hm.put("user_name", user_name);
			if(us.updateUser(hm)){
				System.out.println("성공적으로 불러왔습니다.");
				doProcess(resq, "성공적으로 불러왔습니다.");
			}else{
				System.out.println("등록된 이름만 가능합니다.");
				doProcess(resq,"등록된 이름만 가능합니다.");
			}
			}
		}
	public void dePost(HttpServletRequest req, HttpServletResponse reqs) throws IOException {

	}

	public void doProcess(HttpServletResponse resq, String writeStr) throws IOException {
		resq.setContentType("text/html; charset = UTF-8");
		PrintWriter out = resq.getWriter();
		out.print(writeStr);

	}
}