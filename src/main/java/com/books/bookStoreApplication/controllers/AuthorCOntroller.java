package com.books.bookStoreApplication.controllers;

import com.books.bookStoreApplication.domain.Author;
import com.books.bookStoreApplication.repository.AuthorRepository;
import com.books.bookStoreApplication.repository.BooksRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@RestController
public class AuthorCOntroller {


    private final AuthorRepository authorRepository;


    public AuthorCOntroller(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    //Author
    @RequestMapping(value = "/author/authors", method = RequestMethod.GET)
    public Iterable<Author> getAuthors()
    {
        return authorRepository.findAll();
    }

    @RequestMapping(value="/author/findbyid/{id}", method = RequestMethod.GET)
    public Optional<Author> findById(@PathVariable (value = "id") Long id)
    {
        return authorRepository.findById(id);
    }
}
