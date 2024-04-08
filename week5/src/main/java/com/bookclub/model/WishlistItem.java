/*
    Walls, Craig (2022, March 1). Spring in Action (6th ed.). 
        Manning.
    Additional modifications by C. Bellar 2024
*/
package com.bookclub.model;

/** imports */
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;

public class WishlistItem {

    @NotNull
    @NotEmpty(message = "ISBN is a required field.")
    private String isbn; // Sets the isbn of a wishlist item.

    @NotNull
    @NotEmpty(message = "Title is a required field.")
    private String title; // Sets the title of a wishlist item.

    @Id
    private String id; // Sets the id of a wishlist item.

    /**
     * Default Constructor which is used to create a WishlistItem object.
     * @return none.
     */
    public WishlistItem(){}

     /**
     * Constructor with two arguments, which are used to create a WishlistItem object.
     * @param isbn String 
     * @param title String
     * @return none.
     */
    public WishlistItem(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    } // end WishlistItem

    /**
     * Method which is used to override the WishlistItem object's toString.
     * @return a String of WishlistItem details.
     */
    @Override
    public String toString() {
        return String.format("WishlistItem{id=%s, isbn=%s, title=%s}", id, isbn, title);
    } // end toString

    /** Getters */
    public String getIsbn() {
        return isbn;
    } // end getIsbn

    public String getTitle() {
        return title;
    } // end getTitle

    public String getId() {
        return id;
    } // end getId

    /** Setters */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    } // end setIsbn

    public void setTitle(String title) {
        this.title = title;
    } // end setTitle
} // end WishlistItem
