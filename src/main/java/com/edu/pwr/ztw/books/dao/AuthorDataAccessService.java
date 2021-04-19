package com.edu.pwr.ztw.books.dao;
import com.edu.pwr.ztw.books.model.Author;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository("authorDAO")
public class AuthorDataAccessService implements AuthorDAO {
    private static List<Author> DATABASE_AUTHORS = new ArrayList<>();

    @Override
    public Author insertAuthor(UUID id, Author author) {
        Author newAuth = new Author(id, author.getFirstName(), author.getLastName());
        DATABASE_AUTHORS.add(newAuth);
        return newAuth;
    }

    @Override
    public List<Author> selectAuthors() {
        return DATABASE_AUTHORS;
    }

    @Override
    public Optional<Author> selectAuthorById(UUID id) {
        return DATABASE_AUTHORS.stream()
                .filter(author -> author.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteAuthorById(UUID id) {
        Optional<Author> foundAuthor = selectAuthorById(id);
        if(foundAuthor.isPresent()){
            DATABASE_AUTHORS.remove(foundAuthor.get());
            return 1;
        }
        else{
            return 0;
        }
    }

    @Override
    public Author updateAuthorById(UUID id, Author author) {
        return selectAuthorById(id).map(a -> {
            int indexOfAuthorToUpdate = DATABASE_AUTHORS.indexOf(a);
            if(indexOfAuthorToUpdate >= 0){
                DATABASE_AUTHORS.set(indexOfAuthorToUpdate, author);
                return author;
            }
            return null;
        }).orElse(null);
    }
}
