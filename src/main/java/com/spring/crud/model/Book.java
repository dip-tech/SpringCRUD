package com.spring.crud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue
	private Long BOOK_ID;
	private String BOOK_TITLE;
	private String BOOK_AUTHOR;
	private String BOOK_TYPE;
	private Integer BOOK_PRICE;

	public Book() {

	}

	public Book(Long bOOK_ID, String bOOK_TITLE, String bOOK_AUTHOR, String bOOK_TYPE, Integer bOOK_PRICE) {
		BOOK_ID = bOOK_ID;
		BOOK_TITLE = bOOK_TITLE;
		BOOK_AUTHOR = bOOK_AUTHOR;
		BOOK_TYPE = bOOK_TYPE;
		BOOK_PRICE = bOOK_PRICE;
	}

	public Long getBOOK_ID() {
		return BOOK_ID;
	}

	public void setBOOK_ID(Long bOOK_ID) {
		BOOK_ID = bOOK_ID;
	}

	public String getBOOK_TITLE() {
		return BOOK_TITLE;
	}

	public void setBOOK_TITLE(String bOOK_TITLE) {
		BOOK_TITLE = bOOK_TITLE;
	}

	public String getBOOK_AUTHOR() {
		return BOOK_AUTHOR;
	}

	public void setBOOK_AUTHOR(String bOOK_AUTHOR) {
		BOOK_AUTHOR = bOOK_AUTHOR;
	}

	public String getBOOK_TYPE() {
		return BOOK_TYPE;
	}

	public void setBOOK_TYPE(String bOOK_TYPE) {
		BOOK_TYPE = bOOK_TYPE;
	}

	public Integer getBOOK_PRICE() {
		return BOOK_PRICE;
	}

	public void setBOOK_PRICE(Integer bOOK_PRICE) {
		BOOK_PRICE = bOOK_PRICE;
	}

	@Override
	public String toString() {
		return "Book [BOOK_ID=" + BOOK_ID + ", BOOK_TITLE=" + BOOK_TITLE + ", BOOK_AUTHOR=" + BOOK_AUTHOR
				+ ", BOOK_TYPE=" + BOOK_TYPE + ", BOOK_PRICE=" + BOOK_PRICE + "]";
	}

}
