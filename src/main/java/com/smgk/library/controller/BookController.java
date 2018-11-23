package com.smgk.library.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smgk.library.bean.Book;
import com.smgk.library.bean.BookInfo;
import com.smgk.library.bean.Lead;
import com.smgk.library.bean.Msg;
import com.smgk.library.service.BookService;
import com.smgk.library.service.LeadService;

@Controller
public class BookController {
	@Autowired
	private LeadService leadService;
	@Autowired
	private BookService bookService;
	//处理编程书
	@RequestMapping("/getBianChengBooks")
	@ResponseBody
	public Msg getBianChengBooks(@RequestParam("currPageNum") Integer currPageNum){
		PageHelper.startPage(currPageNum, 6);
		List<Book> BCBs = bookService.getBookAndGenreByBook_genreId(1);
		PageInfo <Book>bCPageInfo=new PageInfo<Book>(BCBs, 5);
		System.out.println(bCPageInfo);
		return Msg.success().add("bCPageInfo", bCPageInfo);
	}
	//处理编程书
	@RequestMapping("/getSheJiBooks")
	@ResponseBody
	public Msg getSheJiBooks(@RequestParam("currPageNum") Integer currPageNum){
		PageHelper.startPage(currPageNum, 6);
		List<Book> BCBs = bookService.getBookAndGenreByBook_genreId(2);
		PageInfo <Book>SJPageInfo=new PageInfo<Book>(BCBs, 5);
		System.out.println(SJPageInfo);
		return Msg.success().add("SJPageInfo", SJPageInfo);
	}
	//处理编程书
	@RequestMapping("/getDianShangBooks")
	@ResponseBody
	public Msg getDianShangBooks(@RequestParam("currPageNum") Integer currPageNum){
		PageHelper.startPage(currPageNum, 6);
		List<Book> BCBs = bookService.getBookAndGenreByBook_genreId(3);
		PageInfo <Book>DSPageInfo=new PageInfo<Book>(BCBs, 5);
		System.out.println(DSPageInfo);
		return Msg.success().add("DSPageInfo", DSPageInfo);
	}
	
	//获取书本信息  书 类别  书总数，借出数  ，已还数
	@RequestMapping("/getBooks")
	@ResponseBody
	public Msg getBooks(@RequestParam(value="pageNum") Integer pageNum){
		List<Lead> lends = leadService.getAllLead();
		//System.out.println(pageNum);
		int daihuan=0;
		int yihuan=0;
		for(Lead l:lends){
			if(l.getLendStatus().equals("0")){
				daihuan++;
			}else{
				yihuan++;
			}
		}
		BookInfo bookInfo=new BookInfo(lends.size(),daihuan,yihuan);
		PageHelper.startPage(pageNum, 5);
		List<Book> books = bookService.getAllBookGenre();
		PageInfo pageInfo=new PageInfo(books,5);
		
		return Msg.success().add("bookInfo", bookInfo).add("pageInfo", pageInfo);
	}
	//删除书
	@RequestMapping("/delBook")
	@ResponseBody
	public Msg delBook(@RequestParam(value="bookId") Integer bookId){
		bookService.deleteBook(bookId);
		return Msg.success();
	}
	//添加书
	@RequestMapping(value="/addBook",method=RequestMethod.POST)
	@ResponseBody
	public Msg addBook(Book book){
		book.setBookTime(new Date());
		System.out.println(book);
		bookService.addBook(book);
		return Msg.success();
	}
	//获取要修改的书
	@RequestMapping("/getBook")
	@ResponseBody
	public Msg getBook(@RequestParam(value="bookId") Integer bookId){
		Book book = bookService.getbookById(bookId);
		System.out.println("要修改的书："+bookId);
		return Msg.success().add("book", book);
	}
	@RequestMapping(value="/editBook",method=RequestMethod.POST)
	@ResponseBody
	public Msg editBook(Book book){
		book.setBookTime(book.getBookTime());
		System.out.println("修改："+book);
		bookService.editBook(book);
		return Msg.success();
	}
}
