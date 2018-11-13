package com.smgk.library.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Lead {
    private Integer lendId;

    private Integer lendNum;

    private Date lendTime;

    private String lendStatus;

    private Integer lendStu;

    private Integer lendBook;
    
    private Student student;
    
    private Book book;
    
    

    public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Integer getLendId() {
        return lendId;
    }

    public void setLendId(Integer lendId) {
        this.lendId = lendId;
    }

    public Integer getLendNum() {
        return lendNum;
    }

    public void setLendNum(Integer lendNum) {
        this.lendNum = lendNum;
    }
    @DateTimeFormat(pattern="yyyy-MM-dd")
    public Date getLendTime() {
        return lendTime;
    }

    public void setLendTime(Date lendTime) {
        this.lendTime = lendTime;
    }

    public String getLendStatus() {
        return lendStatus;
    }

    public void setLendStatus(String lendStatus) {
        this.lendStatus = lendStatus == null ? null : lendStatus.trim();
    }

    public Integer getLendStu() {
        return lendStu;
    }

    public void setLendStu(Integer lendStu) {
        this.lendStu = lendStu;
    }

    public Integer getLendBook() {
        return lendBook;
    }

    public void setLendBook(Integer lendBook) {
        this.lendBook = lendBook;
    }

	@Override
	public String toString() {
		return "Lead [lendId=" + lendId + ", lendNum=" + lendNum + ", lendTime=" + lendTime + ", lendStatus="
				+ lendStatus + ", lendStu=" + lendStu + ", lendBook=" + lendBook + ", student=" + student + ", book="
				+ book + "]";
	}

	
    
}