/*
    Walls, Craig (2022, March 1). Spring in Action (6th ed.). 
        Manning.
    Additional modifications by C. Bellar 2024
*/
package com.bookclub.service.dao;

/** imports */
import com.bookclub.model.WishlistItem;
import com.bookclub.service.GenericCrudDao;

public interface WishlistDao extends GenericCrudDao<WishlistItem, String> {}
