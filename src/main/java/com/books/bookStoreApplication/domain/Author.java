package com.books.bookStoreApplication.domain;

import javax.persistence.*;

@Entity
public class Author
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String author;

   // @ManyToOne
   // private Book books;

    public Author() {

    }

    public Author(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   /* public Book getBooks() {
        return books;
    }

    public void setBooks(Book books) {
        this.books = books;
    }*/

    @Override
    public String toString() {
        return "Authors{" +
                "id=" + id +
                ", author='" + author + '\'' +
                '}';
    }
}
