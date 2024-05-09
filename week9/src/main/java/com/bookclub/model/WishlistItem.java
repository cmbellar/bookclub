/*
    Walls, Craig (2022, March 1). Spring in Action (6th ed.). 
        Manning.
    Additional modifications by C. Bellar 2024
*/
package com.bookclub.model;

/** imports */
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "wishlist")
public class WishlistItem {

    @NotNull
    @NotEmpty(message = "ISBN is a required field.")
    private String isbn; // Sets the isbn of a wishlist item.

    @NotNull
    @NotEmpty(message = "Title is a required field.")
    private String title; // Sets the title of a wishlist item.

    @Id
    private String id; // Sets the id of a wishlist item.

    private String username; // Sets username associated with a wishlist item.

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
     * Constructor with three arguments, which are used to create a WishlistItem object.
     * @param isbn String 
     * @param title String
     * @param username String
     * @return none.
     */
    public WishlistItem(String isbn, String title, String username) {
        this.isbn = isbn;
        this.title = title;
        this.username = username;
    } // end WishlistItem

    /**
     * Method which is used to override the WishlistItem object's toString.
     * @return a String of WishlistItem details.
     */
    @Override
    public String toString() {
        return String.format("WishlistItem{id=%s, isbn=%s, title=%s, username=%s}", id, isbn, title, username);
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

    public String getUsername() {
        return username;
    } // end getUsername

    /** Setters */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    } // end setIsbn

    public void setTitle(String title) {
        this.title = title;
    } // end setTitle

    public void setId(String id) {
        this.id = id;
    } // end setId

    public void setUsername(String username) {
        this.username = username;
    } // end setUsername
} // end WishlistItem
