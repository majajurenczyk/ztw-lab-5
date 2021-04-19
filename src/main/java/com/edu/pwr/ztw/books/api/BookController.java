package com.edu.pwr.ztw.books.api;
import com.edu.pwr.ztw.books.model.Book;
import com.edu.pwr.ztw.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(@Qualifier("bookService") BookService bookService){
        this.bookService = bookService;
    }

    @RequestMapping(path = "books/add", method = RequestMethod.POST)
    public ResponseEntity<Book> addBook(@RequestBody @NonNull Book book){
        Book res = bookService.addBook(book);
        if(res != null){
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @RequestMapping(path = "books/get", method = RequestMethod.GET)
    public Collection<Book> getBooks(){
        return bookService.getBooks();
    }

    @RequestMapping(path = "books/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<Book> getBookById(@PathVariable("id") UUID id){
        Book res = bookService.getBookById(id).orElse(null);
        if(res != null){
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "books/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteBookById(@PathVariable("id") UUID id){
        int res = bookService.deleteBookById(id);
        if(res != -1) {
            return new ResponseEntity<>("book deleted", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("book cannot be deleted", HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(path = "books/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Book> updateBookById(@PathVariable("id") UUID id, @NonNull @RequestBody Book bookToUpdate){
        Book res = bookService.updateBookById(id, bookToUpdate);
        if(res != null){
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        else{
            return  new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
