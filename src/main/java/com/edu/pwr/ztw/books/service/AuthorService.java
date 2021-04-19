package com.edu.pwr.ztw.books.service;

import com.edu.pwr.ztw.books.dao.AuthorDAO;
import com.edu.pwr.ztw.books.dao.BookDAO;
import com.edu.pwr.ztw.books.model.Author;
import com.edu.pwr.ztw.books.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

//bean - can be injected
@Service("authorService")
public class AuthorService implements IAuthorService {
    private final AuthorDAO authorDAO;
    private final BookDAO bookDAO;

    @Autowired //autowiring into interface
    public AuthorService(@Qualifier("authorDAO") AuthorDAO authorDAO, @Qualifier("bookDAO") BookDAO bookDAO){
        this.authorDAO = authorDAO;
        this.bookDAO = bookDAO;
    }

    @Override
    public Collection<Author> getAuthors() {
        return authorDAO.selectAuthors();
    }

    @Override
    public Author addAuthor(Author author) {
        return authorDAO.insertAuthor(author);
    }

    @Override
    public Optional<Author> getAuthorById(UUID id) {
        return authorDAO.selectAuthorById(id);
    }

    @Override
    public int deleteAuthorById(UUID id) {
        if (authorDAO.deleteAuthorById(id) == 1){
            return 1 + bookDAO.deleteBooksByAuthorId(id);
        }
        return 0;

    }

    @Override
    public Author updateAuthorById(UUID id, Author authorToUpdate) {
        return authorDAO.updateAuthorById(id, authorToUpdate);
    }

    @Override
    public Collection<Book> getAuthorBooks(UUID id) {
        return bookDAO.selectBooksByAuthorId(id);
    }
}
