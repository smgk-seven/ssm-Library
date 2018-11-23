package com.smgk.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smgk.library.bean.Lead;
import com.smgk.library.bean.Msg;
import com.smgk.library.service.LeadService;

@Controller
public class LeadController {
	@Autowired
	private LeadService leadService;
	
	
	//还书
	@RequestMapping("/returnBook/{leadBookId}")
	@ResponseBody
	public Msg returnBook(@PathVariable("leadBookId") Integer leadBookId){
		String lendStatus="1";
		System.out.println("还书  id 是"+leadBookId);
		leadService.returnBook(leadBookId,lendStatus);
		return Msg.success();
	}
	//借书
	@RequestMapping("/jieShu")
	@ResponseBody
	public Msg jieShu(@RequestParam(value="bookId") Integer bookId,@RequestParam(value="stuId") Integer stuId,@RequestParam(value="stuStatus") String stuStatus){
		//System.out.println("stuid:"+stuId+" bookId:"+bookId+" stuStatus:"+stuStatus);
		if(stuStatus.equals("1")){
			return Msg.fail().add("message", "你的信用度底，不能借书");
		}
		leadService.jieShu(stuId,bookId);
		return Msg.success();
	}
	
	
	
}
