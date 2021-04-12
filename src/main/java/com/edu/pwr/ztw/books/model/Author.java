package com.edu.pwr.ztw.books.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

public class Author {
    private UUID id;
    private String firstName;
    private String lastName;

    public Author(@JsonProperty("id") UUID id, @JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public UUID getId() {
        return id;
    }

}
