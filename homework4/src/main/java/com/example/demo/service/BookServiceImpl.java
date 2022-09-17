package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

	// 도서 검색
	@Override
	public Optional<Book> searchBook(BookID bookId) {
		List<Book> bk = bookRepository.findAll();
		for(int i = 0; i < bk.size(); i++ ) {
			if(bookId.getBookKey().equals(bk.get(i).getBookID().getBookKey())) {
				bookId.setBookName(bk.get(i).getBookID().getBookName());
			}
		}
		Optional<Book> book = bookRepository.findById(bookId);
		return book;
	}
	

	// 도서 등록
	@Transactional
	@Override
	public void insertBook(Book book) {
		bookRepository.save(book);
	}

	// 도서 수정
	@Transactional
	@Override
	public Optional<Book> find(BookID bookId, Book book, String bookName) {
//		List<Book> bk = bookRepository.findAll();
//		for(int i = 0; i < bk.size(); i++ ) {
//			if(bookId.getBookKey().equals(bk.get(i).getBookID().getBookKey())) {
//				System.out.println("돌려진 bk.get(i).getBookID() : "+ bk.get(i).getBookID());
//				System.out.println("설정될 bookId.getBookName() : "+ bookId.getBookName());
////				bk.get(i).getBookID().setBookName(bookId.getBookName());;
//				bk.get(i).getBookID().update(bookId.getBookKey(), bookId.getBookName());
//				System.out.println("바껴야할 bk.get(i).getBookID() : "+ bk.get(i).getBookID());
//			}
//		}
//		
//		System.out.println("bookId : " + bookId);
//		System.out.println("bk 목록 : " + bk);
//		Optional<Book> newBook = bookRepository.findById(bookId);
//		if(newbook.isPresent()) {
//			return 0;
//		}
//		b.getBookID().setBookName(bookName);;
//		b.setWriter(book.getWriter());
//		b.setCategory(book.getCategory());
		
		
//		Optional<Book> newBook = searchBook(bookId);
//		newBook.get().getBookID().update(bookId.getBookKey(), bookName);;
//		Book b = newBook.get();
//		System.out.println("전 Book b : " + b);
//		System.out.println("bookId, book.getWriter(), book.getCategory() : " + bookId +", "+ book.getWriter()+", "+ book.getCategory());
//		b.update(b.getBookID(), book.getWriter(), book.getCategory());
//		System.out.println("후 Book b : " + b);
//		System.out.println("bk 목록 : " + bk);
//		
//		return newBook;
		
		
		Optional<Book> newBook = searchBook(bookId);
		//newBook.get().update(bookId, book.getWriter(), book.getCategory());
		Book b = newBook.get();
		b.setWriter(book.getWriter());
		b.setCategory(book.getCategory());
		bookRepository.save(b);
		return newBook;
	}

	// 도서 삭제
	@Override
	public Book deleteBook(BookID bookId) {
		Optional<Book> newBook = searchBook(bookId);
		bookRepository.delete(newBook.get());
		Book b = newBook.get();
		return b;
	}


	
	



}
