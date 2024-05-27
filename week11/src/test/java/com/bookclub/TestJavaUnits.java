/*
    Walls, Craig (2022, March 1). Spring in Action (6th ed.). 
        Manning.
    Additional modifications by C. Bellar 2024
*/
package com.bookclub;

/** imports */
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.impl.MongoWishlistDao;
import com.bookclub.web.WishlistController;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
class TestJavaUnits {

    @Autowired
    private WishlistController wishlistController;

    @Mock
    private MongoTemplate mongoTemplate;

    @InjectMocks
    private MongoWishlistDao mongoWishlistDao;

    @Test
    public void testShowWishlist() throws Exception {
        assertThat(this.wishlistController.showWishlist()).contains("wishlist/list");
    } // end testShowWishlist

    @Test
    public void testAddWishlistItem() {
        WishlistItem wishlistItem = new WishlistItem();
        mongoWishlistDao.add(wishlistItem);
        verify(mongoTemplate, times(1)).save(wishlistItem);
    } // emd testAddWishlistItem

    @Test
    public void testListWishlistItems() {
        String username = "cbellar";
        WishlistItem wishlistItem1 = new WishlistItem();
        WishlistItem wishlistItem2 = new WishlistItem();

        List<WishlistItem> expectedList = Arrays.asList(wishlistItem1, wishlistItem2);
        
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(username));
        
        when(mongoTemplate.find(query, WishlistItem.class)).thenReturn(expectedList);
        List<WishlistItem> actualList = mongoWishlistDao.list(username);
        verify(mongoTemplate).find(query, WishlistItem.class);
        assertEquals(expectedList, actualList);
    } // end testListWishlistItems

} // end TestJavaUnits
