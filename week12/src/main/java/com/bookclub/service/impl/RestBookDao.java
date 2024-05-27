/*
    Walls, Craig (2022, March 1). Spring in Action (6th ed.). 
        Manning.
    Additional modifications by C. Bellar 2024
*/
package com.bookclub.service.impl;

/** imports */
import com.bookclub.model.Book;
import com.bookclub.service.dao.BookDao;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class RestBookDao implements BookDao {

    /**
     * Default Constructor which is used to create a RestBookDao object.
     * @return none.
     */
    public RestBookDao() {}

    /**
     * Method which is used to return an array of Books.
     * @param key String
     * @return a list of Books.
     */
    @Override
    public List<Book> list(String key) {

        Object doc = getBooksDoc(key); // Instantiate Object to contain a Book list.

        List<Book> books = new ArrayList<Book>(); // Instantiate an ArrayList of Books. 

        List<String> titles = JsonPath.read(doc, "$..title");
        List<String> isbns = JsonPath.read(doc, "$..bib_key");
        List<String> infoUrls = JsonPath.read(doc, "$..info_url");

        /* Loop through books and add them to the books List. */
        for (int index = 0; index < titles.size(); index++) {
            books.add(new Book(isbns.get(index), titles.get(index), infoUrls.get(index)));
        } // end for

        return books; // Return a list of books.
    } // end list

    /**
     * Method with one argument which is used to return a specific Book when the isbn matches.
     * @param key String
     * @return a Book.
     */
    @Override
    public Book find(String key) {
        Object doc = getBooksDoc(key);

        List<String> isbns = JsonPath.read(doc, "$..bib_key");
        List<String> titles = JsonPath.read(doc, "$..title");
        List<String> subtitle = JsonPath.read(doc, "$..details.subtitle");
        List<String> infoUrls = JsonPath.read(doc, "$..info_url");
        List<Integer> pages = JsonPath.read(doc, "$..details.number_of_pages");

        String isbn = isbns.size() > 0 ? isbns.get(0) : "N/A";
        String title = titles.size() > 0 ? titles.get(0) : "N/A";
        String desc = subtitle.size() > 0 ? subtitle.get(0) : "N/A";
        String infoUrl = infoUrls.size() > 0 ? infoUrls.get(0) : "N/A";
        int numOfPages = pages.size() > 0 ? pages.get(0) : 0;

        Book book = new Book(isbn, title, desc, infoUrl, numOfPages);

        return book;
    } // end find

    /**
     * Method with one argument which is used to return a Book list when the isbn matches.
     * @param key String
     * @return a Book list.
     */
    public Object getBooksDoc(String isbnString) {
        String openLibraryUrl = "http://openlibrary.org/api/books"; // Had cert issues, so use unsecure url for testing.

        RestTemplate rest = new RestTemplate(); // Call the RestTemplate object to invoke a third-party API call.

        /* Create and set headers. */
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

        /* Construct URI */
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(openLibraryUrl)
                .queryParam("bibkeys", isbnString)
                .queryParam("format", "json")
                .queryParam("jscmd", "details");

        HttpEntity<?> entity = new HttpEntity<>(headers);

        /* Execute Http request. */
        HttpEntity<String> response = rest.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                String.class);

        String jsonBooklist = response.getBody(); // Construct jsonBooklist from response body.

        return Configuration.defaultConfiguration().jsonProvider().parse(jsonBooklist); // Return Book list.
    } // end getBooksDoc
} // end MemBookDao