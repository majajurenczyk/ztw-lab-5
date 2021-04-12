package com.edu.pwr.ztw.books.model;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Book {
    private UUID id;
    private String title;
    private UUID author;
    private int numberOfPages;

    public Book(@JsonProperty("id") UUID id, @JsonProperty("title") String title,  @JsonProperty("author") UUID author, @JsonProperty("pages") int numberOfPages){
        this.id = id;
        this.title = title;
        this.author = author;
        this.numberOfPages = numberOfPages;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public UUID getAuthor() {
        return author;
    }

    public void setAuthor(UUID author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id ;
    }
}
