package com.edu.pwr.ztw.books.dao;
import com.edu.pwr.ztw.books.model.Book;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository("bookDAO")
public class BookDataAccessService implements BookDAO {

    private static List<Book> DATABASE_BOOKS = new ArrayList<>(Arrays.asList(new Book(UUID.randomUUID(), "Ziemia obiecana", "Barack Obama", 340),
                                                                            new Book(UUID.randomUUID(), "On", "Bzezinska Diana", 360)));


    @Override
    public int insertBook(UUID id, Book book) {
        DATABASE_BOOKS.add(new Book(id, book.getTitle(), book.getAuthor(), book.getNumberOfPages()));
        return 1;
    }

    @Override
    public List<Book> selectBooks() {
        return DATABASE_BOOKS;
    }

    @Override
    public Optional<Book> selectBookById(UUID id) {
        return DATABASE_BOOKS.stream().filter(book -> book.getId().equals(id)).findFirst();
    }

    @Override
    public int deleteBookById(UUID id) {
        Optional<Book> foundBook = selectBookById(id);
        if(foundBook.isPresent()){
            DATABASE_BOOKS.remove(foundBook.get());
            return 1;
        }
        else{
            return 0;
        }
    }

    @Override
    public int updateBookById(UUID id, Book book) {
        return selectBookById(id).map(b -> {
            int indexOfBookToUpdate = DATABASE_BOOKS.indexOf(book);
            if(indexOfBookToUpdate >= 0){
                DATABASE_BOOKS.set(indexOfBookToUpdate, book);
                return 1;
            }
            return 0;
        }).orElse(0);
    }
}
