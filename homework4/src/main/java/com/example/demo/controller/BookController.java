package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.BookService;
import com.example.demo.vo.Book;
import com.example.demo.vo.BookID;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Api(tags = { "도서관리프로그램 API" })
@RestController
@RequestMapping("/library")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	// 전체조회
	@ApiOperation(value="도서 전체조회", notes="전체 도서를 조회합니다.")
	@GetMapping
	public List<Book> selectAll() {
		List<Book> book = bookService.selectAll();
		return book;
	}
	
	// 도서검색
	@ApiOperation(value="도서 검색", notes="도서코드로 책을 검색합니다.")
	@GetMapping("/{bookKey}")
	public Optional<Book> searchBook(BookID bookId) {
		Optional<Book> book = bookService.searchBook(bookId);
		
		return book;
	}
	
	// 도서추가
	@ApiOperation(value="도서 추가", notes="신규 도서를 추가합니다.")
	@PostMapping
	public Book insertBook(BookID bookId, Book book) {
		System.out.println("책제목 보이냐 : " +book);
		System.out.println("책제목 보이냐 : " +bookId);
		String bookKey = UUID.randomUUID().toString();
		BookID bId = new BookID(bookKey, bookId.getBookName());
		book.setBookID(bId);
		bookService.insertBook(book);
		return book;
	}
	
	// 도서수정
	@ApiOperation(value="도서 수정", notes="도서 정보를 수정합니다.")
	@PutMapping("/{bookKey}")
	public Optional<Book> updateBook(BookID bookId,Book book,@Param("bookName")String bookName) {
//		BookID bookId = new BookID(bookKey, bookName);
//		book.setBookID(bookId);
//		book.setWriter(book.getWriter());
//		book.setCategory(book.getCategory());
//		bookService.updateBook(bookKey,book);
		
		return bookService.find(bookId, book, bookName);
	}
	
	// 도서삭제
	@ApiOperation(value="도서 삭제", notes="등록된 도서를 삭제합니다.")
	@DeleteMapping("/{bookKey}")
	public Book deleteBook(BookID bookId) {
		return bookService.deleteBook(bookId);
	}
	
}
