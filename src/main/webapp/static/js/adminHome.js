/**
 * 
 */
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
  		getStudents(1);
  	})
  	//全局变量
  	var pageNum=0;
  	var pages=0;
  	var stuPageNum=0;
  	var stuPages=0;
  	var STUID;
  	//获取书
  	function getBooks(pageNum){
  		$.ajax({
  			url:PATH+"/getBooks",
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
				url:PATH+"/delBook",
				type:"GET",
				data:"bookId="+bookId,
				success:function(result){
					alert(result.msg)
		 			getBooks(pageNum);
				} 
		 	})
  		}
  	})
  	//添加改书
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
  			url:PATH+"/getGenre",
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
  			url:PATH+"/addBook",
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
  			url:PATH+"/getBook",
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
  	//提交修改的书本信息
  	$(".editBookBT").click(function(){
  	/*$(document).on("click","editBookBT",function(){*/
  		$("#editBookModal").modal('hide');
  		$.ajax({
  			url:PATH+"/editBook",
  			type:"POST",
  			data:$("#editBookModal form").serialize(),
  			success:function(result){
  				alert(result.msg)
  				getBooks(pageNum);
  			}
  		})
  	})
  	
  	//用户的操作
  	function getStudents(pageNum){
  		$.ajax({
  			url:PATH+"/getStudents",
  			data:"pageNum="+pageNum,
  			type:"GET",
  			success:function(result){
  				addStuInfo(result);
  				stuFyInfo(result);
  				stuFyt(result);
  				addUserInfo(result);
  				
  			}
  		})
  	}
  	//填充学生信息
  	function addStuInfo(result){
  		$("#stuInfo").empty();
  		$.each(result.extend.stuInfo.list,function(index,item){
  			var stuSex;
  			var stuStatus
  			var addLMD;
  			if(item.stuSex=='0'){
  				stuSex='男';
  			}
  			if(item.stuSex=='1'){
  				stuSex='女';
  			}
  			if(item.stuStatus=='0'){
  				stuStatus='良好';
  				addLMD=$("<button type='button' class='btn btn-danger add_to_hmd'>加入黑名单</button>").attr("bookId",item.bookId);
  			}
  			if(item.stuStatus=='1'){
  				stuStatus='极差';
  				addLMD=$("<button type='button' class='btn btn-danger add_to_hmd'>移出黑名单</button>").attr("bookId",item.bookId);
  			}
	  		var stuIdBt=$("<td>"+item.stuId+"</td>")
			var stuNameBt=$("<td>"+item.stuName+"</td>")
			var stuSexBt=$("<td>"+stuSex+"</td>")
			var stuEmailBt=$("<td>"+item.stuEmail+"</td>")
			var stuStatusBt=$("<td>"+stuStatus+"</td>")
			
			var showLeadBook=$("<button type='button' class='btn btn-primary show_Lead_book' >查看借书记录</button>").attr("bookId",item.bookId);
			var action=$("<td></td>").append(showLeadBook).append(" ").append(addLMD)
			
			$("<tr></tr>").append(stuIdBt).append(stuNameBt).append(stuSexBt).append(stuEmailBt).append(stuStatusBt).append(action).appendTo("#stuInfo");
  			if(stuStatusBt.text()=='极差'){
  				stuStatusBt.css("color","red");
  			}
  		})
  	}
  	//添加用户
  
  	//加入黑名单
  	$(document).on("click",".add_to_hmd",function(){
	  	var stuId=$(this).parents("tr").find("td:eq(0)").text();
	  	var stuName=$(this).parents("tr").find("td:eq(1)").text();
	  	var stuDemand=$(this).parents("tr").find("td:eq(5)").find("button:eq(1)").text();
  		if(confirm("是否把【"+stuName+"】"+stuDemand+"")){
	  		$.ajax({
	  			url:PATH+"/stuStatus",
	  			data:"stuId="+stuId+"&stuDemand="+stuDemand,
	  			type:"POST",
	  			success:function(result){
	  				alert(result.msg)
	  				getStudents(stuPageNum);
	  			}
	  		})
  		}
  	})
  	//用户分页信息
  	function stuFyInfo(result){
  		$(".stu_fyInfo").empty();
  		$(".stu_fyInfo").append("总用户【"+result.extend.stuInfo.total+"】 当面页【"+result.extend.stuInfo.pageNum+"】");
  		stuPageNum=result.extend.stuInfo.pageNum;
  		stuPages=result.extend.stuInfo.pages;
  	}
  	//用户信息分页条
  	function stuFyt(result){
  		$(".stu_fyt").empty();
  		var ul=$("<ul></ul>").addClass("pagination");
  		
  		var firstPageLi = $("<li></li>").append($("<a></a>").append("首页"));
  		var prePageLi = $("<li></li>").append($("<a></a>").append("《"));
  		
  		//判断如果没有上一页，就设置为不可点击 
  		if(result.extend.stuInfo.hasPreviousPage==false){
  			firstPageLi.addClass("disabled");
  			prePageLi.addClass("disabled");
  		}else{
			//为元素添加点击翻页的事件
			firstPageLi.click(function(){
				getStudents(1);
			});
			prePageLi.click(function(){
				getStudents(result.extend.stuInfo.pageNum -1);
			});
			}
  		var nextPageLi = $("<li></li>").append($("<a></a>").append("》"));
  		var lastPageLi = $("<li></li>").append($("<a></a>").append("尾页"));
  		
  		//判断如果没有上一页，就设置为不可点击 
  		if(result.extend.stuInfo.hasNextPage==false){
  			nextPageLi.addClass("disabled");
  			lastPageLi.addClass("disabled");
  		}else{
			nextPageLi.click(function(){
				getStudents(result.extend.stuInfo.pageNum +1);
			});
			lastPageLi.click(function(){
				getStudents(result.extend.stuInfo.pages);
			});
		}
  		ul.append(firstPageLi).append(prePageLi);
  		//遍历 出 页数导航条--》 navigatepageNums
  		$.each(result.extend.stuInfo.navigatepageNums,function(index,item){
  			
  			var numLi = $("<li></li>").append($("<a></a>").append(item));
  			if(result.extend.stuInfo.pageNum==item){
  				numLi.addClass("active");
  			}
  			numLi.click(function(){
  				getStudents(item);
  			})
  			ul.append(numLi);
  		})
  		ul.append(nextPageLi).append(lastPageLi);
  		var navEle=$("<nav></nav>").append(ul);
  		navEle.appendTo(".stu_fyt");
  	}
  	//把学生信息添加到div
  	function addUserInfo(result){
  		$(".bmd,.userCount,.hmd").empty()
  		$(".userCount").append(result.extend.stuinfo.stuCount);
  		$(".bmd").append(result.extend.stuinfo.stuBMD);
  		$(".hmd").append(result.extend.stuinfo.stuLMD);
  	}
  	
  	
  	//处理查看用户详情按钮
  	$(document).on("click",".show_Lead_book",function(){
  		$(".stuNameSpan").empty()
  		STUID=$(this).parents("tr").find("td:eq(0)").text();
  		var stuName=$(this).parents("tr").find("td:eq(1)").text();
  		$(".stuNameSpan").append(stuName)
  		getStuLeadBook(1);
  		$("#showStuModal").modal(function(){
  			backdrop:'static';
  		})
  	})
  	function getStuLeadBook(pageNum){
  		$.ajax({
			url:PATH+"/getStuLend",
			data:"stuId="+STUID+"&pageNum="+pageNum,
			type:"GET",
			success:function(result){
				addStuLeadBookto(result);
				stuLeadFYT(result);
			}
		})
  	}
  	
  	//把个人用户的借书信息添加到div
  	function addStuLeadBookto(result){
		$("#stu_BorrBook_tbody").empty();
		$.each(result.extend.stuLendInfo.list,function(index,item){
			var BookStatus=null;
			if(item.lendStatus=="0"){
				BookStatus=$("<td style='color:red;'>待还</td>");
			}else{
				BookStatus=$("<td>已还</td>");
			}
			
			var leadBookNumBt=$("<td>"+item.lendNum+"</td>")
			var BookNameBt=$("<td>"+item.book.bookName+"</td>")
			var LeadBookTimeBt=$("<td>"+item.leadBookTime+"</td>")
			
			$("<tr></tr>").append(leadBookNumBt).append(BookNameBt).append(LeadBookTimeBt).append(BookStatus).appendTo("#stu_BorrBook_tbody");
			})
		}
  	//借书分页条
  	
  	function stuLeadFYT(result){
  		$(".showStuLBFY").empty();
  		var ul=$("<ul></ul>").addClass("pagination");
  		var firstPageLi = $("<li></li>").append($("<a></a>").append("首页"));
  		var prePageLi = $("<li></li>").append($("<a></a>").append("《"));
  		//判断如果没有上一页，就设置为不可点击 
  		if(result.extend.stuLendInfo.hasPreviousPage==false){
  			firstPageLi.addClass("disabled");
  			prePageLi.addClass("disabled");
  		}else{
  		//为元素添加点击翻页的事件
  		firstPageLi.click(function(){
  			getStuLeadBook(1);
  		});
  		prePageLi.click(function(){
  			getStuLeadBook(result.extend.stuLendInfo.pageNum -1);
  		});
  		}
  		var nextPageLi = $("<li></li>").append($("<a></a>").append("》"));
  		var lastPageLi = $("<li></li>").append($("<a></a>").append("尾页"));
  		
  		//判断如果没有上一页，就设置为不可点击 
  		if(result.extend.stuLendInfo.hasNextPage==false){
  			nextPageLi.addClass("disabled");
  			lastPageLi.addClass("disabled");
  		}else{
  		nextPageLi.click(function(){
  			getStuLeadBook(result.extend.stuLendInfo.pageNum +1);
  		});
  		lastPageLi.click(function(){
  			getStuLeadBook(result.extend.stuLendInfo.pages);
  		});
  		}
  		ul.append(firstPageLi).append(prePageLi);
  		
  		$.each(result.extend.stuLendInfo.navigatepageNums,function(index,item){
  			var numLi = $("<li></li>").append($("<a></a>").append(item));
  			if(result.extend.stuLendInfo.pageNum==item){
  				numLi.addClass("active");
  			}
  			numLi.click(function(){
  				getStuLeadBook(item);
  			})
  			ul.append(numLi);
  		})
  		ul.append(nextPageLi).append(lastPageLi);
  		var navEle=$("<nav></nav>").append(ul);
  		navEle.appendTo(".showStuLBFY");
  	}
 