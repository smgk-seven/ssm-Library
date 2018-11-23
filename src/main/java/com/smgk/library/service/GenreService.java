package com.smgk.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smgk.library.bean.Genre;
import com.smgk.library.dao.GenreMapper;

@Service
public class GenreService {
	@Autowired
	private GenreMapper genreMapper;

	public Genre getGenreInBook(Integer genId) {
		return genreMapper.getGenreAndAllBookById(genId);
	}

	public List<Genre> getAllGenre() {
		return genreMapper.selectByExample(null);
	}
	
	
	
	
}
