package com.smgk.library.bean;

public class BookInfo {
	private int bookCount;
	private int daiHuan;
	private int yiHuan;
	public int getBookCount() {
		return bookCount;
	}
	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}
	public int getDaiHuan() {
		return daiHuan;
	}
	public void setDaiHuan(int daiHuan) {
		this.daiHuan = daiHuan;
	}
	public int getYiHuan() {
		return yiHuan;
	}
	public void setYiHuan(int yiHuan) {
		this.yiHuan = yiHuan;
	}
	public BookInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookInfo(int bookCount, int daiHuan, int yiHuan) {
		super();
		this.bookCount = bookCount;
		this.daiHuan = daiHuan;
		this.yiHuan = yiHuan;
	}
	@Override
	public String toString() {
		return "BookInfo [bookCount=" + bookCount + ", daiHuan=" + daiHuan + ", yiHuan=" + yiHuan + "]";
	}
	
}
