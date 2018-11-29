package com.smgk.library.bean;

public class StuInfo {
	private int stuCount;
	private int stuBMD;
	private int stuHMD;
	public int getStuCount() {
		return stuCount;
	}
	public void setStuCount(int stuCount) {
		this.stuCount = stuCount;
	}
	public int getStuBMD() {
		return stuBMD;
	}
	public void setStuBMD(int stuBMD) {
		this.stuBMD = stuBMD;
	}
	public int getStuLMD() {
		return stuHMD;
	}
	public void setStuLMD(int stuHMD) {
		this.stuHMD = stuHMD;
	}
	@Override
	public String toString() {
		return "stuInfo [stuCount=" + stuCount + ", stuBMD=" + stuBMD + ", stuLMD=" + stuHMD + "]";
	}
	public StuInfo() {
	}
	public StuInfo(int stuCount, int stuBMD, int stuLMD) {
		super();
		this.stuCount = stuCount;
		this.stuBMD = stuBMD;
		this.stuHMD = stuLMD;
	}
	
	

}
