package com.cts.sbdd.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.sbdd.entity.Book;
import com.cts.sbdd.repo.BooksRepo;

@Service
public class BooksServiceImpl implements BooksService{

	@Autowired
	private BooksRepo booksRepo;
	
	@Override
	public List<Book> getAll() {
		return booksRepo.findAll();
	}

	@Override
	public Book getById(Long bcode) {
		return booksRepo.findById(bcode).orElse(null);
	}

	@Transactional
	@Override
	public Book add(Book book) {
		return booksRepo.save(book);
	}

	@Transactional
	@Override
	public Book update(Book book) {
		return booksRepo.save(book);
	}

	@Transactional
	@Override
	public void deleteById(Long id) {
		booksRepo.deleteById(id);
	}

}
