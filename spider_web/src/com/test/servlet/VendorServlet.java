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
import com.test.dto.Goods;
import com.test.dto.Vendor;
import com.test.service.VendorService;

public class VendorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private VendorService vs = new VendorService();
	private Gson g = new Gson();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		Vendor vendor = g.fromJson(request.getReader(), Vendor.class);
		String command = vendor.getCommand();
		String result = "";
		if (command.equals("list")) {
			List<Vendor> vendorList = vs.selectVendor(vendor);
			HashMap hm = new HashMap();
			hm.put("vendor", vendorList);
			String json = g.toJson(hm);
			doProcess(response, json);
			
		} else if (command.equals("view")) {// view는 번호만 있으면 된다궁??
			Vendor vendorView = vs.vendorView(vendor);
			HashMap hm = new HashMap();
			hm.put("url", "/vendor/vendor_view.jsp");
			hm.put("view", vendorView);
			String json = g.toJson(hm);
			doProcess(response, json);
		} else if (command.equals("delete")) {
			System.out.println(command);
			int resnum = vs.deleteVendor(vendor);
			HashMap hm = new HashMap();
			if(resnum !=0) {
				hm.put("msg", "실패하였습니다.");
			}
			hm.put("msg", "삭제되었습니다.");
			
			
			String json = g.toJson(hm);
			doProcess(response, json);
			
		} else if (command.equals("insert")) {
			int resnum = vs.insertVendors(vendor);
			HashMap hm = new HashMap();
			if(resnum !=0) {
				hm.put("msg", "실패하였습니다.");
				hm.put("url", "");
			}
			hm.put("msg", "생성되었습니다.");
			hm.put("url", "/vendor/vendor_list.jsp");
			
			
			String json = g.toJson(hm);
			doProcess(response, json);
			
//			System.out.println("command="+command+" "+"viNum="+vendor.getViNum());
//			System.out.println("viName="+vendor.getViName());
//			System.out.println("viAddress="+vendor.getViAddress());
//			System.out.println("viDesc="+vendor.getViDesc());
//			System.out.println("viPhone="+vendor.getViPhone());
//			System.out.println(resnum);
//			System.out.println("hm");
		} else if (command.equals("update")) {
			int resnum = vs.updateVendor(vendor);
			HashMap hm = new HashMap();
			if(resnum !=0) {
				hm.put("msg", "실패하였습니다.");
				hm.put("url", "");
			}
			hm.put("msg", "수정되었습니다.");
			hm.put("url", "/vendor/vendor_list.jsp");
		}
	}

	public void doProcess(HttpServletResponse response, String writeStr) throws IOException {
		response.setContentType("text/html; charset = UTF-8");
		PrintWriter out = response.getWriter();
		out.print(writeStr);
	}
}
