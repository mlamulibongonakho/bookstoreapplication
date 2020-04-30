package com.books.bookStoreApplication.repository;

import com.books.bookStoreApplication.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
