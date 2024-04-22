/*
    Walls, Craig (2022, March 1). Spring in Action (6th ed.). 
        Manning.
    Additional modifications by C. Bellar 2024
*/
package com.bookclub.model;

/** imports */
import java.util.List;

public class Book {

    private String isbn; // Sets the isbn of a Book.
    private String title; // Sets the title of a Book.
    private String description; // Sets the description of a Book.
    private int numOfPages; // Sets the number of pages of a Book.
    private List<String> authors; // Sets a list of authors of a Book.

    /**
     * Default Constructor which is used to create a Book object.
     * @return none.
     */
    public Book(){} 

     /**
     * Constructor with five arguments, which are used to create a Book object.
     * @param isbn String 
     * @param title String
     * @param description String
     * @param numOfPages int
     * @param authors List<String>
     * @return none.
     */
    public Book(String isbn, String title, String description, int numOfPages, List<String> authors) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.numOfPages = numOfPages;
        this.authors = authors;
    } // end Book

    /**
     * Method which is used to override the Book object's toString.
     * @return a String of Book details.
     */
    @Override
    public String toString() {
        return String.format("Book{isbn=%s, title=%s, description=%s, numOfPages=%s, authors=%s}", isbn, title, description, numOfPages, authors);
    } // end toString

    /** Getters */
    public String getIsbn() {
        return isbn;
    } // end getIsbn

    public String getTitle() {
        return title;
    } // end getTitle

    public String getDescription() {
        return description;
    } // end getDescription

    public int getNumOfPages() {
        return numOfPages;
    } // end getNumOfPages

    public List<String> getAuthors() {
        return authors;
    } // end getAuthors

    /** Setters */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    } // end setIsbn

    public void setTitle(String title) {
        this.title = title;
    } // end setTitle

    public void setDescription(String description) {
        this.description = description;
    } // end setDescription

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    } // end setNumOfPages

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    } // end setAuthors
} // end Book
