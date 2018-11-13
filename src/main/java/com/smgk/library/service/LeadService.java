package com.smgk.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smgk.library.bean.Lead;
import com.smgk.library.dao.LeadMapper;

@Service
public class LeadService {
	@Autowired
	private LeadMapper leadMapper;
	
	public List<Lead> getAllLeadBookStuInfo(){
		return leadMapper.getAllLeadBookStuInfo();
	}
}
