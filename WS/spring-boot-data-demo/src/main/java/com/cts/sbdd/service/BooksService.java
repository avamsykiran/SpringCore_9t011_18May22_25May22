package com.cts.sbdd.service;

import java.util.List;

import com.cts.sbdd.entity.Book;

public interface BooksService {
	List<Book> getAll();
	Book getById(Long bcode);
	Book add(Book book);
	Book update(Book book);
	void deleteById(Long id);
}
