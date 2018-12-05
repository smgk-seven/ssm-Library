<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
pageContext.setAttribute("APP_PATH", request.getContextPath());
session.setAttribute("stuId", request.getSession().getAttribute("stuId"));
%>
<!DOCTYPE HTML5">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>smgk图书馆中心</title>
    <link href="../${APP_PATH }/static/css/font-awesome.min.css" rel="stylesheet"/>
    <link href="${APP_PATH }/static/css/studentHomeCss.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
    <link href="../${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>
	<style type="text/css">
		
	</style>
  </head>
  
  <body>
  	<input type="hidden" value="${sessionScope.stuId}" id="STUID">
  	<input type="hidden" value="${APP_PATH}" id="APP_PATH">
  	
    <div class="big">
    	<div class="left">
    		<div class="left_top">
    			
    		</div>
    		<div class="left_bottom">
    			<ul>
    				<li><a href="#" class="stuDaoHang">个人资料</a></li>
    				<li><a href="#" class="stuDaoHang" id="showBooks">进入书城</a></li>
    				<li><a href="#" class="stuDaoHang">借书记录</a></li>
    				<li><a href="#" class="stuDaoHang">我的信用</a></li>
    				<li><a href="#" class="stuDaoHang">借到的书</a></li>
    				<li><a href="#" class="stuDaoHang">待还的书</a></li>
    				
    			</ul>
    		</div>
    	</div>
    	<div class="right">
    		<!-- 右一 -->
    		<div class="right_info">
    			<div class="info">
    				<i style="font-size:24px" class="fa">&#xf224;</i>
    				<span>user System center</span>
    			</div>
    			<div class="name">
    				
    				<span>welcome：</span>&nbsp;&nbsp;
    				<i class="fa fa-id-card-o" aria-hidden="true"></i>
    				<span>${sessionScope.stuId}</span>
    				<a href="${APP_PATH }/exit" style="color: red;">退出</a>
    				
    			</div>
    		</div>
    		<!-- 右二 -->
    		<div class="right_base_info">
    			<ul>
    				<li><span class="leadBookCount"></span><br>Borrowed</li>
    				<li><span class="leadBookCount"></span><br>Book&nbsp;Count</li>
    				<li><span class="yiHuan"></span><br>be&nbsp;fond&nbsp;of </li>
    				<li><span class="daiHuan"></span><br>Book&nbsp;Count</li>
    			</ul>
    		</div>
    		
    		<!-- 右三 -->
    		<div class="right_user_info">
    			<table class="table">
					<caption>用户信息</caption>
				   <thead>
				      <tr>
				         <th>Id</th>
				         <th>姓名</th>
				         <th>性别</th>
				         <th>邮箱</th>
				         <th>状态</th>
				      </tr>
				   </thead>
				   <tbody id="stu_Info_tbody">
				   </tbody>
				</table>
    		</div>
    		<!-- 右四 -->
    		<div class="right_user_BorrBook">
    			<table class="table">
					<caption>借书记录</caption>
				   <thead>
				      <tr>
				         <th>订单编号</th>
				         <th>书名</th>
				         <th>借书时间</th>
				         <th>借书状态</th>
				         <th>---</th>
				      </tr>
				   </thead>
				   <tbody id="stu_BorrBook_tbody">
				   </tbody>
				</table>
    		</div>
    		<!-- 学生借书记录分页信息 -->
    		<div class="lendBookFYDiv">
    			<div class="LBFYInfo"></div>
    			<div class="LBFYIT"></div>
    		</div>
    	</div>
    </div>
    
  </body>
  <script type="text/javascript" src="${APP_PATH }/static/js/studentHome.js"></script>
  <script type="text/javascript">
  var PATH=$("#APP_PATH").attr("value");
	  	
  </script>
</html>
