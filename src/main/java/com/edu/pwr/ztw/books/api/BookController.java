package com.edu.pwr.ztw.books.api;

import com.edu.pwr.ztw.books.model.Book;
import com.edu.pwr.ztw.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @RequestMapping(path = "books/add", method = RequestMethod.POST)
    public void addBook(@RequestBody @NonNull Book book){
        bookService.addBook(book);
    }

    @RequestMapping(path = "books/get", method = RequestMethod.GET)
    public Collection<Book> getBooks(){
        return bookService.getBooks();
    }



}
