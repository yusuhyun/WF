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
import org.springframework.web.util.HtmlUtils;

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
		
		// HtmlUtils 사용
//		List<Book> bList = bookRepository.findAll();
//		for(int i = 0; i < bList.size(); i ++) {
//			Book b = bList.get(i);
//			BookID bId = b.getBookID();
//			bId.setBookName(HtmlUtils.htmlEscape(bId.getBookName()));
//			b.setWriter(HtmlUtils.htmlEscape(b.getWriter()));
//			b.setCategory(HtmlUtils.htmlEscape(b.getCategory()));
//		}
//		return bList;
		
		// 필터사용시 전환
		return bookRepository.findAll();
		
	}

	// 도서 검색 new
	@Override
	public Book searchBook(String bookKey) {
		
		// HtmlUtils 사용
//		List<Book> bk = bookRepository.findAll();
//		BookID bookId = new BookID();
//		bookId.setBookKey(bookKey);
//		for(int i = 0; i < bk.size(); i++ ) {
//			if(bookId.getBookKey().equals(bk.get(i).getBookID().getBookKey())) {
//				bookId.setBookName(bk.get(i).getBookID().getBookName());
//			}
//		}
//		Optional<Book> book = bookRepository.findById(bookId);
//		Book findBook = book.get();
//		bookId.setBookName(HtmlUtils.htmlEscape(bookId.getBookName()));
//		findBook.setBookID(bookId);
//		findBook.setWriter(HtmlUtils.htmlEscape(findBook.getWriter()));
//		findBook.setCategory(HtmlUtils.htmlEscape(findBook.getCategory()));
//		return findBook;
		
		
		// 필터사용시 전환
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
		findBook.setBookID(bookId);
		findBook.setWriter(findBook.getWriter());
		findBook.setCategory(findBook.getCategory());
		return findBook;
		
	}
	

	// 도서 등록
	@Transactional
	@Override
	public Book insertBook(String bookName, String writer, String category) {
		
		// HtmlUtils 사용
//		bookName = HtmlUtils.htmlEscape(bookName);
//		writer = HtmlUtils.htmlEscape(writer);
//		category = HtmlUtils.htmlEscape(category);
//		Book newBook = new Book();
//		BookID cBookId = checkBook(bookName);
//		String bookKey = UUID.randomUUID().toString();
//		BookID bId = new BookID(bookKey, bookName);
//		newBook.setBookID(bId);
//		newBook.setWriter(writer);
//		newBook.setCategory(category);
//		bookRepository.save(newBook);
//		return newBook;
		
		// 필터사용시 전환
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
	public Book Update(String bookKey, String bookName, String writer, String category) {
//	public Book Update(BookID bookId, Book book) {
		
		// HtmlUtils 사용
//		Book findBook = searchBook(HtmlUtils.htmlEscape(bookId.getBookKey()));
//		Book b = findBook;
//		b.setWriter(HtmlUtils.htmlEscape(book.getWriter()));
//		b.setCategory(HtmlUtils.htmlEscape(book.getCategory()));
//		bookRepository.save(b);
//		return findBook;
		
		// 필터사용시 전환
		BookID bookId = new BookID(bookKey,bookName);
		
		Book findBook = searchBook(bookId.getBookKey());
		Book b = findBook;
		b.setWriter(writer);
		b.setCategory(category);
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
