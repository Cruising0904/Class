package com.iot.sp.test;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iot.sp.user.service.UserService;
import com.iot.sp.user.service.UserServiceImpl;

//스프링이 읽을수 있도록 어노테이션 골뱅이를 넣어준다~
@Controller
@RequestMapping("/test")
public class TestController {
	
	private static UserService us = new UserServiceImpl();
	@RequestMapping("/t")
	public String list(Model m) {
		m.addAttribute("title", "컨트롤에서 제어하는 타이틀");
		return "test";
	}
	
	@RequestMapping(value = "/test1", method=RequestMethod.POST)
	public @ResponseBody ModelMap postTest(ModelMap map, @RequestBody Map hm) {
		map.put("test",  "test");
		return map;
	}
	
	@RequestMapping(value ="/test1", method=RequestMethod.GET)
	public @ResponseBody ModelMap getTest(ModelMap map, @RequestParam(value="exam")
	String exam){
		System.out.println(exam);
		map.put("test", exam);
		return map;
	}
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model map) {
		return "test/write";
	}
	@RequestMapping("/modify")
	public String modify(HttpServletRequest request, Model map) {
		return "test/modify";
	}
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model map) {
		return "test/delete";
	}
}
