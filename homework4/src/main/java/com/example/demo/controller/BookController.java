package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		return bookService.selectAll();
	}
	
	// 도서검색
	@ApiOperation(value="도서 검색", notes="도서코드로 책을 검색합니다.")
	@GetMapping("/{bookKey}")
	public Book searchBook(@RequestParam String bookKey) {
		
		return bookService.searchBook(bookKey);
	}
	
	// 도서추가
	@ApiOperation(value="도서 추가", notes="신규 도서를 추가합니다.")
	@PostMapping
	public Book insertBook(@RequestParam String bookName, @RequestParam String writer, @RequestParam String category) {
		Book newBook = bookService.insertBook(bookName, writer, category);
		return newBook;
	}
	
	// 도서수정
	@ApiOperation(value="도서 수정", notes="도서 정보를 수정합니다.")
	@PutMapping("/{bookKey}")
	public Book updateBook(@RequestParam String bookKey ,@RequestParam String bookName, @RequestParam String writer, @RequestParam String category) {
		return bookService.Update(bookKey, bookName,writer, category);
	}
	
	// 도서삭제
	@ApiOperation(value="도서 삭제", notes="등록된 도서를 삭제합니다.")
	@DeleteMapping("/{bookKey}")
	public Book deleteBook(@RequestParam String bookKey) {
		return bookService.deleteBook(bookKey);
	}
	
}
