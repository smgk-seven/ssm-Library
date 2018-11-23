package com.smgk.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smgk.library.bean.Book;
import com.smgk.library.bean.Genre;
import com.smgk.library.bean.Msg;
import com.smgk.library.dao.BookMapper;
import com.smgk.library.service.GenreService;

@Controller
public class GenreController {
	
	@Autowired 
	private GenreService genreService;
	
	//获取所有类别 书的信息
	/*@RequestMapping("/getAllBooks")
	@ResponseBody
	public Msg getAllBooks(){
		Genre BianChengLei = genreService.getGenreInBook(1);
		
		List<Book> BianChengBooks = BianChengLei.getBooks();
		Genre SheJiLei = genreService.getGenreInBook(2);
		List<Book> SheJiBooks = SheJiLei.getBooks();
		Genre DianShangLei = genreService.getGenreInBook(3);
		List<Book> DianShangBooks = DianShangLei.getBooks();
		
		return Msg.success().add("DianShangBooks", DianShangBooks).add("SheJiBooks", SheJiBooks).add("BianChengBooks", BianChengBooks);
	}*/
	//获取 部门
	@RequestMapping("/getGenre")
	@ResponseBody
	public Msg getGenre(){
		List<Genre> genres = genreService.getAllGenre();
		return Msg.success().add("genres", genres);
	}

}
