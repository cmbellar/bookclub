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
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
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
     * @return String wishlist/list. 
     */
    @RequestMapping(method = RequestMethod.GET)
    public String showWishlist() {
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
     * @param wishlistItem WishlistItem
     * @param bindingResult BindingResult
     * @param authentication Authentication
     * @return String redirect:/wishlist. 
     */
    @RequestMapping(method = RequestMethod.POST)
    public String addWishlistItem(@Valid WishlistItem wishlistItem, BindingResult bindingResult, Authentication authentication) {
        wishlistItem.setUsername(authentication.getName()); // Get the username.

        /* Check for errors prior to add. */
        if (bindingResult.hasErrors()) {
            return "wishlist/new";
        } // end if

        wishlistDao.add(wishlistItem); // Add wishlistItem.

        return "redirect:/wishlist";
    } // end addWishlistItem

    /**
     * Public String method that wires Wishlist remove.
     * @RequestMapping GET
     * @param id String
     * @return String redirect:/wishlist. 
     */
    @RequestMapping(method = RequestMethod.GET, path = "/remove/{id}")
    public String removeWishlistItem(@PathVariable String id) {

        wishlistDao.remove(id); // Remove wishlistItem.

        return "redirect:/wishlist";
    } // end removeWishlistItem

    /**
     * Public String method that wires Wishlist show.
     * @RequestMapping GET
     * @param id String
     * @return String wishlist/view. 
     */
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public String showWishlistItem(@PathVariable String id, Model model) {
        WishlistItem wishlistItem = wishlistDao.find(id); // Find the specific WishlistItem.

        model.addAttribute("wishlistItem", wishlistItem); // Map the WishlistItem to the model.

        return "wishlist/view";
    } // end showWishlistItem

    /**
     * Public String method that wires the Wishlist update.
     * @RequestMapping POST
     * @param wishlistItem WishlistItem
     * @param bindingResult BindingResult
     * @param authentication Authentication
     * @return String redirect:/wishlist. 
     */
    @RequestMapping(method = RequestMethod.POST, path = "/update")
    public String updateWishlistItem(@Valid WishlistItem wishlistItem, BindingResult bindingResult, Authentication authentication) {
        wishlistItem.setUsername(authentication.getName()); // Get the username.

        /* Check for errors prior to update. */
        if (bindingResult.hasErrors()) {
            return "wishlist/view";
        } // end if

        wishlistDao.update(wishlistItem); // Update wishlistItem.

        return "redirect:/wishlist";
    } // end updateWishlistItem
} // end WishlistController
