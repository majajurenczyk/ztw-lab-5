package com.edu.pwr.ztw.books.service;

import com.edu.pwr.ztw.books.dao.AuthorDAO;
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
    private final AuthorDAO authorDAO;

    @Autowired //autowiring into interface
    public BookService(@Qualifier("bookDAO") BookDAO bookDAO, @Qualifier("authorDAO") AuthorDAO authorDAO){
        this.bookDAO = bookDAO;
        this.authorDAO = authorDAO;
    }
    @Override
    public Collection<Book> getBooks() {
        return bookDAO.selectBooks();
    }

    @Override
    public Book addBook(Book book) {
        if(authorDAO.selectAuthorById(book.getAuthor()).isPresent()){
            return bookDAO.insertBook(book);
        }
        return null;
    }

    @Override
    public Optional<Book> getBookById(UUID id) {
        return bookDAO.selectBookById(id);
    }

    @Override
    public int deleteBookById(UUID id) {
        return bookDAO.deleteBookById(id);
    }

    @Override
    public Book updateBookById(UUID id, Book bookToUpdate) {
       return bookDAO.updateBookById(id, bookToUpdate);
    }
}
