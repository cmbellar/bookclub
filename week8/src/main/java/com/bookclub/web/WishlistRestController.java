/*
    Walls, Craig (2022, March 1). Spring in Action (6th ed.). 
        Manning.
    Additional modifications by C. Bellar 2024
*/
package com.bookclub.web;

/** imports */
import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;
import com.bookclub.service.impl.MongoWishlistDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/wishlist", produces = "application/json")
@CrossOrigin(origins = "*")
public class WishlistRestController {

    WishlistDao wishlistDao = new MongoWishlistDao(); // instantiate an instance of the MongoWishlistDao.

    /**
     * Public void method that creates a setter for wishlistDao.
     * @Autowired
     * @param WishlistDao wishlistDao
     */
    @Autowired
    private void setWishlistDao(WishlistDao wishlistDao) {
        this.wishlistDao = wishlistDao;
    } // end setWishlistDao

    /**
     * Public List<WishlistItem> method that returns a list of wishlistDao.
     * @RequestMapping GET
     * @return wishlistDao list. 
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<WishlistItem> showWishlist() {
        return wishlistDao.list();
    } // end showWishlist

    /**
     * Public String method that returns a specific wishlistDao object.
     * @RequestMapping GET
     * @PathVariable String id
     * @return Specific wishlistDao object.
     */
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public WishlistItem findById(@PathVariable String id) {
        return wishlistDao.find(id);
    } // end findById
} // end WishlistRestController
