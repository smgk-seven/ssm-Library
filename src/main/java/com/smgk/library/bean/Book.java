package com.smgk.library.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Book {
    private Integer bookId;

    private String bookName;

    private String bookDesc;

    private String bookPhoto;

    private String bookAuthor;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date bookTime;

    private Integer count;

    private Integer bookGenre;
    
    //把类别也放进来
    private Genre genre;
    
    public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookDesc() {
        return bookDesc;
    }

    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc == null ? null : bookDesc.trim();
    }

    public String getBookPhoto() {
        return bookPhoto;
    }

    public void setBookPhoto(String bookPhoto) {
        this.bookPhoto = bookPhoto == null ? null : bookPhoto.trim();
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor == null ? null : bookAuthor.trim();
    }

    public Date getBookTime() {
        return bookTime;
    }

    public void setBookTime(Date bookTime) {
        this.bookTime = bookTime;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(Integer bookGenre) {
        this.bookGenre = bookGenre;
    }

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookDesc=" + bookDesc + ", bookPhoto="
				+ bookPhoto + ", bookAuthor=" + bookAuthor + ", bookTime=" + bookTime + ", count=" + count
				+ ", bookGenre=" + bookGenre + ", genre=" + genre + "]";
	}

	
    
}