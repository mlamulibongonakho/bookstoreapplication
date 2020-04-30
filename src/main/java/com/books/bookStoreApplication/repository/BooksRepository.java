package com.books.bookStoreApplication.repository;

import com.books.bookStoreApplication.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BooksRepository extends CrudRepository<Book, Long> {
}
