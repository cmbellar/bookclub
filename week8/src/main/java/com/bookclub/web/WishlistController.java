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
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/wishlist")
public class WishlistController {

    WishlistDao wishlistDao = new MongoWishlistDao(); // instantiate an instance of the MongoWishlistDao.

    /**
     * Private void method that assigns passed object to this.wishlistDao.
     * @Autowired
     * @param WishlistDao wishlistDao 
     */
    @Autowired
    private void setWishlistDao(WishlistDao wishlistDao) {
        this.wishlistDao = wishlistDao;
    } // end setWishlistDao

    /**
     * Public String method that wires the Wishlist Page.
     * @RequestMapping GET
     * @param Model model
     * @return String wishlist/list. 
     */
    @RequestMapping(method = RequestMethod.GET)
    public String showWishlist(Model model) {
        return "wishlist/list";
    } // end showWishlist

    /**
     * Public String method that wires Wishlist new.
     * @RequestMapping GET
     * @param Model model
     * @return String wishlist/new. 
     */
    @RequestMapping(method = RequestMethod.GET, path = "/new")
    public String wishlistForm(Model model) {        
        model.addAttribute("wishlistItem", new WishlistItem());
        return "wishlist/new";
    } // end wishlistForm

    /**
     * Public String method that wires Wishlist add.
     * @RequestMapping POST
     * @param Model model
     * @return String redirect:/wishlist. 
     */
    @RequestMapping(method = RequestMethod.POST)
    public String addWishlistItem(@Valid WishlistItem wishlistItem, BindingResult bindingResult) {        
        System.out.println(wishlistItem.toString());

        System.out.println(bindingResult.getAllErrors());

        if (bindingResult.hasErrors()) {
            return "wishlist/new";
        } // end if

        wishlistDao.add(wishlistItem); // Add the record to MongoDB.

        return "redirect:/wishlist";
    } // end addWishlistItem
} // end WishlistController
