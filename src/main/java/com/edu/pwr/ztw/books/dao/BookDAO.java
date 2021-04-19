package com.edu.pwr.ztw.books.dao;

import com.edu.pwr.ztw.books.model.Book;

import java.util.*;

public interface BookDAO {
    Book insertBook(UUID id, Book book);
    default Book insertBook(Book book){
        UUID id = UUID.randomUUID();
        return insertBook(id, book);
    }
    List<Book> selectBooks();
    Optional<Book> selectBookById(UUID id);
    List<Book> selectBooksByAuthorId(UUID id);
    int deleteBookById(UUID id);
    int deleteBooksByAuthorId(UUID id);
    Book updateBookById(UUID id, Book book);
}
