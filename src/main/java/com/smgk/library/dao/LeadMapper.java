package com.smgk.library.dao;

import com.smgk.library.bean.Lead;
import com.smgk.library.bean.LeadExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LeadMapper {
    long countByExample(LeadExample example);

    int deleteByExample(LeadExample example);

    int deleteByPrimaryKey(Integer lendId);

    int insert(Lead record);

    int insertSelective(Lead record);

    List<Lead> selectByExample(LeadExample example);

    Lead selectByPrimaryKey(Integer lendId);

    int updateByExampleSelective(@Param("record") Lead record, @Param("example") LeadExample example);

    int updateByExample(@Param("record") Lead record, @Param("example") LeadExample example);

    int updateByPrimaryKeySelective(Lead record);

    int updateByPrimaryKey(Lead record);
    
    //查出所有借书记录，借书记录有  书名 学生信息的
    List<Lead> getAllLeadBookStuInfo();
    //根据学生id  查出 学生借书的记录
    List<Lead> getAllLeadBookStuInfoByStuId(Integer stuId);
}