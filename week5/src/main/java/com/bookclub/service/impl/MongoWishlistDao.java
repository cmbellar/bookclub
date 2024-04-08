/*
    Walls, Craig (2022, March 1). Spring in Action (6th ed.). 
        Manning.
    Additional modifications by C. Bellar 2024
*/
package com.bookclub.service.impl;

/** imports */
import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository("wishlistDao")
public class MongoWishlistDao implements WishlistDao {
    
    @Autowired
    private MongoTemplate mongoTemplate; // Instantiate private MongoTemplate object.

    /**
     * A void method which is used to add a WishlistItem.
     * @param WishlistItem entity
     */
    @Override
    public void add(WishlistItem entity) {
        mongoTemplate.save(entity);
    } // end add

    /**
     * A void method which is used to update a WishlistItem.
     * @param WishlistItem entity
     */
    @Override
    public void update(WishlistItem entity) {}

    /**
     * A boolean method which is used to remove a WishlistItem.
     * @param WishlistItem entity
     * @return true if successful
     */
    @Override
    public boolean remove(WishlistItem entity) {
        return true; // Return true until code is written.
    } // end remove

    /**
     * Method which is used to return an array of WishlistItems.
     * @return a list of WishlistItems.
     */
    @Override
    public List<WishlistItem> list() {
        return mongoTemplate.findAll(WishlistItem.class);
    } // end list

    /**
     * Method with one argument which is used to return a specific WishlistItem when the id matches.
     * @param key String
     * @return a WishlistItem.
     */
    @Override
    public WishlistItem find(String key) {
        return null; // Return null until code is written.
    } // end find
} // end MongoWishlistDao
