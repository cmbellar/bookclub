/*
    Walls, Craig (2022, March 1). Spring in Action (6th ed.). 
        Manning.
    Additional modifications by C. Bellar 2024
*/
package com.bookclub.model;

public class Book {

    private String isbn; // Sets the isbn of a Book.
    private String title; // Sets the title of a Book.
    private String description; // Sets the description of a Book.
    private String infoUrl; // Sets the infoUrl of a Book.
    private int numOfPages; // Sets the number of pages of a Book.

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
     * @param infoUrl String
     * @param numOfPages int
     * @return none.
     */
    public Book(String isbn, String title, String description, String infoUrl, int numOfPages) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.infoUrl = infoUrl;
        this.numOfPages = numOfPages;
    } // end Book

    /**
     * Constructor with three arguments, which are used to create a Book object.
     * @param isbn String 
     * @param title String
     * @param infoUrl String
     * @return none.
     */
    public Book(String isbn, String title, String infoUrl) {
        this.isbn = isbn;
        this.title = title;
        this.infoUrl = infoUrl;
    } // end Book

    /**
     * Method which is used to override the Book object's toString.
     * @return a String of Book details.
     */
    @Override
    public String toString() {
        return String.format("Book{isbn=%s, title=%s, description=%s, infoUrl=%s, numOfPages=%s}", isbn, title, description, infoUrl, numOfPages);
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

    public String getInfoUrl() {
        return infoUrl;
    } // end getInfoUrl

    public int getNumOfPages() {
        return numOfPages;
    } // end getNumOfPages

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

    public void setInfoUrl (String infoUrl) {
        this.infoUrl = infoUrl;
    } // end setInfoUrl

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    } // end setNumOfPages
} // end Book
