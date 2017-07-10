package com.test.servlet;

import java.util.HashMap;

public class Exam {

	
	public void printInt(HashMap hm){
		System.out.println(hm.get("name"));
	}
	
	public static void main(String[] args){
		Exam e = new Exam();
		HashMap hm = new HashMap();
		hm.put("name", "박경훈");
		e.printInt(hm);
	}
}
