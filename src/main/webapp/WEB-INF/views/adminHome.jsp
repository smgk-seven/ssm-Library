<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
pageContext.setAttribute("APP_PATH", request.getContextPath());
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML5">
<html>
  <head>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
    <link rel="stylesheet" href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
     <link href="${APP_PATH }/static/css/adminHome.css" rel="stylesheet">
    <script type="text/javascript" src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
   
    
    
    <title>My JSP 'adminHome.jsp' starting page</title>
    <style type="text/css">
    	
    </style>
  </head>
  <body>
    <input type="hidden" id="APP_PATH" value="${APP_PATH}">
    <div class="bk">
    	<div class="big">
    		<div class="left">
    			<div class="left_top">
    				<div>
    					<i style="font-size:24px" class="fa">&#xf080</i>
    					后台数据管理
    				</div>
    			</div>
    			<div class="left_bom">
	    			<div class="left_bom_bt">
						<button type="button" class="bookBt btn btn-default" data-toggle="dropdown">书本管理</button>
							<ul class="bookBtnUl">
								<li><a href="adminShowBook">查看书本</a></li>
								<li class="addBook">添加书本</li>
								<li>书本信息</li>
								<li>操作书本</li>
							</ul>
						<button class="userBt btn">用户管理</button>
							<ul class="userBtnUl">
								<li class="showAllUser">所有用户</li>
								<li>添加用户</li>
								<li>用户按钮</li>
								<li>所有用户</li>
								
							</ul>
						<button class=" btn">功能按钮</button>
						<button class=" btn">功能管理</button>
						<button class=" btn">功能管理</button>
					</div>
    			</div>
    		</div>
    		<div class="right">
    			<div class="right_first">
    				<div>
    					<i style="font-size:24px" class="fa">&#xf2ba</i>
    					 ${sessionScope.adminId} 
    					 &nbsp;<a href="exit" style="color: red;text-decoration: none;cursor:hand;"><i class="fa">&#xf127</i> 退出</a>
    				</div>
    			</div>
    			<div class="right_UseAndBookInfo">
    				<div class="base_info">BookAndUserInfo</div>
    				<div class="user_info">
    					<ul>
    						<li class="user_info_li">
    							<div class="user_info_value userCount"></div>
    							<div class="user_info_name">总用户个数</div>
    						</li>
    						<li class="user_info_li">
    							<div class="user_info_value bmd"></div>
    							<div class="user_info_name">白名单</div>
    						</li>
    						<li class="user_info_li">
    							<div class="user_info_value hmd"></div>
    							<div class="user_info_name">黑名单</div>
    						</li>
    						
    					</ul>
    				</div>
    				<div class="book_info">
    					<ul>
    						<li class="book_info_li">
    							<div class="book_info_value bookCount"></div>
    							<div class="book_info_name">借出总数</div>
    						</li>
    						<li class="book_info_li">
    							<div class="book_info_value yiHuan"></div>
    							<div class="book_info_name">已还书数</div>
    						</li>
    						<li class="book_info_li">
    							<div class="book_info_value daihuan"></div>
    							<div class="book_info_name">待还书数</div>
    						</li>
    					</ul>
    				</div>
    			</div>
    			<div class="book">
    				<div class="book_content">
    					<table class="table">
							<div class="book_title">
								<div class="bookTitle">bookInfo</div>
								<div class="bookAddDiv">
								<button type='button' class='btn btn-info addBook' class='btn btn-primary' data-toggle='modal'data-target='addBookMT'>addBook</button>
								</div>
							</div>
						   <thead>
						      <tr>
						         <th>bookId</th>
						         <th>bookName</th>
						         <th>bookAuthor</th>
						         <th>bookGenre</th>
						         <th>###</th>
						      </tr>
						   </thead>
						   <tbody id="bookInfo">
						   </tbody>
						</table>
    				</div>
    				<div class="book_fy">
    					<div class="book_fyInfo"></div>
    					<div class="book_fyt"></div>
    				</div>
    			</div>
    			<!-- 用户信息 -->
    			<div class="student">
    				<div class="stu_content">
    					<table class="table">
							<div class="stu_title">
								<div class="stuTitle">userInfo</div>
								<div class="stuAddDiv">
								<button type='button' class='btn btn-info addStuBt' class='btn btn-primary' data-toggle='modal'data-target='addBookMT'>addstudentk</button>
								</div>
							</div>
						   <thead>
						      <tr>
						         <th>stuId</th>
						         <th>stuName</th>
						         <th>stuSex</th>
						         <th>stuEmail</th>
						         <th>stuStatus</th>
						         <th>###</th>
						      </tr>
						   </thead>
						   <tbody id="stuInfo">
						   </tbody>
						</table>
    				</div>
    				<div class="stu_fy">
    					<div class="stu_fyInfo"></div>
    					<div class="stu_fyt"></div>
    				</div>
    			</div>
    			
    			
    		</div>
    	</div>
    </div>
    
    <!-- 添加员工模态框 -->
	<div class="modal fade" id="addBookModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h4 class="modal-title" id="myModalLabel">
						添加书本
					</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" role="form">
						<div class="form-group addBookForm">
							<label for="firstname" class="col-sm-2 control-label">书名</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="bookName" name="bookName"
									   placeholder="请输入名字">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">作者</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="bookAuthor" 
									   placeholder="请输入作者">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">描述</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="bookDesc" 
									   placeholder="请输入书本描述">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">总数</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="count" 
									   placeholder="请输入书本总数">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">类别</label>
							<select class="form-control" name="bookGenre">
							</select>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary addBookBT">提交更改</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 修改员工 -->
	<div class="modal fade" id="editBookModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h4 class="modal-title" id="myModalLabel">
						添加书本
					</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" role="form">
						<div class="form-group addBookForm">
							<label for="firstname" class="col-sm-2 control-label">书名</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="bookName" name="bookName"
									   placeholder="请输入名字">
									   <input type="hidden" name="bookId" id="bookId">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">作者</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="bookAuthor" name="bookAuthor" 
									   placeholder="请输入作者">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">描述</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="bookDesc" name="bookDesc" 
									   placeholder="请输入书本描述">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">总数</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="count" id="count"
									   placeholder="请输入书本总数">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-2 control-label">类别</label>
							<select class="form-control" name="bookGenre" id="bookGenre">
							</select>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary editBookBT">提交更改</button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 查看用户详情的模态框 -->
	<div class="modal fade" id="showStuModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h4 class="modal-title" id="myModalLabel">
						<div class="stuName"><span class="stuNameSpan" style="color: red;"></span><span>：的借书记录</span></div>
					</h4>
				</div>
				<div class="modal-body">
					<div></div>
					<table class="table showStuTable">
						
					   <thead>
					      <tr>
					         <th>订单编号</th>
					         <th>书名</th>
					         <th>借书时间</th>
					         <th>借书状态</th>
					         
					      </tr>
					   </thead>
					   <tbody id="stu_BorrBook_tbody">
					   </tbody>
					</table>
				</div>
				<div class="modal-footer">
					<div class="showStuLBFY"></div>
					<div class="showStuCloseBT">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 点击查看用户的模态框 -->
	<div class="modal fade" id="showAllUserModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h4 class="modal-title" id="myModalLabel">
						
					</h4>
				</div>
				<div class="modal-body">
					<div class="student">
    				<div class="stu_content">
    					<table class="table">
							<div class="stu_title">
								<div class="stuTitle">userInfo</div>
								<div class="stuAddDiv">
								<button type='button' class='btn btn-info addStuBt' class='btn btn-primary' data-toggle='modal'data-target='addBookMT'>addstudentk</button>
								</div>
							</div>
						   <thead>
						      <tr>
						         <th>stuId</th>
						         <th>stuName</th>
						         <th>stuSex</th>
						         <th>stuEmail</th>
						         <th>stuStatus</th>
						         <th>###</th>
						      </tr>
						   </thead>
						   <tbody id="showStuInfo">
						   </tbody>
						</table>
    				</div>
    				<div class="stu_fy">
    					<div class="stu_fyInfo"></div>
    					<div class="stu_fyt"></div>
    				</div>
    			</div>
					
				</div>
				<div class="modal-footer">
					<div class="showStuLBFY"></div>
					<div class="showStuCloseBT">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	 
  </body>
   <script type="text/javascript" src="${APP_PATH }/static/js/adminHome.js"></script>
  <script type="text/javascript">
 	var PATH=$("#APP_PATH").attr("value");
	
  </script>
</html>
