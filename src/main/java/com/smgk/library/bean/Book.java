package com.smgk.library.bean;

import java.util.Date;

public class Book {
    private Integer bookId;

    private String bookName;

    private String bookDesc;

    private String bookPhoto;

    private String bookAuthor;

    private Date bookTime;

    private Integer count;

    private Integer bookGenre;
    
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
        this.bookName = bookName == null ? null : bookName.trim();
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
    
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(Integer bookId, String bookName, String bookDesc, String bookPhoto, String bookAuthor, Date bookTime,
			Integer count, Integer bookGenre) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookDesc = bookDesc;
		this.bookPhoto = bookPhoto;
		this.bookAuthor = bookAuthor;
		this.bookTime = bookTime;
		this.count = count;
		this.bookGenre = bookGenre;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookDesc=" + bookDesc + ", bookPhoto="
				+ bookPhoto + ", bookAuthor=" + bookAuthor + ", bookTime=" + bookTime + ", count=" + count
				+ ", bookGenre=" + bookGenre + ", genre=" + genre + "]";
	}

	
	
    
}