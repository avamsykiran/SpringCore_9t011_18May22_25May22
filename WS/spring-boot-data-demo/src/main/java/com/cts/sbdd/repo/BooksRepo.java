package com.cts.sbdd.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.sbdd.entity.Book;

public interface BooksRepo extends JpaRepository<Book, Long> {

}
