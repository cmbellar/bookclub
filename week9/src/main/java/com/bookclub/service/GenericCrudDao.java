/*
    Walls, Craig (2022, March 1). Spring in Action (6th ed.). 
        Manning.
    Additional modifications by C. Bellar 2024
*/
package com.bookclub.service;

/** imports */
import java.util.List;

public interface GenericCrudDao<E, K> {
    void add(E entity); // Add a generic entry.
    void update(E entity); // Update a generic entry.
    boolean remove(K key); // Remove a generic entry.
    List<E> list(K key); // Return a list of objects of type E.
    E find(K key); // Return an object of type E by type K value.
} // end GenericCrudDao
