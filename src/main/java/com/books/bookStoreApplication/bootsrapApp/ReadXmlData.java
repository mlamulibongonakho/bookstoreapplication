package com.books.bookStoreApplication.bootsrapApp;


import com.books.bookStoreApplication.domain.Author;
import com.books.bookStoreApplication.domain.Book;
import com.books.bookStoreApplication.repository.AuthorRepository;
import com.books.bookStoreApplication.repository.BooksRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ReadXmlData implements CommandLineRunner {

    private final BooksRepository booksRepository;
    private final AuthorRepository authorRepository;

    public ReadXmlData(BooksRepository booksRepository, AuthorRepository authorRepository) {
        this.booksRepository = booksRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        ObjectMapper m = new XmlMapper();
        InputStream stream = new FileInputStream(new File("C:\\Users\\bookstore.xml"));
        TypeReference<List<Book>> reference = new TypeReference<List<Book>>(){};
        List<Book> booksList = m.readValue(stream,reference);;
        Set<Book> listOfBooks = new HashSet<>() ;

        booksList.forEach(book -> {
            Book book1 = new Book();
            book1.setCategory(book.getCategory());
            book1.setTitle(book.getTitle());
            book1.setYear(book.getYear());
            book1.setPrice(book.getPrice());

            /*loop through the list of Authors inside book*/
            book.getAuthors().forEach( author -> {
                Author author1 = new Author();
                author1.setAuthor(author.getAuthor());
               // author1.setBooks(book);
                book1.getAuthors().add(author);
            });
            listOfBooks.add(book1);
        });

        /*Persisting to a db*/
        listOfBooks.forEach(book ->{
            booksRepository.save(book);
            book.getAuthors().forEach(author -> {
                authorRepository.save(author);
            });

        });

    }
}
