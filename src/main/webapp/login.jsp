<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
pageContext.setAttribute("APP_PATH", request.getContextPath());
%>

<!DOCTYPE HTML5>
<html>
  <head>
    <base href="<%=basePath%>">
    <link href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
     <script type="text/javascript" src="${APP_PATH}/static/js/jquery-1.12.4.min.js"></script>
     <script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <title>smgk-serven图书馆登录中心</title>
    <style type="text/css">
    	*{
    		margin:0;
    		padding:0;
    	}
    	.big{
    		width:100%;
    		height:100%;
    		border:1px solid black;
    		 background:url(${APP_PATH}/static/images/banner.jpg);
    		 background-size: 100% 100%;
    	}
    	.center{
    		width: 600px;
    		height:450px;
    		background-color: rgba(255,255,255,0.1);
    		margin: 150px auto;
    		padding: 12px;
    	}
    	.LoginH2{
    		width: 600px;
    		height: 80px;
    		text-align: center;
    		color: white;
    		margin-top: 20px;
    	}
    	
    	.formDiv{
    		width: 440px;
    		margin: 10px auto;
    		margin-top: 100px;
    	}
    	.buttonDiv{
    		margin-left: 330px;
    		
    	}
    	
    </style>
	</head>
	<body>
		<!-- 注册模态框  -->
		<div class="modal fade" id="stuAddModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h4 class="modal-title" id="myModalLabel">添加用户</h4>
	            </div>
	            <div class="modal-body">
	            	<form class="form-horizontal">
						<div class="form-group">
						    <label class="col-sm-2 control-label">stuName</label>
						    <div class="col-sm-10">
						    <input type="text" name="stuName" class="form-control" id="stuName_add_input" placeholder="请输入用户名">
						    <span class="help-block"></span>
						    <input type="hidden" name="stuStatus" class="form-control" id="stuStatus_add_input"value="0">
						</div>
						<div class="form-group">
						    <label class="col-sm-2 control-label">stuEmail</label>
						    <div class="col-sm-10">
						      <input type="text" name="stuEmail" class="form-control" id="stuEmail_add_input" placeholder="email@atguigu.com">
						      <span class="help-block"></span>
						    </div>
						  </div>
						<div class="form-group">
						    <label class="col-sm-2 control-label">stuCard</label>
						    <div class="col-sm-10">
						      <input type="text" name="stuCard" class="form-control" id="stuCard_add_input" placeholder="登录时的账号">
						      <span class="help-block"></span>
						    </div>
						  </div>
						<div class="form-group">
						    <label class="col-sm-2 control-label">stuPwd</label>
						    <div class="col-sm-10">
						      <input type="password" name="stuPwd" class="form-control" id="stuPwd_add_input" placeholder="登录时的密码">
						      <span class="help-block"></span>
						    </div>
						  </div>
						
						<div class="form-group">
						    <label class="col-sm-2 control-label">stuSex</label>
						    <div class="col-sm-10">
						      <label class="radio-inline">
								  <input type="radio" name="stuSex" id="gender1_add_input" value="0" checked="checked"> 男
								</label>
								<label class="radio-inline">
								  <input type="radio" name="stuSex" id="gender2_add_input" value="1"> 女
								</label>
						    </div>
						</div>
					  </div>
					</form>
	            	
	            </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	                <button type="button" class="btn btn-primary" id="stu_save_btn">注册</button>
	            </div>
	        </div><!-- /.modal-content -->
	    </div><!-- /.modal -->
	</div>
	
		<div class="big">
			<div class="center">
				<h2 class="LoginH2"> smgk-LibrarySystem<br><br>-LoginCenter</h1>
				<div class="formDiv">
					<form class="form-horizontal" role="form" action="${APP_PATH}/LoginServlet" method="post">
					  <div class="form-group">
					    <label for="firstname" class="col-sm-2 control-label">username</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control" id="loginName" name="username" placeholder="请输入登录 名">
					    	<span class="help-block"></span>
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="lastname" class="col-sm-2 control-label">password</label>
					    <div class="col-sm-10">
					      <input type="password" class="form-control" id="loginPassword" name="password"  placeholder="请输入登录 密码">
					    	<span class="help-block"></span>
					    </div>
					  </div>
					  <div class="form-group">
					    <div class="col-sm-offset-2 col-sm-10 buttonDiv">
					      <button type="submit" class="btn btn-default login">登录</button>
					       <button type="button" class="btn btn-primary" id="addStuBut">注册</button>
					    </div>
					  </div>
					</form>
				</div>
			</div>
		</div>
		
	
	</body>
	
	<script type="text/javascript">
	//处理登录时的简单验证
	$(".login").click(function(){
		if($("#loginName").val()==''|$("#loginPassword").val()==''){
			if($("#loginName").val()==''){
				show_validate_msg("#loginName","error","用户名不能为空");
			}else{
				show_validate_msg("#loginName","success","");
			}
			if($("#loginPassword").val()==''){
				show_validate_msg("#loginPassword","error","密码不能为空");
			}else{
				show_validate_msg("#loginPassword","success","");
			}
			return false;
		}
	})
	//处理注册
	//弹出模态框
	$("#addStuBut").click(function(){
		$("#stuAddModel").modal(function(){
			backdrop:'static';
		});
	})
	//处理保存按钮
	$("#stu_save_btn").click(function(){
		if(!validate_add_form()){
			return false;
		}
		console.log("检查完成")
		console.log($("#stuAddModel form").serialize())
		$("#stuAddModel").modal('hide');
		$.ajax({
			url:"${APP_PATH }/stu",
			type:"POST",
			data:$("#stuAddModel form").serialize(),
			
			success:function(result){
				alert(result.msg)
				
			}
 		})
		$("input,label,select").val("");
	})
	
	//查重
	$("#stuCard_add_input").change(function(){
		var stuCard=$("#stuCard_add_input").val();
		console.log(stuCard)
		$.ajax({
			url:"${APP_PATH}/checkStuCard",
			data:"stuCard="+stuCard,
			type:"GET",
			success:function(result){
				if(result.code==100){
					$("#stu_save_btn").removeClass("disabled");
					show_validate_msg("#stuCard_add_input", "error", "");
					return true;
				}
				if(result.code==200){
					show_validate_msg("#stuCard_add_input", "error", "账号重复");
					$("#stu_save_btn").addClass("disabled");
					return false
				}
			}
		})
	})
	
	
	//检查字段
	function validate_add_form(){
		//检查两样 stucard stuEmail，
		var stuCard=$("#stuCard_add_input").val();
  		var regCard = /(^[a-zA-Z_-]{6}$)/;
  		var stuEmail=$("#stuEmail_add_input").val();
  		var regEmail = /^([a-zA-Z0-9_\.-]+)@([a-zA-Z0-9_\.-]+)\.([a-z\.]{2,6})$/
  		var stuName=$("#stuName_add_input").val()
  		var stuPwd=$("#stuPwd_add_input").val()
  		
  		if(!regEmail.test(stuEmail)|!regCard.test(stuCard)|stuName==''|stuPwd==''){
  			if(!regCard.test(stuCard)){
				show_validate_msg("#stuCard_add_input", "error", "账号{stuCard}必须是6位字母");
  			}
  			if(!regEmail.test(stuEmail)){
  				show_validate_msg("#stuEmail_add_input", "error", "邮箱格式不正确");
  			}
  			if(stuName==''){
  				show_validate_msg("#stuName_add_input", "error", "用户名不能为空");
  			}
  			if(stuPwd==''){
  				show_validate_msg("#stuPwd_add_input", "error", "密码不能为空");
  			}
			return false;
		}else{
			if(regCard.test(stuCard)){
				show_validate_msg("#stuCard_add_input", "success", "");
			}
			if(regEmail.test(stuEmail)){
				show_validate_msg("#stuEmail_add_input", "success", "");
			}
			if(stuName!=''){
  				show_validate_msg("#stuName_add_input", "success", "");
  			}
  			if(stuPwd!=''){
  				show_validate_msg("#stuPwd_add_input", "success", "");
  			}
			return true;
		}
	}
	
	
	//这个方法用于把错误消息显示到控制台
	function show_validate_msg(ele,status,msg){
		//清除当前元素的校验状态
		$(ele).parent().removeClass("has-success has-error");
		$(ele).next("span").text("");
		$(ele).next("span").empty()
		if("success"==status){
			$(ele).parent().addClass("has-success");
			$(ele).next("span").text(msg);
		}else if("error" == status){
			$(ele).parent().addClass("has-error");
			$(ele).next("span").text(msg);
		}
	}
	</script>
</html>
