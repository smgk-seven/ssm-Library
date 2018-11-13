package com.smgk.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smgk.library.bean.Msg;
import com.smgk.library.bean.Student;
import com.smgk.library.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	
	//检查账号是否可用
	@RequestMapping("/checkstuCard")
	@ResponseBody
	public Msg checkStuCard(@PathVariable("stuCard") String stuCard){
		System.out.println("你要查重的名字是："+stuCard);
		String msg=null;
		List<Student> allStus = studentService.getAllStus();
		for(Student s:allStus){
			if(s.getStuCard().equals(stuCard)){
				return Msg.fail();
			}
		}
		return Msg.success();
	}
	
	//添加学生
	@RequestMapping(value="/stu",method=RequestMethod.POST)
	@ResponseBody
	public Msg saveStu(Student student){
		System.out.println("新添加的用户："+student);
		studentService.addStu(student);
		return Msg.success();
	}
	
}
