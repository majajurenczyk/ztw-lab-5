package com.edu.pwr.ztw.books.api;

import com.edu.pwr.ztw.books.model.Author;
import com.edu.pwr.ztw.books.model.Book;
import com.edu.pwr.ztw.books.service.AuthorService;
import com.edu.pwr.ztw.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.Collection;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(@Qualifier("authorService") AuthorService authorService){
        this.authorService = authorService;
    }

    @RequestMapping(path = "authors/add", method = RequestMethod.POST)
    public ResponseEntity<Author> addAuthor(@RequestBody @NonNull Author author){
        Author res = authorService.addAuthor(author);
        if(res != null){
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "authors/get", method = RequestMethod.GET)
    public Collection<Author> getAuthors(){
        return authorService.getAuthors();
    }

    @RequestMapping(path = "authors/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<Author> getAuthorById(@PathVariable("id") UUID id){
        Author res = authorService.getAuthorById(id).orElse(null);
        if(res != null){
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "authors/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAuthorById(@PathVariable("id") UUID id){
        int res = authorService.deleteAuthorById(id);
        if(res != -1){
            return new ResponseEntity<>("author deleted", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("author cannot be deleted", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "authors/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Author> updateAuthorById(@PathVariable("id") UUID id, @NonNull @RequestBody Author authorToUpdate){
        Author res = authorService.updateAuthorById(id, authorToUpdate);
        if(res != null){
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @RequestMapping(path = "authors/getbooks/{id}", method = RequestMethod.GET)
    public Collection<Book> getAuthorBooks(@PathVariable("id") UUID id){
        return authorService.getAuthorBooks(id);
    }
}
