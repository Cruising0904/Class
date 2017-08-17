package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.test.dto.Vendor;
import com.test.service.VendorService;

public class VendorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private VendorService vs = new VendorService();
	private Gson g = new Gson();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		String resultStr = "";
		String params = request.getParameter("param");
		Vendor vendor = g.fromJson(params, Vendor.class);
		String command = vendor.getCommand();
		if(command.equals("view")) {
			Vendor resultView = vs.selectVendor(vendor);
			request.setAttribute("vendor",  resultView);
			request.setAttribute("url",  "/vendor/vendor_view.jsp");
			RequestDispatcher rd =request.getRequestDispatcher("goods/goods_view.jsp"); 
			try {
				rd.forward(request,  response);
			}catch(ServletException e) {
				e.printStackTrace();
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		String command = request.getParameter("command");
		String result = "";
		if (command.equals("list")) {
			String viName = request.getParameter("viName");
			List<Vendor> vendorList = vs.selectVendorsList(viName);
			result = g.toJson(vendorList);
			doProcess(response, result);
		} else if (command.equals("view")) {
			Vendor resultV = vs.selectVendor(vendor);
	    	HashMap resultMap = new HashMap();
	    	resultMap.put("vendor", resultV);
	    	resultMap.put("url", "/vendor/vendor_view.jsp");
	    	String jsonStr = g.toJson(resultMap);
	    	doProcess(response, jsonStr);
		} else if (command.equals("delete")) {
			Vendor vendor = g.fromJson(request.getReader(), Vendor.class);
			int resultRs = vs.deleteVendor(vendor);
	    	HashMap resultMap = new HashMap();
	    	resultMap.put("msg", "삭제가 잘 되었습니다.");
	    	resultMap.put("url", "/vendor/vendor_list.jsp");
	    	if(resultRs!=1){
		    	resultMap.put("msg", "삭제 실패하였습니다.");
		    	resultMap.put("url", "");
	    	}
	    	String jsonStr = g.toJson(resultMap);
	    	doProcess(response, jsonStr);
		} else if (command.equals("insert")) {
		Vendor vendor = g.fromJson(request.getReader(), Vendor.class);
		
	  	HashMap resultMap = new HashMap();
			int resultRs = vs.insertVendors(vendor);
			resultMap.put("msg", "등록이 잘 되었습니다.");
			resultMap.put("url", "/vendor/vendor_list.jsp");
			if(resultRs!=1) {
				resultMap.put("msg", "등록 실패하였습니다.");
				resultMap.put("url", "");
				result = g.toJson(resultMap);
				doProcess(response, result);
			}
		} else if (command.equals("update")) {
		}
		
	}

	public void doProcess(HttpServletResponse response, String writeStr) throws IOException {
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter out = response.getWriter();
		out.print(writeStr);
	}
}
