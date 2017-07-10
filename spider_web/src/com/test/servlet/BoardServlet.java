package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.service.BoardService;

public class BoardServlet extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req,HttpServletResponse resq) throws IOException,ServletException{
		req.setCharacterEncoding("UTF-8");
		
		String name = req.getParameter("name");
		String command = req.getParameter("command");
		BoardService bs = new BoardService();
		HashMap hm;
		
		if(command==null){
			return;
		}
		
		if(command.equals("DELETE")){
			hm = new HashMap();
			String dNum = req.getParameter("d_num");
			System.out.println("삭제할 번호 :" + dNum);
			hm.put("dNum", dNum);
			if(bs.deleteBoard(hm)){
				System.out.println("정상적으로 삭제되었습니다");
				doProcess(resq, "정상적으로 삭제되었습니다*");
			}else{
				System.out.println("입력값이 올바르지 않습니다");
				doProcess(resq,"입력값이 올바르지 않습니다");
			}
			
		}else if(command.equals("INSERT")){
			hm = new HashMap();
			String title = req.getParameter("title"); 
			String content = req.getParameter("content"); 
			String writer = req.getParameter("writer"); 
			System.out.println(title+" "+content+" "+ writer);
			hm.put("title", title);
			hm.put("content", content);
			hm.put("writer", writer);
			if(bs.insertBoard(hm)){
				System.out.println("정상적으로 입력되었습니다");
				doProcess(resq, "정상적으로 입력되었습니다*");
			}else{
				System.out.println("입력값이 올바르지 않습니다");
				doProcess(resq,"입력값이 올바르지 않습니다");
			}
			
			
		}else if(command.equals("UPDATE")){
			hm = new HashMap();
			String bNum=req.getParameter("board_num");
			String title=req.getParameter("title");
			String content=req.getParameter("content");
			String writer=req.getParameter("writer");
			System.out.println(bNum+" "+title+" "+content+" "+writer);
			hm.put("board_num", bNum);
			hm.put("title", title);
			hm.put("content", content);
			hm.put("writer", writer);
			if(bs.insertBoard(hm)){
				System.out.println("정상적으로 수정되었습니다");
				doProcess(resq, "정상적으로 수정되었습니다*");
			}else{
				System.out.println("입력값이 올바르지 않습니다");
				doProcess(resq,"입력값이 올바르지 않습니다");
			}
		}else if(command.equals("SELECT"));
			hm = new HashMap();
			String bNum=req.getParameter("board_num");
			System.out.println(bNum);
			hm.put("bNum", bNum);
			if(bs.insertBoard(hm)){
				System.out.println("정상적으로 출력되었습니다");
				doProcess(resq, "정상적으로 출력되었습니다*");
			}else{
				System.out.println("입력값이 올바르지 않습니다");
				doProcess(resq,"입력값이 올바르지 않습니다");
			}
	}
	public void doProcess(HttpServletResponse resq, String writeStr) throws IOException	{
		resq.setContentType("text/html; charset = UTF-8");
		PrintWriter out = resq.getWriter();
		out.print(writeStr);
	}
}
	
