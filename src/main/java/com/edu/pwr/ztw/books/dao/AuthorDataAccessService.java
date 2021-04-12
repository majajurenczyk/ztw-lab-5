package com.edu.pwr.ztw.books.dao;
import com.edu.pwr.ztw.books.model.Author;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository("authorDAO")
public class AuthorDataAccessService implements AuthorDAO {
    private static List<Author> DATABASE_AUTHORS = new ArrayList<>(Arrays.asList(new Author(UUID.randomUUID(), "Barack", "Obama"), new Author(UUID.randomUUID(), "Diana", "Brzezinska")));
    @Override
    public int insertAuthor(UUID id, Author author) {
        DATABASE_AUTHORS.add(new Author(id, author.getFirstName(), author.getLastName()));
        return 1;
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
    public int updateAuthorById(UUID id, Author author) {
        return selectAuthorById(id).map(a -> {
            int indexOfAuthorToUpdate = DATABASE_AUTHORS.indexOf(a);
            if(indexOfAuthorToUpdate >= 0){
                DATABASE_AUTHORS.set(indexOfAuthorToUpdate, author);
                return 1;
            }
            return 0;
        }).orElse(0);
    }
}
