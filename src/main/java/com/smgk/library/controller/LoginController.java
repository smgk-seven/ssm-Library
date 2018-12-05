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
import com.smgk.library.util.utils;

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
		String message="用户不存在";
		Integer adminId=0;
		int result=0;
		int stuId=0;
		List<Admin> allAdmin = adminService.getAllAdmin();
		List<Student> allStus = studentService.getAllStus();
		for(Admin admin:allAdmin){
			//System.out.println(admin.getAdminCard());
			if(admin.getAdminCard().equals(username)){
				if(!admin.getAdminPwd().equals(password)){
					message="密码错误";
					result=3;
				}
				if(admin.getAdminPwd().equals(password)){
					result=1;
					adminId=admin.getAdminId();
					request.getSession().setAttribute("adminId", adminId);
					message="管理员登录 登录 成功";
				}
			}
		}
		for(Student s:allStus){
			if(s.getStuCard().equals(username)){
				if(!s.getStuPwd().equals(password)){
					message="密码错误";
					result=3;
				}
				if(s.getStuPwd().equals(utils.md5(password))){
					result=2;
					stuId=s.getStuId();
					request.getSession().setAttribute("stuId", stuId);
					message="普通用户，登录 成功";
				}
			}
		}
		if(result==0){
			request.setAttribute("message", "用户不存在");
			return"message";
		}
		if(result==3){
			request.setAttribute("message", "密码错误");
			return"message";
		}
		if(result==1){
			
			return"adminHome";
		}
		if(result==2){
			request.getSession().setAttribute("stuId", stuId);
			return "studentHome";
		}
		return "message";
		
	}
	
	@RequestMapping("/exit")
	public void exit(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		request.getSession().removeAttribute("user");
		request.getSession().removeAttribute("adminId");
		request.getSession().removeAttribute("stuId");
		//request.getRequestDispatcher("login.jsp").forward(request,response);
		response.sendRedirect(request.getContextPath());
		return;
	}
	
	
}
