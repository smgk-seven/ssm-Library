/**
 * 
 */
var stuId=$("#stuId").val();
var stuStatus=$("#StuStatus").val();

$(function(){
	getBianChengBooks(1);
	getSheJiBooks(1);
	getDianShangBooks(1);
})
//处理编程书
function getBianChengBooks(currPageNum){
	
	//alert("getBianChengBooks方法调用")
	$.ajax({
		url:PATH+"/getBianChengBooks",
		data:"currPageNum="+currPageNum,
		type:"GET",
		success:function(result){
			addBianchengBooks(result)
			build_bcsFyinfo(result)
			build_bcsFyt(result)
		}
	});
}
//把编程类的书本插入到div
function addBianchengBooks(result){
  	/* new Vue({
	  el: '.biancheng_book',
	  data: {
	    bcs:result.extend.bCPageInfo.list
	  }
	  
	}) */
	$("#biancheng_book_ul").empty();
	$.each(result.extend.bCPageInfo.list,function(index,item){
		//alert(item.bookName)
		var bookImgBt=$("<img >");
		bookImgBt.attr("src",item.bookPhoto);
		var bookNameBt=$("<span></span>").append("书名："+item.bookName).append($("<br>"))
		var bookDescBt=$("<span></span>").append("描述："+item.bookDesc).append($("<br>"))
		var bookBT=$("<button class='btn btn-info jieShu'></button>").append("借书").attr("bookId",item.bookId);
		var bookDiv=$("<div class='biancheng_book_content'>").append(bookNameBt).append(bookDescBt).append(bookBT)
		$("<li></li>").append(bookImgBt).append(bookDiv).appendTo(".biancheng_book_ul");
	})
}
//分页信息
function build_bcsFyinfo(result){
	/*alert("build_bcsFyinfo "+result.extend.bCPageInfo.pageNum)
  	/* new Vue({
	  el: '.BCFY_info',
	  data: {
	    bcb_info:result.extend.bCPageInfo
	  },methods:{
	  	
	  }
	}) 
	
	//处理分布条要的功能
	 result.extend.bCPageInfo.navigatepageNums
	new Vue({
		el:'.BCFY_fyt',
		data:{
			bcb_fyt:result.extend.bCPageInfo.navigatepageNums
		}
	}) */
	$(".BCFY_info").empty();
	$(".BCFY_info").append("当前页数【"+result.extend.bCPageInfo.pageNum+"】总记录数【"+result.extend.bCPageInfo.total+"】");
}
function build_bcsFyt(result){
	$("#BCFY_fyt").empty();
	var ul=$("<ul></ul>").addClass("pagination");
	var firstPageLi = $("<li @click='add'></li>").append($("<a></a>").append("首页"));
	var prePageLi = $("<li @click='add'></li>").append($("<a></a>").append("《"));
	//判断如果没有上一页，就设置为不可点击 
	if(result.extend.bCPageInfo.hasPreviousPage==false){
		firstPageLi.addClass("disabled");
		prePageLi.addClass("disabled");
	}else{
		//为元素添加点击翻页的事件
		firstPageLi.click(function(){
			getBianChengBooks(1)
		});
		prePageLi.click(function(){
			getBianChengBooks(result.extend.bCPageInfo.pageNum -1);
		});
		}
	var nextPageLi = $("<li @click='add'></li>").append($("<a></a>").append("》"));
	var lastPageLi = $("<li @click='add'></li>").append($("<a></a>").append("尾页"));
	if(result.extend.bCPageInfo.hasNextPage==false){
		nextPageLi.addClass("disabled");
		lastPageLi.addClass("disabled");
	}else{
		nextPageLi.click(function(){
			getBianChengBooks(result.extend.bCPageInfo.pageNum +1);
		});
		lastPageLi.click(function(){
			getBianChengBooks(result.extend.bCPageInfo.pages);
		});
	}
	ul.append(firstPageLi).append(prePageLi);
	//遍历 出 页数导航条--》 navigatepageNums
	$.each(result.extend.bCPageInfo.navigatepageNums,function(index,item){
		var numLi = $("<li @click='add'></li>").append($("<a></a>").append(item));
		if(result.extend.bCPageInfo.pageNum==item){
			numLi.addClass("active");
		}
		numLi.click(function(){
			getBianChengBooks(item);
		})
		ul.append(numLi);
	})
	ul.append(nextPageLi).append(lastPageLi);
	var navEle=$("<nav></nav>").append(ul);
	navEle.appendTo("#BCFY_fyt");
}
//处理设计书
function getSheJiBooks(currPageNum){
	
	$.ajax({
		url:PATH+"/getSheJiBooks",
		data:"currPageNum="+currPageNum,
		type:"GET",
		success:function(result){
			addSheJiBooks(result)
			build_sjsFyinfo(result)
			build_sjsFyt(result)
		}
	});
}
//把设计类的书本插入到div
function addSheJiBooks(result){
	$("#sheji_book_ul").empty();
	$.each(result.extend.SJPageInfo.list,function(index,item){
		//alert(item.bookName)
		var bookImgBt=$("<img >");
		bookImgBt.attr("src",item.bookPhoto);
		var bookNameBt=$("<span></span>").append("书名："+item.bookName).append($("<br>"))
		var bookDescBt=$("<span></span>").append("描述："+item.bookDesc).append($("<br>"))
		var bookBT=$("<button class='btn btn-info jieShu'></button>").append("借书").attr("bookId",item.bookId);
		var bookDiv=$("<div class='sheji_book_content'>").append(bookNameBt).append(bookDescBt).append(bookBT)
		$("<li></li>").append(bookImgBt).append(bookDiv).appendTo(".sheji_book_ul");
	})
}
//分页信息
function build_sjsFyinfo(result){
	
	$(".SJFY_info").empty();
	$(".SJFY_info").append("当前页数【"+result.extend.SJPageInfo.pageNum+"】总记录数【"+result.extend.SJPageInfo.total+"】");
}
function build_sjsFyt(result){
	$("#SJFY_fyt").empty();
	var ul=$("<ul></ul>").addClass("pagination");
	var firstPageLi = $("<li @click='add'></li>").append($("<a></a>").append("首页"));
	var prePageLi = $("<li @click='add'></li>").append($("<a></a>").append("《"));
	//判断如果没有上一页，就设置为不可点击 
	if(result.extend.SJPageInfo.hasPreviousPage==false){
		firstPageLi.addClass("disabled");
		prePageLi.addClass("disabled");
	}else{
		//为元素添加点击翻页的事件
		firstPageLi.click(function(){
			getSheJiBooks(1)
		});
		prePageLi.click(function(){
			getSheJiBooks(result.extend.SJPageInfo.pageNum -1);
		});
		}
	var nextPageLi = $("<li @click='add'></li>").append($("<a></a>").append("》"));
	var lastPageLi = $("<li @click='add'></li>").append($("<a></a>").append("尾页"));
	if(result.extend.SJPageInfo.hasNextPage==false){
		nextPageLi.addClass("disabled");
		lastPageLi.addClass("disabled");
	}else{
		nextPageLi.click(function(){
			getSheJiBooks(result.extend.SJPageInfo.pageNum +1);
		});
		lastPageLi.click(function(){
			getSheJiBooks(result.extend.SJPageInfo.pages);
		});
	}
	ul.append(firstPageLi).append(prePageLi);
	//遍历 出 页数导航条--》 navigatepageNums
	$.each(result.extend.SJPageInfo.navigatepageNums,function(index,item){
		var numLi = $("<li @click='add'></li>").append($("<a></a>").append(item));
		if(result.extend.SJPageInfo.pageNum==item){
			numLi.addClass("active");
		}
		numLi.click(function(){
			getSheJiBooks(item);
		})
		ul.append(numLi);
	})
	ul.append(nextPageLi).append(lastPageLi);
	var navEle=$("<nav></nav>").append(ul);
	navEle.appendTo("#SJFY_fyt");
}



//处理电商
function getDianShangBooks(currPageNum){
	$.ajax({
		url:PATH+"/getDianShangBooks",
		data:"currPageNum="+currPageNum,
		type:"GET",
		success:function(result){
			addDianShangBooks(result)
			build_dsFyinfo(result)
			build_dsFyt(result)
		}
	});
}
//把电商类的书本插入到div
function addDianShangBooks(result){
	$("#dianshang_book_ul").empty();
	$.each(result.extend.DSPageInfo.list,function(index,item){
		//alert(item.bookName)
		var bookImgBt=$("<img >");
		bookImgBt.attr("src",item.bookPhoto);
		var bookNameBt=$("<span></span>").append("书名："+item.bookName).append($("<br>"))
		var bookDescBt=$("<span></span>").append("描述："+item.bookDesc).append($("<br>"))
		var bookBT=$("<button class='btn btn-info jieShu'></button>").append("借书").attr("bookId",item.bookId);
		var bookDiv=$("<div class='dianshang_book_content'>").append(bookNameBt).append(bookDescBt).append(bookBT)
		$("<li></li>").append(bookImgBt).append(bookDiv).appendTo(".dianshang_book_ul");
	})
}
//分页信息
function build_dsFyinfo(result){
	
	$(".DSFY_info").empty();
	$(".DSFY_info").append("当前页数【"+result.extend.DSPageInfo.pageNum+"】总记录数【"+result.extend.DSPageInfo.total+"】");
}
function build_dsFyt(result){
	$("#DSFY_fyt").empty();
	var ul=$("<ul></ul>").addClass("pagination");
	var firstPageLi = $("<li @click='add'></li>").append($("<a></a>").append("首页"));
	var prePageLi = $("<li @click='add'></li>").append($("<a></a>").append("《"));
	//判断如果没有上一页，就设置为不可点击 
	if(result.extend.DSPageInfo.hasPreviousPage==false){
		firstPageLi.addClass("disabled");
		prePageLi.addClass("disabled");
	}else{
		//为元素添加点击翻页的事件
		firstPageLi.click(function(){
			getDianShangBooks(1)
		});
		prePageLi.click(function(){
			getDianShangBooks(result.extend.DSPageInfo.pageNum -1);
		});
		}
	var nextPageLi = $("<li @click='add'></li>").append($("<a></a>").append("》"));
	var lastPageLi = $("<li @click='add'></li>").append($("<a></a>").append("尾页"));
	if(result.extend.DSPageInfo.hasNextPage==false){
		nextPageLi.addClass("disabled");
		lastPageLi.addClass("disabled");
	}else{
		nextPageLi.click(function(){
			getDianShangBooks(result.extend.DSPageInfo.pageNum +1);
		});
		lastPageLi.click(function(){
			getDianShangBooks(result.extend.DSPageInfo.pages);
		});
	}
	ul.append(firstPageLi).append(prePageLi);
	//遍历 出 页数导航条--》 navigatepageNums
	$.each(result.extend.DSPageInfo.navigatepageNums,function(index,item){
		var numLi = $("<li @click='add'></li>").append($("<a></a>").append(item));
		if(result.extend.DSPageInfo.pageNum==item){
			numLi.addClass("active");
		}
		numLi.click(function(){
			getDianShangBooks(item);
		})
		ul.append(numLi);
	})
	ul.append(nextPageLi).append(lastPageLi);
	var navEle=$("<nav></nav>").append(ul);
	navEle.appendTo("#DSFY_fyt");
}
//借书
$(document).on("click",".jieShu",function(){
	bookId=$(this).attr("bookid");
	$.ajax({
		url:PATH+"/jieShu",
		type:"GET",
		data:"bookId="+bookId+"&stuId="+stuId+"&stuStatus="+stuStatus,
		success:function(result){
			alert(result.msg)
		}
	})
})