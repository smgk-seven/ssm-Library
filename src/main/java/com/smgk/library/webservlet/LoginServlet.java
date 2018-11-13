package com.smgk.library.webservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.smgk.library.bean.Admin;
import com.smgk.library.bean.Msg;
import com.smgk.library.bean.Student;
import com.smgk.library.service.AdminService;
import com.smgk.library.service.StudentService;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private AdminService adminService;
	@Autowired
	private StudentService studentService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Msg msg=new Msg();
		
		String message="用户不存在";
		PrintWriter pw=response.getWriter();
		int result=0;
		List<Admin> allAdmin = adminService.getAllAdmin();
		System.out.println(allAdmin);
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
					message="普通用户，登录 成功";
					msg.add("student", s);
				}
			}
		}
		System.out.println();
		System.out.println(message);
		System.out.println(result);
		msg.add("result", result).add("message", message);
		request.setAttribute("msg", msg);
		if(result==0){
			pw.print("用户不存在，【3】秒后跳回登录 页面"+"<meta http-equiv='refresh' content='3;url="+request.getContextPath()+"/login.jsp' />");
			return;
		}
		if(result==3){
			pw.print("密码错误  【3】  秒后跳回登录 页面"+"<meta http-equiv='refresh' content='3;url="+request.getContextPath()+"/login.jsp' />");
			return;
		}
		if(result==1){
			request.getRequestDispatcher("/WEB-INF/views/adminHome.jsp").forward(request, response);
			return;
		}
		if(result==3){
			request.getRequestDispatcher("/WEB-INF/views/studentHome.jsp").forward(request, response);
			return;
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
