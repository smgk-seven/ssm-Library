package com.smgk.library.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.smgk.library.bean.Book;
import com.smgk.library.bean.Genre;
import com.smgk.library.bean.GenreExample;

public interface GenreMapper {
    long countByExample(GenreExample example);

    int deleteByExample(GenreExample example);

    int deleteByPrimaryKey(Integer genreId);

    int insert(Genre record);

    int insertSelective(Genre record);

    List<Genre> selectByExample(GenreExample example);

    Genre selectByPrimaryKey(Integer genreId);

    int updateByExampleSelective(@Param("record") Genre record, @Param("example") GenreExample example);

    int updateByExample(@Param("record") Genre record, @Param("example") GenreExample example);

    int updateByPrimaryKeySelective(Genre record);

    int updateByPrimaryKey(Genre record);
    
    //通过类别id，把这一类中的书也查找出来
   Genre getGenreAndAllBookById(Integer genreId);
    
}