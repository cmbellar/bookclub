package com.bookclub.model;

/** imports */
import javax.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

public class BookOfTheMonth {

    @Id
    private String id; // Sets the id of a BookOfTheMonth item.

    private int month; // Sets the month of a BookOfTheMonth item.

    @NotEmpty(message = "ISBN is a required field.")
    private String isbn; // Sets the isbn of a BookOfTheMonth item.

    /**
     * Default Constructor which is used to create a BookOfTheMonth object.
     * @return none.
     */
    public BookOfTheMonth(){}

    /**
     * Constructor with two arguments, which are used to create a BookOfTheMonth object.
     * @param month int
     * @param isbn String 
     * @return none.
     */
    public BookOfTheMonth(int month, String isbn) {
        this.month = month;
        this.isbn = isbn;
    } // end BookOfTheMonth

    /**
     * Method which is used to override the BookOfTheMonth object's toString.
     * @return a String of BookOfTheMonth details.
     */
    @Override
    public String toString() {
        return String.format("BookOfTheMonth{id=%s, month=%s, isbn=%s}", id, month, isbn);
    } // end toString

    /** Getters */
    public String getId() {
        return id;
    } // end getId

    public int getMonth() {
        return month;
    } // end getMonth

    public String getIsbn() {
        return isbn;
    } // end getIsbn

    /** Setters */
    public void setId(String id) {
        this.id = id;
    } // end setId

    public void setMonth(int month) {
        this.month = month;
    } // end setMonth

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    } // end setIsbn
}  //end BookOfTheMonth
