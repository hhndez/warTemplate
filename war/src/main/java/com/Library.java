package com;

import javax.ws.rs.*;
import java.util.*;
import static java.lang.System.out;


@Path("/library")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class Library {

	private static Map<String, Book> books = new HashMap<>();

	static {
		out.println("Init some books");

		createBook("1111", "Title 1");
		createBook("1112", "Title 2");
		createBook("1113", "Title 3");
	}

	private static void createBook(String id, String title) {
		books.put(id, new Book(id, title));
	}

	//http://159.107.165.227:8080/war/library/books
	@GET
	@Path("/books")
	public Collection<Book> getBooks() {
		out.println("GetBooks");
		return books.values();
	}

	@GET
	@Path("/book/{isbn}")
	public Book getBook(@PathParam("isbn") String id) {
		out.println("GetBook:" + id);
		return books.get(id);
	}

	//http://159.107.165.227:8080/war/library/book/1114?title=HI
	@PUT
	@Path("/book/{isbn}")
	public Book addBook(@PathParam("isbn") String id, @QueryParam("title") String title) {
		out.println("addBook:isbn:" + id + " with title: " + title);
		Book book = new Book(id, title);
		books.put(id, book);
		return book;
	}

	@DELETE
	@Path("/book/{isbn}")
	public Book removeBook(@PathParam("isbn") String id) {
		out.println("RemoveBook:id:" + id);
		return books.remove(id);
	}
}