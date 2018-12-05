package com.smgk.library.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smgk.library.bean.Admin;
import com.smgk.library.bean.Msg;
import com.smgk.library.bean.StuInfo;
import com.smgk.library.bean.Student;
import com.smgk.library.service.AdminService;
import com.smgk.library.service.StudentService;
import com.smgk.library.util.utils;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private AdminService adminService;
	//检查账号是否可用
	@RequestMapping("/checkStuCard")
	@ResponseBody
	public Msg checkStuCard(@RequestParam("stuCard") String stuCard){
		System.out.println("你要查重的名字是："+stuCard);
		String msg=null;
		List<Student> allStus = studentService.getAllStus();
		List<Admin> allAdmin = adminService.getAllAdmin();
		for(Student s:allStus){
			if(s.getStuCard().equals(stuCard)){
				return Msg.fail();
			}
		}
		for(Admin a:allAdmin){
			if(a.getAdminCard().equals(stuCard)){
				System.out.println("些名字与管理员的名有冲突");
				return Msg.fail();
			}
		}
		System.out.println("执行两次for后");
		return Msg.success();
	}
	
	//添加学生
	@RequestMapping(value="/stu",method=RequestMethod.POST)
	@ResponseBody
	public Msg saveStu(Student student){
		System.out.println("新添加的用户："+student);
		student.setStuPwd(utils.md5(student.getStuPwd()));
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
	//获取所有用户显示到表格中
	@RequestMapping("/getStudents")
	@ResponseBody
	public Msg getStudents(@RequestParam(value="pageNum") Integer pageNum){
		int stuCount=0;
		int stuBMD=0;
		int stuHMD=0;
		List<Student> allStus = studentService.getAllStus();
		for(Student s:allStus){
			if(s.getStuStatus().equals("0")){
				stuBMD++;
			}else{
				stuHMD++;
			}
		}
		stuCount=allStus.size();
		//System.out.println("总数"+stuCount+" bmd:"+stuBMD+" hmd:"+stuHMD);
		StuInfo stuinfo=new StuInfo(stuCount, stuBMD, stuHMD);
		PageHelper.startPage(pageNum, 5);
		List<Student> stus = studentService.getAllStus();
		//System.out.println(stuCount);
		PageInfo stuInfo=new PageInfo(stus,3);
		return Msg.success().add("stuInfo", stuInfo).add("stuinfo", stuinfo);
	}
	//处理添加与删除黑名单
	@RequestMapping("/stuStatus")
	@ResponseBody
	public Msg stuStatus(@RequestParam(value="stuId")Integer stuId,@RequestParam(value="stuDemand")String stuDemand){
		Student stu=new Student();
		stu.setStuId(stuId);
		if(stuDemand.equals("移出黑名单")){
			stu.setStuStatus("0");
		}
		if(stuDemand.equals("加入黑名单")){
			stu.setStuStatus("1");
		}
		studentService.updateStuStatus(stu);
		return Msg.success();
	}
	
	
	
	
}
