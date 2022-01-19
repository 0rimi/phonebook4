package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/board")
public class Test {
	
	//필드
	
	//생성자
	
	//메소드 gs	
	
	//메소드
	@RequestMapping(value="/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String TestPrint() {
		System.out.println("/board > list");
		System.out.println("5시 53분의 이 세계는 아름다워");
		
		return "/WEB-INF/views/Test.jsp";
	}
	
	@RequestMapping(value="/writeForm", method=RequestMethod.GET)
	public String TestPrint2() {
		System.out.println("/board > writeForm");
		System.out.println("무저갱의 바닥에서 넌 유1하게 빛나는 별");
		
		return "/WEB-INF/views/Test.jsp";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String TestPrint3() {
		System.out.println("/board > writeForm");
		System.out.println("i say run, 미친듯 크게 웃어줘");
		
		return "/WEB-INF/views/Test.jsp";
	}
	
}
