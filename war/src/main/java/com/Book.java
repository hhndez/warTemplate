package com;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="book")
public class Book {
	private String isbn;
	private String title;

	Book(String isbn, String title) {
		this.isbn = isbn;
		this.title = title;
	}

	@XmlElement
	public String getISBN() {
		return this.isbn;
	}

	@XmlElement
	public String getTitle() {
		return this.title;
	}

	public String toString() {
		return "{ISBN=" + this.isbn + "," + this.title + "}";
	}
}