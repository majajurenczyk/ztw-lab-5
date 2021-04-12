package com.edu.pwr.ztw.books.dao;
import com.edu.pwr.ztw.books.model.Book;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository("bookDAO")
public class BookDataAccessService implements BookDAO {

    private static List<Book> DATABASE = new ArrayList<Book>(Arrays.asList(new Book(UUID.randomUUID(), "Ziemia obiecana", "Barack Obama", 340),
                                                                            new Book(UUID.randomUUID(), "On", "Bzezinska Diana", 360)));


    @Override
    public int insertBook(UUID id, Book book) {
        DATABASE.add(new Book(id, book.getTitle(), book.getAuthor(), book.getNumberOfPages()));
        return 1;
    }

    @Override
    public List<Book> selectBooks() {
        return DATABASE;
    }

    @Override
    public Optional<Book> selectBookByID(UUID id) {
        return DATABASE.stream().filter(book -> book.getId().equals(id)).findFirst();
    }

    @Override
    public int deleteBookById(UUID id) {
        Optional<Book> foundBook = selectBookByID(id);
        if(foundBook.isPresent()){
            DATABASE.remove(foundBook.get());
            return 1;
        }
        else{
            return 0;
        }
    }

    @Override
    public int updateBookById(UUID id, Book book) {
        return selectBookByID(id).map(b -> {
            int indexOfBookToUpdate = DATABASE.indexOf(book);
            if(indexOfBookToUpdate >= 0){
                DATABASE.set(indexOfBookToUpdate, book);
                return 1;
            }
            return 0;
        }).orElse(0);
    }
}
