<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
pageContext.setAttribute("APP_PATH", request.getContextPath());

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>smgk-图书中心商城</title>
   
    <link href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="${APP_PATH }/static/css/bookHomeCss.css" rel="stylesheet">
    <script type="text/javascript" src="../${APP_PATH}/static/js/vue.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/js/jquery-1.12.4.min.js"></script>
    
  </head>
  
  <body>
    <input type="hidden" id="stuId" value="${sessionScope.stuId}">
    <input type="hidden" id="StuStatus" value="${sessionScope.StuStatus}">
    <input type="hidden" id="APP_PATH" value="${APP_PATH}">
    
    
    <div class="big">
    	<div class="big_head">
    		<div class="big_head_top">
		    	<div class="big_head_top_left">
		    		<h1>smgk - bookShop</h1>
		    	</div>
		    	<div class="big_head_top_right">
		    		<c:if test="${not empty sessionScope.stuId}">
				    	<i style="font-size:24px" class="fa">&#xf221</i>
						<a href="myselCenter">${sessionScope.stuId} 用户中心</a>		    	
		    		</c:if>
		    		<c:if test="${not empty sessionScope.adminId}">
				    	<i style="font-size:24px" class="fa">&#xf221</i>
						<a href="adminCenter">${sessionScope.adminId} 管理员中心</a>		    	
		    		</c:if> 
		    	</div>
    		</div>
    		<div class="big_head_bot">
    			<ul>
    				<li>BookStyle</li>
    				<li>aboutUs</li> 
    				<li>BookHome</li>
    				<li>BookCenter</li>
    				<li>BookGenre</li>
    				<li>BookDesc</li>
    			</ul>
    		</div>
    	</div>
    	<div class="two">
    		<div class="two_top">SMGK</div>
    		<div class="two_bot">
    			<div class="two_bot_left"></div>
    			<div class="two_bot_right">
    				<p>Lorem ipsum dolor sit amet, consectetur adipiscing </p>
    				<p>Aliquam velit nisl, ullamcorper eget elit vitae, vehicula</p>
    				 consequat neque. Nunc sit amet orci at orci blandit dictum
    				  a sed diam. Curabitur ut pharetra sem. Aliquam erat volutpat.
    				  Cras scelerisque, nunc nec vulputate hendrerit, est neque pretium velit,
    				   at vulputate tortor neque ut ex. Vivamus sollicitudin eleifend urna, vitae
    			</div>
    		</div>
    	</div>
    </div>
    <div class="book">
    	<div class="biancheng">
    		<div class="biancheng_head">--编程类--</div>
    		<div class="biancheng_book">
    			<ul class="biancheng_book_ul" id="biancheng_book_ul">
    				<!-- <li v-for="bc in bcs">
    					../${APP_PATH}/static/images/book/ai.png
    					<img v-bind:src="bc.bookPhoto">
    					
    					<div class="biancheng_book_content">
    						<span>书名：{{bc.bookName}}</span><br>
    						<span>描述：{{bc.bookDesc}}</span><br>
    						<button class="btn btn-info">借书</button>
    					</div>
    				</li> -->
    			</ul>
    		</div>
    		<div class="BCFY" >
    			<div class="BCFY_info"></div>
    			<!-- 分布条 -->
    			<div class="BCFY_fyt" id="BCFY_fyt"></div>
    		</div>
    	</div>
    	<!-- 设计书 -->
    	<div class="sheji">
    		<div class="sheji_head">--设计类--</div>
    		<div class="sheji_book">
    			<ul class="sheji_book_ul" id="sheji_book_ul">
    			</ul>
    		</div>
    		<div class="SJFY" >
    			<div class="SJFY_info"></div>
    			<!-- 分布条 -->
    			<div class="SJFY_fyt" id="SJFY_fyt"></div>
    		</div>
    	</div>
    	<!-- 电商书 -->
    	<div class="dianshang">
    		<div class="dianshang_head">--设计类--</div>
    		<div class="dianshang_book">
    			<ul class="dianshang_book_ul" id="dianshang_book_ul">
    			</ul>
    		</div>
    		<div class="DSFY" >
    			<div class="DSFY_info"></div>
    			<!-- 分布条 -->
    			<div class="DSFY_fyt" id="DSFY_fyt"></div>
    		</div>
    	</div>
    </div>
  </body>
  <script type="text/javascript" src="${APP_PATH}/static/js/bookshop.js"></script>
  <script type="text/javascript">
  	var PATH=$("#APP_PATH").attr("value")
  </script>
</html>
