package com.smgk.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smgk.library.bean.Admin;
import com.smgk.library.dao.AdminMapper;
@Service
public class AdminService {
	@Autowired
	private AdminMapper adminMapper;
	//获取所有管理员
	public List<Admin> getAllAdmin(){
		return adminMapper.selectByExample(null);
	}
}
