package com.smgk.library.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smgk.library.bean.Lead;
import com.smgk.library.dao.LeadMapper;
import com.smgk.library.util.utils;

@Service
public class LeadService {
	utils util=new utils();
	
	@Autowired
	private LeadMapper leadMapper;
	
	public List<Lead> getAllLeadBookStuInfo(){
		return leadMapper.getAllLeadBookStuInfo();
	}
	public List<Lead> getAllLead(){
		return leadMapper.selectByExample(null);
	}
	public void returnBook(Integer leadBookId, String lendStatus) {
		leadMapper.resultBook(leadBookId, lendStatus);
		
	}
	public void jieShu(Integer stuId, Integer bookId) {
		leadMapper.insertSelective(new Lead(null,util.randomNum(), new Date(), "0", stuId, bookId));
	}
	public List<Lead> getStuLendByStuId(Integer stuId) {
		return leadMapper.getStuLeadBookByStuId(stuId);
		
	}
	
}
