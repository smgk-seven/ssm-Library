package com.smgk.library.bean;

import java.util.List;

public class Student {
    private Integer stuId;

    private String stuName;

    private String stuSex;

    private String stuEmail;

    private String stuStatus;

    private String stuCard;

    private String stuPwd;
    
    //用于存储多个借书记录
    private List<Lead>lends;
    
    //用于存储多个书的信息
    private List<Book> books;
    
    

    public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public List<Lead> getLends() {
		return lends;
	}

	public void setLends(List<Lead> lends) {
		this.lends = lends;
	}

	public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex == null ? null : stuSex.trim();
    }

    public String getStuEmail() {
        return stuEmail;
    }

    public void setStuEmail(String stuEmail) {
        this.stuEmail = stuEmail == null ? null : stuEmail.trim();
    }

    public String getStuStatus() {
        return stuStatus;
    }

    public void setStuStatus(String stuStatus) {
        this.stuStatus = stuStatus == null ? null : stuStatus.trim();
    }

    public String getStuCard() {
        return stuCard;
    }

    public void setStuCard(String stuCard) {
        this.stuCard = stuCard == null ? null : stuCard.trim();
    }

    public String getStuPwd() {
        return stuPwd;
    }

    public void setStuPwd(String stuPwd) {
        this.stuPwd = stuPwd == null ? null : stuPwd.trim();
    }

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(Integer stuId, String stuName, String stuSex, String stuEmail, String stuStatus, String stuCard,
			String stuPwd) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
		this.stuSex = stuSex;
		this.stuEmail = stuEmail;
		this.stuStatus = stuStatus;
		this.stuCard = stuCard;
		this.stuPwd = stuPwd;
	}

	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", stuName=" + stuName + ", stuSex=" + stuSex + ", stuEmail=" + stuEmail
				+ ", stuStatus=" + stuStatus + ", stuCard=" + stuCard + ", stuPwd=" + stuPwd + ", lends=" + lends
				+ ", books=" + books + "]";
	}
    
}