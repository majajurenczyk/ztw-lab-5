package com.edu.pwr.ztw.books.api;

import com.edu.pwr.ztw.books.model.Book;
import com.edu.pwr.ztw.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

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

    @RequestMapping(path = "books/get/{id}", method = RequestMethod.GET)
    public Book getBookById(@PathVariable("id") UUID id){
        return bookService.getBookById(id).orElse(null);
    }

    @RequestMapping(path = "books/delete/{id}", method = RequestMethod.DELETE)
    public void deleteBookById(@PathVariable("id") UUID id){
        bookService.deleteBook(id);
    }

    @RequestMapping(path = "books/update/{id}", method = RequestMethod.PUT)
    public void updateBookById(@PathVariable("id") UUID id, @NonNull @RequestBody Book bookToUpdate){
        bookService.updateBook(id, bookToUpdate);
    }
}
