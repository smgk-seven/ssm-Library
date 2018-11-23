package com.smgk.library.bean;

import java.util.Date;

public class Lead {
    private Integer lendId;

    private Integer lendNum;

    private Date lendTime;

    private String lendStatus;

    private Integer lendStu;

    private Integer lendBook;
    
    private Book book;
    
    private Student student;
    
    public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}

	private String LeadBookTime;
    
    public String setTime(Date time){
    	return time.toLocaleString();
    }
    public String getLeadBookTime() {
		return setTime(this.lendTime);
	}

	public void setLeadBookTime(String leadBookTime) {
		LeadBookTime = leadBookTime;
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
	public Lead() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Lead(Integer lendId, Integer lendNum, Date lendTime, String lendStatus, Integer lendStu, Integer lendBook) {
		super();
		this.lendId = lendId;
		this.lendNum = lendNum;
		this.lendTime = lendTime;
		this.lendStatus = lendStatus;
		this.lendStu = lendStu;
		this.lendBook = lendBook;
	}
	@Override
	public String toString() {
		return "Lead [lendId=" + lendId + ", lendNum=" + lendNum + ", lendTime=" + lendTime + ", lendStatus="
				+ lendStatus + ", lendStu=" + lendStu + ", lendBook=" + lendBook + ", book=" + book + ", student="
				+ student + ", LeadBookTime=" + LeadBookTime + "]";
	}
    
}