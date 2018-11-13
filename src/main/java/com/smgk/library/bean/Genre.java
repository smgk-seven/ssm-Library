package com.smgk.library.bean;

import java.util.List;

public class Genre {
    private Integer genreId;

    private String genreName;
    
    private List<Book>books;
    
    public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Integer getGenreId() {
        return genreId;
    }

    public void setGenreId(Integer genreId) {
        this.genreId = genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName == null ? null : genreName.trim();
    }

	@Override
	public String toString() {
		return "Genre [genreId=" + genreId + ", genreName=" + genreName + ", books=" + books + "]";
	}
    
    
}