package com.books.bookStoreApplication.controllers;

import com.books.bookStoreApplication.domain.Author;
import com.books.bookStoreApplication.domain.Book;
import com.books.bookStoreApplication.repository.BooksRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    private final BooksRepository booksRepository;

    Book book = new Book();
    public BookController(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @RequestMapping(value = "/books/getAllBooks", method = RequestMethod.GET)
    public Iterable<Book> getBooks() {
        return booksRepository.findAll();
    }

    @RequestMapping(value = "/book/createBook", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Book createBook(@RequestBody Book book) {

        return booksRepository.save(book);
    }

    @RequestMapping(value = "/book/{bookId}", method = RequestMethod.GET)
    public Optional<Book> getBookById(@PathVariable("id") Long bookId) {
        return booksRepository.findById(bookId);
    }
    @RequestMapping(value = "/book/category/{category}", method = RequestMethod.GET)
    public List<Book> getBookCat(@PathVariable("category") String Category) {

        ArrayList<Book> arrayLi = new ArrayList();
        Iterable<Book> books= booksRepository.findAll();
        books.forEach(book1 -> {
            if (book1.getCategory().equals(Category))
            {
                Book book= new Book();
                book.setId(book1.getId());
                book.setTitle(book1.getTitle());
                book.setCategory(book1.getCategory());
                book.setYear(book1.getYear());
                book.setPrice(book1.getPrice());
                book.setAuthors(book1.getAuthors());
                arrayLi.add(book);
            }
        });

        return arrayLi;
    }

    @RequestMapping(value ="/book/updateBook/{id}" , method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Book updateBook(@PathVariable(value="id") Long id, Book book)
    {
        booksRepository.save(book);
        return book;
    }

    @RequestMapping(value ="/book/deletebook/{id}" , method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable(value="id") Long id)
    {
        booksRepository.deleteById(id);
        return "Deleted successful";
    }
}
