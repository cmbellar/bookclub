/*
    Walls, Craig (2022, March 1). Spring in Action (6th ed.). 
        Manning.
    Additional modifications by C. Bellar 2024
*/
package com.bookclub.service;

/** imports */
import java.util.List;

public interface GenericDao<E, K> {
    List<E> list(); // Return a list of objects of type E.
    E find(K key); // Return an object of type E by type K value.
} // end GenericDao
