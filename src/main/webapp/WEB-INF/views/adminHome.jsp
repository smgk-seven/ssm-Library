<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adminHome.jsp' starting page</title>
    

  </head>
  
  <body>
    
    <h1>管理员界面中心</h1>
    
    <h3>
    	welcome ${msg.extend.student.stuName}
    	
    </h3>
  </body>
</html>
