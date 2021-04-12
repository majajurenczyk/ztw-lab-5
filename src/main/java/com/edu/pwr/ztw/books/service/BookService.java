package com.edu.pwr.ztw.books.service;

import com.edu.pwr.ztw.books.dao.BookDAO;
import com.edu.pwr.ztw.books.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

//bean - can be injected
@Service("bookService")
public class BookService implements IBookService {
    private final BookDAO bookDAO;

    @Autowired //autowiring into interface
    public BookService(@Qualifier("bookDAO") BookDAO bookDAO){
        this.bookDAO = bookDAO;
    }
    @Override
    public Collection<Book> getBooks() {
        return bookDAO.selectBooks();
    }

    @Override
    public int addBook(Book book) {
        return bookDAO.insertBook(book);
    }

    @Override
    public Optional<Book> getBookById(UUID id) {
        return bookDAO.selectBookByID(id);
    }

    @Override
    public int deleteBookById(UUID id) {
        return bookDAO.deleteBookById(id);
    }

    @Override
    public int updateBookById(UUID id, Book bookToUpdate) {
       return bookDAO.updateBookById(id, bookToUpdate);
    }
}
