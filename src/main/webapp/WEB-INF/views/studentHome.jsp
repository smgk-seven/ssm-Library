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
	
  </head>
  
  <body>
  	<input type="hidden" value="${sessionScope.stuId}" id="STUID">
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
    		
    	</div>
    </div>
    
    <a href="showBooks">进入商城</a>
  </body>
  <script type="text/javascript">
  	var stuId;
  	var StuStatus;
  	$(function(){
  		getStuInfo();
  	})
  	$(".stuDaoHang").click(function(){
  		return false;
  	})
  	var STUID=$("#STUID").val();
  	function getStuInfo(){
  		$.ajax({
  			url:"${APP_PATH}/getStuAllInfo",
  			data:"STUID="+STUID,
  			type:"GET",
  			success:function(result){
  				addStuInfo(result);
  				addStuBorrBook(result);
  			}
  		})
  	}
  	//添加学生信息到表格
  	function addStuInfo(result){
  		stuId=result.extend.stuAllInfo.stuId;
  		StuStatus=result.extend.stuAllInfo.stuStatus
  		$("#stu_Info_tbody").empty();
  		var stuSex="";
  		var stuStatus="";
  		if(result.extend.stuAllInfo.stuStatus=="0"){stuStatus="良好"}
  		if(result.extend.stuAllInfo.stuStatus=="1"){stuStatus="差！"}
  		if(result.extend.stuAllInfo.stuSex=="0"){stuSex="男";}
  		if(result.extend.stuAllInfo.stuSex=="1"){stuSex="女";}
  		var stuIdTd=$("<td>"+result.extend.stuAllInfo.stuId+"</td>");
  		var stuNameTd=$("<td>"+result.extend.stuAllInfo.stuName+"</td>");
  		var stuSexTd=$("<td>"+stuSex+"</td>");
  		var stuEmailTd=$("<td>"+result.extend.stuAllInfo.stuEmail+"</td>");
  		var stuStatusTd=$("<td>"+stuStatus+"</td>");
  		$("<tr></tr>").append(stuIdTd).append(stuNameTd).append(stuSexTd).append(stuEmailTd).append(stuStatusTd).appendTo("#stu_Info_tbody");
  	}
  	//添加学生借书的信息
  	//stu_BorrBook_tbody
  	function addStuBorrBook(result){
  		$("#stu_BorrBook_tbody").empty();
  		var StuLeadBookInfoS=result.extend.stuAllInfo.lends;
  		$.each(StuLeadBookInfoS,function(index,item){
	  		var BookStatus=null;
	  		var huansuBt=null;
  			if(item.lendStatus=="0"){
  				BookStatus="待还";
  				huansuBt=$("<td class='huanshuBt' id='huanshubtId'>"+'还书'+"</td>");
  				huansuBt.attr("lendBookId",item.lendId);
  			}else{
  				BookStatus="已还";
  			}
  			var leadBookNumBt=$("<td>"+item.lendNum+"</td>")
  			var BookNameBt=$("<td>"+item.book.bookName+"</td>")
  			var LeadBookTimeBt=$("<td>"+item.leadBookTime+"</td>")
  			var BookStatusBt=$("<td>"+BookStatus+"</td>")
  			$("<tr></tr>").append(leadBookNumBt).append(BookNameBt).append(LeadBookTimeBt).append(BookStatusBt).append(huansuBt).appendTo("#stu_BorrBook_tbody");
  		})
  	}
  	$(document).on("click","#huanshubtId",function(){
  		
  		if(confirm("是否还书？？")){
	  		$.ajax({
	  			url:"${APP_PATH}/returnBook/"+$(this).attr("lendBookId"),
	  			type:"GET",
	  			success:function(){
		  		getStuInfo();
	  			}
	  		})
  		}
  	})
  	//利用jq跳转到书城
  	$("#showBooks").click(function(){
  		window.location.href = 'showBooks?stuId='+stuId+'&StuStatus='+StuStatus+'';
  	})
  	
  </script>
</html>
