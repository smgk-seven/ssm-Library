package com.smgk.library.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smgk.library.bean.Admin;
import com.smgk.library.bean.Lead;
import com.smgk.library.bean.Msg;
import com.smgk.library.bean.StuLeadInfo;
import com.smgk.library.bean.Student;
import com.smgk.library.service.AdminService;
import com.smgk.library.service.LeadService;
import com.smgk.library.service.StudentService;

@Controller
public class LoginController {
	
	@Autowired
	private AdminService adminService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private LeadService leadService;
	
	@RequestMapping("/LoginServlet")
	public String loginCtrl(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Msg msg=new Msg();
		String message="用户不存在";
		PrintWriter pw=response.getWriter();
		int result=0;
		int stuId=0;
		int stuLeadCou=0;
		
		List<Admin> allAdmin = adminService.getAllAdmin();
		List<Student> allStus = studentService.getAllStus();
		for(Admin admin:allAdmin){
			System.out.println(admin.getAdminCard());
			if(admin.getAdminCard().equals(username)){
				if(!admin.getAdminPwd().equals(password)){
					message="密码错误";
					result=3;
				}
				if(admin.getAdminPwd().equals(password)){
					result=1;
					message="管理员登录 登录 成功";
					msg.add("admin", admin);
				}
			}
		}
		for(Student s:allStus){
			if(s.getStuCard().equals(username)){
				if(!s.getStuPwd().equals(password)){
					message="密码错误";
					result=3;
				}
				if(s.getStuPwd().equals(password)){
					result=2;
					stuId=s.getStuId();
					message="普通用户，登录 成功";
					msg.add("student", s);
				}
			}
		}
		msg.add("result", result).add("message", message);
		Student studentLeadInfo=studentService.getStuLeadBookByStuId(stuId);
		if(studentLeadInfo!=null){
			List<Lead> lends = studentLeadInfo.getLends();
			StuLeadInfo sli=new StuLeadInfo();
			List<StuLeadInfo> slis=new ArrayList();
			
			for(Lead l:lends){
				sli=new StuLeadInfo();
				stuLeadCou++;
				sli.setLeadBookId(l.getLendId());
				sli.setLeadBookName(l.getBook().getBookName());
				sli.setLeadBookPhoto(l.getBook().getBookPhoto());
				sli.setLeadBookStatus(l.getLendStatus());
				sli.setLeadBookTime(l.getLendTime().toLocaleString());
				slis.add(sli);
			}
			msg.add("studentLeadInfo", slis).add("BookCount", stuLeadCou);
		}else{
			msg.add("studentLeadInfo", null).add("BookCount", stuLeadCou);
		}
		request.setAttribute("msg", msg);
		System.out.println(msg);
		if(result==0){
			return"message";
		}
		if(result==3){
			return"message";
		}
		if(result==1){
			
			return"adminHome";
		}
		if(result==2){
			
			return "studentHome";
		}
		return "message";
	}
	@RequestMapping("/exit")
	public void exit(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		session.removeAttribute("user");
		//request.getRequestDispatcher("login.jsp").forward(request,response);
		response.sendRedirect(request.getContextPath());
		return;
	}
	
	
}
