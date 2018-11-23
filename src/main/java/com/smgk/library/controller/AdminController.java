package com.smgk.library.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smgk.library.bean.Msg;

@Controller
public class AdminController {
	
	@RequestMapping("/adminShowBook")
	public String adminShowBook(HttpServletRequest request){
		
		return "bookshop";
	}
	//返回管理员中心
	@RequestMapping("/adminCenter")
	public String adminCenter(){
		return"adminHome";
	}
	
}
