package com.edu.pwr.ztw.books.dao;

import com.edu.pwr.ztw.books.model.Book;

import java.util.*;

public interface BookDAO {
    int insertBook(UUID id, Book book);
    default int insertBook(Book book){
        UUID id = UUID.randomUUID();
        return insertBook(id, book);
    }
    List<Book> selectBooks();
    Optional<Book> selectBookByID(UUID id);
    int deleteBookById(UUID id);
    int updateBookById(UUID id, Book book);
}
