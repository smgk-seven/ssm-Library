package com.smgk.library.bean;

public class LeadInfo {
	private int lendBookCount;
	private int yiHuan;
	private int daiHuan;
	public int getLendBookCount() {
		return lendBookCount;
	}
	public void setLendBookCount(int lendBookCount) {
		this.lendBookCount = lendBookCount;
	}
	public int getYiHuan() {
		return yiHuan;
	}
	public void setYiHuan(int yiHuan) {
		this.yiHuan = yiHuan;
	}
	public int getDaiHuan() {
		return daiHuan;
	}
	public void setDaiHuan(int daiHuan) {
		this.daiHuan = daiHuan;
	}
	public LeadInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LeadInfo(int lendBookCount, int yiHuan, int daiHuan) {
		super();
		this.lendBookCount = lendBookCount;
		this.yiHuan = yiHuan;
		this.daiHuan = daiHuan;
	}
	

}
