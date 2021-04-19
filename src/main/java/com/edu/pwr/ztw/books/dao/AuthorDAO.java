package com.edu.pwr.ztw.books.dao;

import com.edu.pwr.ztw.books.model.Author;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AuthorDAO {
    Author insertAuthor(UUID id, Author author);
    default Author insertAuthor(Author author){
        UUID id = UUID.randomUUID();
        return insertAuthor(id, author);
    }
    List<Author> selectAuthors();
    Optional<Author> selectAuthorById(UUID id);
    int deleteAuthorById(UUID id);
    Author updateAuthorById(UUID id, Author author);
}
