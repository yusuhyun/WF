package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.demo.vo.Book;
import com.example.demo.vo.BookID;

public interface BookService {

	List<Book> selectAll();

	Optional<Book> searchBook(BookID bookId);

	void insertBook(Book book);

	Optional<Book> find(BookID bookId, Book book, String bookName);

	Book deleteBook(BookID bookId);

	
	
	
}
