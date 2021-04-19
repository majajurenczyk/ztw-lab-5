package com.edu.pwr.ztw.books.dao;
import com.edu.pwr.ztw.books.model.Book;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.stream.Collectors;

@Repository("bookDAO")
public class BookDataAccessService implements BookDAO {

    private static List<Book> DATABASE_BOOKS = new ArrayList<>();


    @Override
    public Book insertBook(UUID id, Book book) {
        DATABASE_BOOKS.add(new Book(id, book.getTitle(), book.getAuthor(), book.getNumberOfPages()));
        return book;
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
    public List<Book> selectBooksByAuthorId(UUID id) {
        return DATABASE_BOOKS.stream().filter(book -> book.getAuthor().equals(id)).collect(Collectors.toList());
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
    public int deleteBooksByAuthorId(UUID id) {
        List<Book> foundBooks = selectBooksByAuthorId(id);

        int deletedCounter = 0;
        for (Book book : foundBooks) {
            DATABASE_BOOKS.remove(book);
            deletedCounter++;
        }
        return deletedCounter;
    }

    @Override
    public Book updateBookById(UUID id, Book book) {
        book.setId(id);
        return selectBookById(id).map(b -> {
            int indexOfBookToUpdate = DATABASE_BOOKS.indexOf(b);
            if(indexOfBookToUpdate >= 0){
                DATABASE_BOOKS.set(indexOfBookToUpdate, book);
                return book;
            }
            return null;
        }).orElse(null);
    }
}
