package com.smgk.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smgk.library.bean.Book;
import com.smgk.library.dao.BookMapper;

@Service
public class BookService {
	@Autowired
	private BookMapper bookMapper;

	public List<Book> getBookAndGenreByBook_genreId(Integer bookGenre) {
		return bookMapper.getBookByBook_Genre(bookGenre);
		
	}
	
	//获取所有书和类别信息
	public List<Book> getAllBookGenre(){
		return bookMapper.getAllBookAndGenre();
	}

	public void deleteBook(Integer bookId) {
		bookMapper.deleteByPrimaryKey(bookId);
	}

	public void addBook(Book book) {
		bookMapper.insertSelective(book);
		
	}

	public Book getbookById(Integer bookId) {
		return bookMapper.selectByPrimaryKey(bookId);
	}

	public void editBook(Book book) {
		bookMapper.updateByPrimaryKeySelective(book);
		
	}
	
	
}
