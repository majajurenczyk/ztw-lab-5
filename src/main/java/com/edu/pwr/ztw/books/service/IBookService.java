package com.edu.pwr.ztw.books.service;
import com.edu.pwr.ztw.books.model.Book;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface IBookService {
    Collection<Book> getBooks();
    Book addBook(Book book);
    Optional<Book> getBookById(UUID id);
    int deleteBookById(UUID id);
    Book updateBookById(UUID id, Book bookToUpdate);
}
