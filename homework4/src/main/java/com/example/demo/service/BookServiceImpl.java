package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.vo.Book;
import com.example.demo.vo.BookID;
import com.example.demo.vo.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	// 전체조회
	@Override
	public List<Book> selectAll() {
		
		return bookRepository.findAll();
		
	}

	// 도서 검색 new
	@Override
	public Book searchBook(String bookKey) {
		List<Book> bk = bookRepository.findAll();
		BookID bookId = new BookID();
		bookId.setBookKey(bookKey);
		for(int i = 0; i < bk.size(); i++ ) {
			if(bookId.getBookKey().equals(bk.get(i).getBookID().getBookKey())) {
				bookId.setBookName(bk.get(i).getBookID().getBookName());
			}
		}
		Optional<Book> book = bookRepository.findById(bookId);
		Book findBook = book.get();
		return findBook;
	}
	

	// 도서 등록
	@Transactional
	@Override
	public Book insertBook(String bookName, String writer, String category) {
		Book newBook = new Book();
		BookID cBookId = checkBook(bookName);
			String bookKey = UUID.randomUUID().toString();
			BookID bId = new BookID(bookKey, bookName);
			newBook.setBookID(bId);
			newBook.setWriter(writer);
			newBook.setCategory(category);
			bookRepository.save(newBook);
			
		return newBook;
	}


	// 도서 수정
	@Override
	public Book Update(BookID bookId, Book book) {
		Book findBook = searchBook(bookId.getBookKey());
		Book b = findBook;
		b.setWriter(book.getWriter());
		b.setCategory(book.getCategory());
		bookRepository.save(b);
		return findBook;
	}
	
	
	
	// 도서 삭제
	@Override
	public Book deleteBook(String bookKey) {
		Book newBook = searchBook(bookKey);
		bookRepository.delete(newBook);
		Book b = newBook;
		return b;
	}

	// 중복이름검사
	@Override
	public BookID checkBook(String bookName) {
		List<Book> bk = bookRepository.findAll();
		BookID bookId = null;
		for(int i = 0; i < bk.size(); i++ ) {
			if(bookName.equals(bk.get(i).getBookID().getBookName())) {
				bookId = new BookID();
				bookId.setBookKey(bk.get(i).getBookID().getBookKey());
				bookId.setBookName(bookName);
			} 
		}
		return bookId;
	}



	


	
	



}
