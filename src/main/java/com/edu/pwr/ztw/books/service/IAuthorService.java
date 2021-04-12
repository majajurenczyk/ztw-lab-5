package com.edu.pwr.ztw.books.service;

import com.edu.pwr.ztw.books.model.Author;
import com.edu.pwr.ztw.books.model.Book;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface IAuthorService {
    Collection<Author> getAuthors();
    int addAuthor(Author author);
    Optional<Author> getAuthorById(UUID id);
    int deleteAuthorById(UUID id);
    int updateAuthorById(UUID id, Author authorToUpdate);
    Collection<Book> getAuthorBooks(UUID id);
}
