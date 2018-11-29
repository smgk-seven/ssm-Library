package com.smgk.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smgk.library.bean.Student;
import com.smgk.library.dao.StudentMapper;

@Service
public class StudentService {
	@Autowired
	private StudentMapper studentMapper;
	
	//获取所有用户
	public List<Student> getAllStus(){
		return studentMapper.selectByExample(null);
	}

	public void addStu(Student student) {
		studentMapper.insertSelective(student);
	}
	
	//根据学生id，查找 学生借书的信息
	public Student getStuLeadBookByStuId(Integer stuId){
		return studentMapper.getStuLeadBookByStuId(stuId);
	}

	public Student getStu(Integer stuId) {
		return studentMapper.selectByPrimaryKey(stuId);
		
	}

	public void updateStuStatus(Student stu) {
		studentMapper.updateByPrimaryKeySelective(stu);
	}
	
}
