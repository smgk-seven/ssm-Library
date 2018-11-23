package com.smgk.library.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smgk.library.bean.Lead;
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
	//处理个人用户的信息，全部在这里获取 ，
	@RequestMapping("/getStuAllInfo")
	@ResponseBody
	public Msg getStuAllInfo(@RequestParam(value="STUID" )Integer stuId){
		Student stuAllInfo = studentService.getStuLeadBookByStuId(stuId);
		//System.out.println("登录 的用户id："+stuId);
		if(stuAllInfo==null){
			stuAllInfo = studentService.getStu(stuId);
			System.out.println("这个学生没有借书");
			return Msg.success().add("stuAllInfo", stuAllInfo);
		}
		return Msg.success().add("stuAllInfo",stuAllInfo);
	}
	//跳转到书城
	@RequestMapping("/showBooks")
	public String showBooks(@RequestParam(value="stuId") Integer stuId,@RequestParam(value="StuStatus") String StuStatus, HttpServletRequest request){
		request.getSession().setAttribute("stuId", stuId);
		request.getSession().setAttribute("StuStatus", StuStatus);
		return "bookshop";
	}
	//从书城跳回个人中心
	@RequestMapping("/myselCenter")
	public String goStudentHome(){
		return "studentHome";
	}
	
	
}
