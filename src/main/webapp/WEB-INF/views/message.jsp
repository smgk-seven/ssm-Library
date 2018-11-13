<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
pageContext.setAttribute("APP_PATH", request.getContextPath());
%>

<!DOCTYPE HTML5">
<html>
  <head>
  
    <base href="<%=basePath%>">
    
    <title>My JSP 'message.jsp' starting page</title>
    <style type="text/css">
    	*{
    		margin:0;
    		padding:0;
    	}
    	.big{
    		
    		width:100%;
    		height:100%;
    		border:1px solid red;
    		 background:url(${APP_PATH}/static/images/suibk.jpg);
    		 background-size: 100% 100%;
    	}
    	.center{
    		width: 600px;
    		height:400px;
    		background-color: rgba(255,255,255,0.2);
    		margin: 150px auto;
    		padding: 12px;
    		background:url(${APP_PATH}/static/images/404bk.jpg);
    		background-size: 100% 100%;
    		filter:alpha(opacity=60);
    		-moz-opacity:0.6;
    		opacity:0.60;
    	}
    	.LoginH2{
    		width: 600px;
    		height: 60px;
    		text-align: center;
    	}
    	.LoginH3{
    		width: 600px;
    		height: 70px;
    		text-align: center;
    		color: red;
    	}
    	.LoginH3_1{
    		width: 600px;
    		height: 70px;
    		text-align: center;
    		
    		margin-top: 120px;
    		transform:rotate(-3deg);
    	}
    	.LoginHcontroll{
    		width: 600px;
    		height: 70px;
    		text-align: center;
    		
    		transform:rotate(-3deg);
    	}
    </style>
	

  </head>
  
  <body>
     	<%-- <img alt="" src="../${APP_PATH}/static/images/banner.jpg"> --%>
     
     <div class="big">
     	<div class="center">
     		<h1 class="LoginH2">
		     	全局消息显示 页面<br>
		     </h1>
		    <h3 class="LoginH3">
		    	【${msg.extend.message}】
		    </h3>
		    <h3 class="LoginH3_1">
		    	--》 你可以有以下的操作《--
		    </h3>
		    <h3 class="LoginHcontroll">
		    	<a href="${APP_PATH}/login.jsp">返回登录界面</a>
		    </h3>
		     
     	</div>
     </div>
  </body>
</html>
