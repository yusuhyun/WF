package com.example.demo.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BookID implements Serializable{
	
	@Column(name="bookKey", nullable =false)
	private String bookKey;
	
	@Column(name="bookName", nullable =false, unique = true)
	private String bookName;

	public BookID() {}
	
	public BookID(String bookKey, String bookName) {
		super();
		this.bookKey = bookKey;
		this.bookName = bookName;
	}

	public String getBookKey() {
		return bookKey;
	}

	public void setBookKey(String bookKey) {
		this.bookKey = bookKey;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	@Override
	public String toString() {
		return "BookID [bookKey=" + bookKey + ", bookName=" + bookName + "]";
	}
	
	public void update(String bookKey, String bookName) {
		this.bookKey = bookKey;
		this.bookName = bookName;
    }
	
	
	
	
}
