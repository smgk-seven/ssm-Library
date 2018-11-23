package com.smgk.library.bean;

import java.util.Date;

public class StuLeadInfo {
	private Integer leadBookCount;
	private String leadBookTime;
	private String leadBookStatus;
	private String leadBookPhoto;
	private String leadBookName;
	private int leadBookId;
	private Integer leadBookNum;
	
	public Integer getLeadBookCount() {
		return leadBookCount;
	}
	public void setLeadBookCount(Integer leadBookCount) {
		this.leadBookCount = leadBookCount;
	}
	public String getLeadBookTime() {
		return leadBookTime;
	}
	public void setLeadBookTime(String leadBookTime) {
		this.leadBookTime = leadBookTime;
	}
	public String getLeadBookStatus() {
		return leadBookStatus;
	}
	public void setLeadBookStatus(String leadBookStatus) {
		this.leadBookStatus = leadBookStatus;
	}
	
	public String getLeadBookPhoto() {
		return leadBookPhoto;
	}
	public void setLeadBookPhoto(String leadBookPhoto) {
		this.leadBookPhoto = leadBookPhoto;
	}
	public String getLeadBookName() {
		return leadBookName;
	}
	public void setLeadBookName(String leadBookName) {
		this.leadBookName = leadBookName;
	}
	public int getLeadBookId() {
		return leadBookId;
	}
	public void setLeadBookId(int leadBookId) {
		this.leadBookId = leadBookId;
	}
	
	public Integer getLeadBookNum() {
		return leadBookNum;
	}
	public void setLeadBookNum(Integer leadBookNum) {
		this.leadBookNum = leadBookNum;
	}
	@Override
	public String toString() {
		return "StuLeadInfo [leadBookCount=" + leadBookCount + ", leadBookTime=" + leadBookTime + ", leadBookStatus="
				+ leadBookStatus + ", leadBookPhoto=" + leadBookPhoto + ", leadBookName=" + leadBookName
				+ ", leadBookId=" + leadBookId + ", leadBookNum=" + leadBookNum + "]";
	}
	
	

}
