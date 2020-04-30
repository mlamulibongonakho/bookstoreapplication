package com.books.bookStoreApplication;

import com.books.bookStoreApplication.domain.Author;
import com.books.bookStoreApplication.domain.Book;
import com.books.bookStoreApplication.repository.AuthorRepository;
import com.books.bookStoreApplication.repository.BooksRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
public class BookStoreApplicationTests {


	@Autowired
	AuthorRepository authorRepository;

	@Autowired
	BooksRepository booksRepository;

	@Test
	public void contextLoads() {

		Book book = new Book("Sport","Comrade Marathon","2005",30.00);
		Author author = new Author("Mlamuli");

		book.getAuthors().add(author);

		booksRepository.save(book);
		authorRepository.save(author);


	}

}