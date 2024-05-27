/*
    Walls, Craig (2022, March 1). Spring in Action (6th ed.). 
        Manning.
    Additional modifications by C. Bellar 2024
*/
package com.bookclub;

/** imports */
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.ui.Model;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;
import com.bookclub.web.WishlistController;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestWebUnits {

    @LocalServerPort
	private int port;

    @Autowired
	private TestRestTemplate restTemplate;

    @Mock
    private WishlistDao wishlistDao;

    @Mock
    private Model model;

    @InjectMocks
    private WishlistController wishlistController;

    @Test
    public void testWishlist() throws Exception {
        ResponseEntity<String> result = restTemplate.withBasicAuth("cbellar", "welcome01")
          .getForEntity("/wishlist", String.class);
        assertEquals(HttpStatus.OK, result.getStatusCode());
    } // end testWishlist

    @Test
    public void testWishlistForm() throws Exception {
        ResponseEntity<String> result = restTemplate.withBasicAuth("cbellar", "welcome01")
          .getForEntity("/wishlist/new", String.class);
        assertEquals(HttpStatus.OK, result.getStatusCode());
    } // end testWishlistForm

    @Test
    public void testShowWishlistItems() {
        String id = "1";
        WishlistItem wishlistItem = new WishlistItem();

        when(wishlistDao.find(id)).thenReturn(wishlistItem);
        String viewName = wishlistController.showWishlistItem(id, model);
        
        verify(wishlistDao).find(id);
        verify(model).addAttribute("wishlistItem", wishlistItem);
        assertEquals("wishlist/view", viewName);
    } // end testShowWishlistItems
} // end TestWebUnits
