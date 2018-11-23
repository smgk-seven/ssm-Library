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
    <%-- <h3>
    	welcome ${sessionScope.adminId}
    	<a href="adminShowBook">查看书本</a>
    </h3> --%>
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
								<li><a href="">添加书本</a></li>
								<li><a href="">书本信息</a></li>
								<li><a href="">操作书本</a></li>
							</ul>
						<button class="userBt btn">用户管理</button>
							<ul class="userBtnUl">
								<li><a href="">所有用户</a></li>
								<li><a href="">添加用户</a></li>
								<li><a href="">用户按钮</a></li>
								<li><a href="">用户按钮</a></li>
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
    							<div class="user_info_value userCount">50</div>
    							<div class="user_info_name">总用户个数</div>
    						</li>
    						<li class="user_info_li">
    							<div class="user_info_value bmd">50</div>
    							<div class="user_info_name">白名单</div>
    						</li>
    						<li class="user_info_li">
    							<div class="user_info_value hmd">50</div>
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
								<div class="stuTitle">bookInfo</div>
								<div class="stuAddDiv">
								<button type='button' class='btn btn-info addStuBt' class='btn btn-primary' data-toggle='modal'data-target='addBookMT'>addstudentk</button>
								</div>
							</div>
						   <thead>
						      <tr>
						         <th>stuId</th>
						         <th>stuName</th>
						         <th>stuSex</th>
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
  </body>
  <script type="text/javascript">
  	$(function(){
  		//处理点击 css
  		$(".bookBt").click(function(){
	  		$(".userBtnUl").css("height","0px");
  			$(".bookBtnUl").css("height","120px");
  		})
  		//处理点击 css
  		$(".userBt").click(function(){
  			$(".bookBtnUl").css("height","0px");
  			$(".userBtnUl").css("height","120px");
  		})
  		//getBook
  		getBooks(1);
  		getStudents(1)
  	})
  	//全局变量
  	var pageNum=0;
  	var pages=0;
  	var stuPageNum=0;
  	var stuPages=0;
  	//获取书
  	function getBooks(pageNum){
  		$.ajax({
  			url:"${APP_PATH}/getBooks",
			data:"pageNum="+pageNum,
			type:"GET",
			success:function(result){
				addBooks(result);
				addBookInfo(result);
				bookFyInfo(result);
				bookFyt(result);
			}
  		})
  	}
  	function addBookInfo(result){
  		$(".book_info_value").empty();
		$(".bookCount").append(result.extend.bookInfo.bookCount)
		$(".yiHuan").append(result.extend.bookInfo.yiHuan)
		$(".daiHuan").append(result.extend.bookInfo.daiHuan)
  	}
  	function addBooks(result){
  		$("#bookInfo").empty();
  		$.each(result.extend.pageInfo.list,function(index,item){
  			//alert(item.bookName)
  			var genre;
  			if(item.bookGenre=='1'){
  				genre="编程类";
  			}
  			if(item.bookGenre=='2'){
  				genre="设计类";
  			}
  			if(item.bookGenre=='3'){
  				genre="电商类"
  			}
  			var bookIdBt=$("<td>"+item.bookId+"</td>")
  			var bookNameBt=$("<td>"+item.bookName+"</td>")
  			var bookAuthorBt=$("<td>"+item.bookAuthor+"</td>")
  			var bookGenreNameBt=$("<td>"+genre+"</td>")
  			var delBookBt=$("<button type='button' class='btn btn-danger delBook'>delete</button>").attr("bookId",item.bookId);
  			var editBookBt=$("<button type='button' class='btn btn-primary editBook' >edit</button>").attr("bookId",item.bookId);
  			
  			var action=$("<td></td>").append(delBookBt).append(" ").append(editBookBt)
  			$("<tr></tr>").append(bookIdBt).append(bookNameBt).append(bookAuthorBt).append(bookGenreNameBt).append(action).appendTo("#bookInfo");
  		})
  	}
  	//book分页信息
  	function bookFyInfo(result){
  		$(".book_fyInfo").empty();
  		$(".book_fyInfo").append("总书数【"+result.extend.pageInfo.total+"】 当面页【"+result.extend.pageInfo.pageNum+"】");
  		pageNum=result.extend.pageInfo.pageNum;
  		pages=result.extend.pageInfo.pages;
  	}
  	//book分页条
  	function bookFyt(result){
  		$(".book_fyt").empty();
  		var ul=$("<ul></ul>").addClass("pagination");
  		
  		var firstPageLi = $("<li></li>").append($("<a></a>").append("首页"));
  		var prePageLi = $("<li></li>").append($("<a></a>").append("《"));
  		//判断如果没有上一页，就设置为不可点击 
  		if(result.extend.pageInfo.hasPreviousPage==false){
  			firstPageLi.addClass("disabled");
  			prePageLi.addClass("disabled");
  		}else{
			//为元素添加点击翻页的事件
			firstPageLi.click(function(){
				getBooks(1);
			});
			prePageLi.click(function(){
				getBooks(result.extend.pageInfo.pageNum -1);
			});
			}
  		var nextPageLi = $("<li></li>").append($("<a></a>").append("》"));
  		var lastPageLi = $("<li></li>").append($("<a></a>").append("尾页"));
  		
  		//判断如果没有上一页，就设置为不可点击 
  		if(result.extend.pageInfo.hasNextPage==false){
  			nextPageLi.addClass("disabled");
  			lastPageLi.addClass("disabled");
  		}else{
			nextPageLi.click(function(){
				getBooks(result.extend.pageInfo.pageNum +1);
			});
			lastPageLi.click(function(){
				getBooks(result.extend.pageInfo.pages);
			});
		}
  		ul.append(firstPageLi).append(prePageLi);
  		//遍历 出 页数导航条--》 navigatepageNums
  		$.each(result.extend.pageInfo.navigatepageNums,function(index,item){
  			
  			var numLi = $("<li></li>").append($("<a></a>").append(item));
  			if(result.extend.pageInfo.pageNum==item){
  				numLi.addClass("active");
  			}
  			numLi.click(function(){
  				getBooks(item);
  			})
  			ul.append(numLi);
  		})
  		ul.append(nextPageLi).append(lastPageLi);
  		var navEle=$("<nav></nav>").append(ul);
  		navEle.appendTo(".book_fyt");
  	}
  	//删除书
  	$(document).on("click",".delBook",function(){
  		var bookName=$(this).parents("tr").find("td:eq(1)").text();
  		var bookId=$(this).parents("tr").find("td:eq(0)").text();
  		if(confirm("是否删除【"+bookName+"】")){
  			$.ajax({
				url:"${APP_PATH }/delBook",
				type:"GET",
				data:"bookId="+bookId,
				success:function(result){
					alert(result.msg)
		 			getBooks(pageNum);
				} 
		 	})
  		}
  	})
  	//更改书
  	$(".addBook").click(function(){
  		getDepts("#addBookModal select")
  		$("#addBookModal").modal(function(){
  			backdrop:'static';
  		})
  	})
  	//获取部门信息
  	function getDepts(ele){
  		$(ele).empty();
  		$.ajax({
  			url:"${APP_PATH}/getGenre",
  			type:"GET",
  			success:function(result){
  				$.each(result.extend.genres,function(){
  					var optionEle=$("<option></option").append(this.genreName).attr("value",this.genreId);
  					optionEle.appendTo(ele);
  				})
  			}
  		});
  	}
  
  	//添加 书本
  	$(".addBookBT").click(function(){
  		$("#addBookModal").modal('hide');
  		$.ajax({
  			url:"${APP_PATH }/addBook",
  			type:"POST",
  			data:$("#addBookModal form").serialize(),
  			success:function(result){
  				alert(result.msg)
  				getBooks(pages);
  			}
  		})
  		
  		$("#addBookModal input,label,select").val("");
  	})
  	//修改
  	$(document).on("click",".editBook",function(){
  		
  		getDepts("#editBookModal select")
  		getBook($(this).parents("tr").find("td:eq(0)").text());
  		$("#editBookModal").modal(function(){
  			backdrop:'static';
  		})
  	})
  	function getBook(id){
  		$.ajax({
  			url:"${APP_PATH }/getBook",
  			type:"GET",
  			data:"bookId="+id,
  			success:function(result){
  				var book=result.extend.book;
  				$("#editBookModal #bookName").attr("value",book.bookName);
  				$("#editBookModal #bookDesc").attr("value",book.bookDesc);
  				$("#editBookModal #bookAuthor").attr("value",book.bookAuthor);
  				$("#editBookModal #count").attr("value",book.count);
  				$("#editBookModal #bookId").attr("value",book.bookId);
  				
  				$("#editBookModal #bookGenre").val(""+book.bookGenre+"");
  			}
  		})
  	}
  	$(".editBookBT").click(function(){
  		$("#editBookModal").modal('hide');
  		$.ajax({
  			url:"${APP_PATH }/editBook",
  			type:"POST",
  			data:$("#editBookModal form").serialize(),
  			success:function(result){
  				alert(result.msg)
  				
  			}
  		
  		})
  	})
  	//用户的操作
  	function getStudents(pageNum){
  		$.ajax({
  			url:"${APP_PATH }/getStudents",
  			data:"pageNum="+pageNum,
  			type:"GET",
  			success:function(result){
  				
  			}
  		})
  	}
  	
  	</script>
</html>
