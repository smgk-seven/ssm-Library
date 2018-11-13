<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
pageContext.setAttribute("APP_PATH", request.getContextPath());

%>

<!DOCTYPE HTML5">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>smgk图书馆中心</title>
    <link href="../${APP_PATH }/static/css/font-awesome.min.css" rel="stylesheet"/>
    <link href="../${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
     
	<style type="text/css">
		*{
			padding:0;
			margin:0;
		}
		.big{
			width:1000px;
			height:100%;
			border:1px solid red;
		}
		.left{
			width:200px;
			height:100%;
			border:1px solid black;
			float: left;
			background-color: rgba(51,50,50,0.9)
		}
		.left_top{
			height:150px;
			width: 150px;
			border:1px solid red;
			border-radius: 50%;
			background-image: url(${APP_PATH}/static/images/touxiang.jpg);
			background-size: 150px 150px;
			margin: 30px auto;
		}
		.left_bottom ul li{
			list-style: none;
			height:35px;
			
			font-size: 19px;
			
			text-align: center;;
			line-height: 30px;
			border: 1px solid rgba(200,200,200,0.3);
			transition: all 0.5s;
			
		}
		.left_bottom ul li:hover{
			background: rgba(150,150,150,0.8);			
		}
		.left_bottom{
			height: 400px;
			width:100px;
			margin: 2 auto;
		}
		a{
			color: white;
			text-decoration: none;
		}
		.right{
			width:790px;
			height:100%;
			float: right;
		}
		.right_info{
			height:40px;
			background:rgb(240,240,240);
			line-height: 40px;
			border-radius: 5px;
		}
		.right_info .info{
			width:200px;
		    float: left;
		    margin-left:20px;
		}
		.right_info .name{
			width:200px;
		    float: right;
		}
		.right_base_info{
			margin-top:27px;
			width:790px;
			height:100px;
			/* line-height: 60px; */
			border: 1px solid rgba(70,70,70,0.2);
			border-radius: 20px;
			
		}
		.right_base_info ul li{
			width: 100px;
			height:100px;
			list-style: none;
			float: left;
			margin-left:75px;
			text-align: center;
			font-size: 18px;
			color: rgba(70,70,70,0.7);
			
		}
		.right_base_info ul li span{
			font-size: 50px;
			color: black;
		}
		.right_user_info{
			width: 790px;
			height: 150px;
			margin-top: 30px;
			background: rgba(200,200,200,0.3);
			border-radius: 20px;
			padding: 10px;
		}
		.right_user_BorrBook{
			width: 790px;
			margin-top: 30px;
			margin-top: 25px;
			background: rgba(200,200,200,0.3);
			border-radius: 20px;
			padding: 15px;
		}
		.huanshu{
			color: white;
			text-align: center;
			width: 55px;
			height: 38px;
			border: 1px solid rgba(220,220,220,0.8);
			line-height:35px;
			border-radius: 5px;
			background: rgba(38,148,243,0.7);
		}
	</style>
  </head>
  
  <body>
    <h1>用户页面</h1>
  
    <div class="big">
    	<div class="left">
    		<div class="left_top">
    			
    		</div>
    		<div class="left_bottom">
    			<ul>
    				<li><a href="#">个人资料</a></li>
    				<li><a href="#">进入书城</a></li>
    				<li><a href="#">借书记录</a></li>
    				<li><a href="#">我的信用</a></li>
    				<li><a href="#">借到的书</a></li>
    				<li><a href="#">待还的书</a></li>
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
    				<span>${msg.extend.student.stuName}</span>
    				<a href="${APP_PATH }/exit" style="color: red;">退出</a>
    				
    			</div>
    		</div>
    		<!-- 右二 -->
    		<div class="right_base_info">
    			<ul>
    				<li><span>${msg.extend.BookCount}</span><br>Borrowed</li>
    				<li><span>15</span><br>Book&nbsp;Count</li>
    				<li><span>20</span><br>be&nbsp;fond&nbsp;of </li>
    				<li><span>50</span><br>Book&nbsp;Count</li>
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
				         <th>用户名</th>
				         <th>邮箱</th>
				         <th>类型</th>
				      </tr>
				   </thead>
				   <tbody>
				      <tr>
				         <td>${msg.extend.student.stuId}</td>
				         <td>${msg.extend.student.stuName}</td>
				         <td>${msg.extend.student.stuSex}</td>
				         <td>${msg.extend.student.stuCard}</td>
				         <td>${msg.extend.student.stuEmail}</td>
				         <td>${msg.extend.student.stuCard}</td>
				      </tr>
				   </tbody>
				</table>
    		</div>
    		<!-- 右四 -->
    		<div class="right_user_BorrBook">
    			<c:if test="${empty msg.extend.studentLeadInfo}">
				   			你还没有借过书呢，快去借书吧
				</c:if>
				<c:if test="${not empty msg.extend.studentLeadInfo}">
	    			<table class="table">
						<caption>借书记录</caption>
					   <thead>
					      <tr>
					         <th>BookId</th>
					         <th>BookName</th>
					         <th>LeadBookTime</th>
					         <th>BookStatus</th>
					         <th>---</th>
					      </tr>
					   </thead>
					   <tbody>
				   		<c:forEach items="${msg.extend.studentLeadInfo}" var="stuLendInf">
				   			<tr>
				   				<td>${stuLendInf.leadBookId}</td>
				   				<td>${stuLendInf.leadBookName}</td>
				   				<td>${stuLendInf.leadBookTime}</td>
				   				<td>${stuLendInf.leadBookStatus=="0"?"待还":"已还"}</td>
				   				<td><c:if test="${ stuLendInf.leadBookStatus eq '0'}">
				   					<a href="returnBook/${stuLendInf.leadBookId}"><div class="huanshu">还书</div></a>
				   				</c:if></td>
				   			</tr>
				   		</c:forEach>
					   		
					   </tbody>
					</table>
				</c:if>
    		</div>
    		
    		
    	</div>
    </div>
    
    <%
    	session.setAttribute("user", "user");
     %>
  </body>
</html>
