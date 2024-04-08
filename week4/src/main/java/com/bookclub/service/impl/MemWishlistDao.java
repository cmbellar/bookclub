/*
    Walls, Craig (2022, March 1). Spring in Action (6th ed.). 
        Manning.
    Additional modifications by C. Bellar 2024
*/
package com.bookclub.service.impl;

/** imports */
import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;
import java.util.ArrayList;
import java.util.List;

public class MemWishlistDao implements WishlistDao {

    private List<WishlistItem> wishlistItems; // Sets a list of WishlistItem objects.

    /**
     * Default Constructor which is used to create a MemWishlistDao object with three preloaded wishlistItems.
     * @return none.
     */
    public MemWishlistDao() {
        this.wishlistItems = new ArrayList<WishlistItem>();
        this.wishlistItems.add(new WishlistItem("0765334348", "The Great Hunt"));
        this.wishlistItems.add(new WishlistItem("0765334356", "The Dragon Reborn"));
        this.wishlistItems.add(new WishlistItem("0274900653", "The Fires of Heaven"));
    } // end MemWishlistDao

    /**
     * Method which is used to return an array of WishlistItems.
     * @return a list of WishlistItems.
     */
    @Override
    public List<WishlistItem> list() {
        return this.wishlistItems;
    } // end list

    /**
     * Method with one argument which is used to return a specific WishlistItem when the isbn matches.
     * @param key String
     * @return a WishlistItem.
     */
    @Override
    public WishlistItem find(String key) {
        for (WishlistItem wishlistItem : this.wishlistItems) {
            if (wishlistItem.getIsbn().equals(key)) {
                return wishlistItem;
            }
        }
        return new WishlistItem();
    } // end find
} // end MemWishlistDao
