/**
 * 
 */
var stuId=$("#STUID").attr("value");
var StuStatus;
var lendBookPageNum;
$(function(){
	getStuInfo();
	getStuLeadBook(1);
})
$(".stuDaoHang").click(function(){
	return false;
})
var STUID=$("#STUID").val();
function getStuInfo(pageNum){
	$.ajax({
		url:PATH+"/getStuAllInfo",
		data:"STUID="+STUID,
		type:"GET",
		success:function(result){
			addStuInfo(result);
			
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
//处理用户借书数据
function getStuLeadBook(pageNum){
	//alert(stuId)
	$.ajax({
		url:PATH+"/getStuLend",
		data:"stuId="+stuId+"&pageNum="+pageNum,
		type:"GET",
		success:function(result){
			addStuLeadBookto(result);
			addStuLBFYInfo(result);
			stuLeadFYT(result);
			buildStuLeadInfo(result);
		}
		
	})
}
function buildStuLeadInfo(result){
	$(".leadBookCount,.yiHuan,.daiHuan").empty()
	$(".leadBookCount").append(result.extend.leadInfo.lendBookCount)
	$(".yiHuan").append(result.extend.leadInfo.yiHuan)
	$(".daiHuan").append(result.extend.leadInfo.daiHuan)
}

//添加学生借书的信息
//addStuLeadBookto(result)
function addStuLeadBookto(result){
$("#stu_BorrBook_tbody").empty();
	$.each(result.extend.stuLendInfo.list,function(index,item){
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
//借书的分页信息
function addStuLBFYInfo(result){
	$(".LBFYInfo").empty();
	$(".LBFYInfo").append("总页数【"+result.extend.stuLendInfo.pageNum+"】总页数【"+result.extend.stuLendInfo.pages+"】 总记录数【"+result.extend.stuLendInfo.total+"】")
	lendBookPageNum=result.extend.stuLendInfo.pageNum;
}
//借书信息分布条
function stuLeadFYT(result){
	$(".LBFYIT").empty();
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
	navEle.appendTo(".LBFYIT");
}

//把学生借书的信息放入到div中


//还书
$(document).on("click","#huanshubtId",function(){
	if(confirm("是否还书？？")){
  		$.ajax({
  			url:PATH+"/returnBook/"+$(this).attr("lendBookId"),
  			type:"GET",
  			success:function(){
  				getStuLeadBook(lendBookPageNum);
  			}
  		})
	}
})
//利用jq跳转到书城
$("#showBooks").click(function(){
	window.location.href ='showBooks?stuId='+stuId+'&StuStatus='+StuStatus+'';
})