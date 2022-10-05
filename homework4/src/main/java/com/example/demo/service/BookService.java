package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.demo.vo.Book;
import com.example.demo.vo.BookID;

public interface BookService {

	List<Book> selectAll();

//	Optional<Book> searchBook(BookID bookId);

	Book searchBook(String bookKey);
	
	Book deleteBook(String bookKey);

//	Book Update(BookID bookId, Book book);
	Book Update(String bookKey, String bookName, String writer, String category);

	Book insertBook(String bookName, String writer, String category);

	BookID checkBook(String bookName);




	
	
	
}
