package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.dto.BoardInfo;
import com.test.service.BoardService;

public class BoardServlet extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req,HttpServletResponse resq) throws IOException,ServletException{
		req.setCharacterEncoding("UTF-8");
		
		BoardService bs = new BoardService();
		BoardInfo bi = new BoardInfo();
		String name = req.getParameter("name");
		String command = req.getParameter("command");
		 int biNum;
		 String biTtitle = req.getParameter("biTtitle");
		 String biContent= req.getParameter("biContent");
		 String biPwd= req.getParameter("biPwd");
		 String creUsr= req.getParameter("creUsr");
		if(command==null){
			return;
		}
		
		if(command.equals("DELETE")){
			int dNum = Integer.parseInt(req.getParameter("d_num"));
			System.out.println("삭제할 번호 :" + dNum);
			bi.setdNum(dNum);
			if(bs.deleteBoard(bi)){
				System.out.println("정상적으로 삭제되었습니다");
				doProcess(resq, "정상적으로 삭제되었습니다");
			}else{
				System.out.println("입력값이 올바르지 않습니다");
				doProcess(resq,"입력값이 올바르지 않습니다");
			}
			
		}else if(command.equals("INSERT")){
			String title = req.getParameter("title"); 
			String content = req.getParameter("content"); 
			String writer = req.getParameter("writer"); 
			System.out.println(title+" "+content+" "+ writer);
			if(bs.insertBoard(bi)){
				System.out.println("정상적으로 입력되었습니다");
				doProcess(resq, "정상적으로 입력되었습니다");
			}else{
				System.out.println("입력값이 올바르지 않습니다");
				doProcess(resq,"입력값이 올바르지 않습니다");
			}
			
			
		}else if(command.equals("UPDATE")){
			if(bs.updateBoard(bi)){
				System.out.println("정상적으로 수정되었습니다");
				doProcess(resq, "정상적으로 수정되었습니다*");
			}else{
				System.out.println("입력값이 올바르지 않습니다");
				doProcess(resq,"입력값이 올바르지 않습니다");
			}
		}else if(command.equals("SELECT")){
			String s_name = req.getParameter("s_name");
		    System.out.println("이름 : "+ s_name);
		    HashMap hm1 = new HashMap();
		    if(name != null && !s_name.equals("")){
		    	hm1.put("name", "%"+s_name+"%");
		    }
		    List<Map> boardList = bs.selectBoard(hm1);
		    String result="<script>";
		    
		    result += "function deleteUser(bNum){";
		    result += "location.href='delete.board?command=DELETE&num=' + bNum;";
			result += "}";
			result += "</script>";
			result += "<form action='/test_web/sign.user'>";
			result += "이름 : <input type='text' name='name' id='name'/> <input type='submit' value='검색'/>";
			result += "<input type='hidden' name='command' value='SELECT'/>";
			result += "</form>";
			result += "<table border='1'>";
			result += "<tr>";
			result += "<td>유저번호</td>";
			result += "<td>유저아이디</td>";
			result += "<td>유저비밀번호</td>";
			result += "<td>유저이름</td>";
			result += "<td>클래스번호</td>";
			result += "<td>삭제버튼</td>";
			result += "</tr>";
			for (Map m1 : boardList) {
				result += "<tr align='center'>";
				result += "<td>" + m1.get("num") + "</td>";
				result += "<td>" + m1.get("title") + "</td>";
				result += "<td>" + m1.get("content") + "</td>";
				result += "<td>" + m1.get("writer") + "</td>";
				result += "<td>" + m1.get("reg_date") + "</td>";
				result += "<td><input type='button' value='삭제' onclick='deleteUser(" + m1.get("num") + ")'/></td>";
				result += "</tr>";
			}
			result += "</table>";
			doProcess(resq, result);
		}

	}

	public void doProcess(HttpServletResponse resq, String writeStr) throws IOException	{
		resq.setContentType("text/html; charset = UTF-8");
		PrintWriter out = resq.getWriter();
		out.print(writeStr);
	}
}
	
