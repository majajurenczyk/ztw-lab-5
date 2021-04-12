package com.edu.pwr.ztw.books.api;

import com.edu.pwr.ztw.books.model.Author;
import com.edu.pwr.ztw.books.model.Book;
import com.edu.pwr.ztw.books.service.AuthorService;
import com.edu.pwr.ztw.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }

    @RequestMapping(path = "authors/add", method = RequestMethod.POST)
    public void addAuthor(@RequestBody @NonNull Author author){
        authorService.addAuthor(author);
    }

    @RequestMapping(path = "authors/get", method = RequestMethod.GET)
    public Collection<Author> getAuthors(){
        return authorService.getAuthors();
    }

    @RequestMapping(path = "authors/get/{id}", method = RequestMethod.GET)
    public Author getAuthorById(@PathVariable("id") UUID id){
        return authorService.getAuthorById(id).orElse(null);
    }

    @RequestMapping(path = "authors/delete/{id}", method = RequestMethod.DELETE)
    public void deleteAuthorById(@PathVariable("id") UUID id){
        authorService.deleteAuthorById(id);
    }

    @RequestMapping(path = "authors/update/{id}", method = RequestMethod.PUT)
    public void updateAuthorById(@PathVariable("id") UUID id, @NonNull @RequestBody Author authorToUpdate){
        authorService.updateAuthorById(id, authorToUpdate);
    }
}
