/*
    Walls, Craig (2022, March 1). Spring in Action (6th ed.). 
        Manning.
    Additional modifications by C. Bellar 2024
*/
package com.bookclub.web;

/** imports */
import com.bookclub.model.Book;
import com.bookclub.service.impl.MemBookDao;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {

    /**
     * Public String method that wires the Home Page.
     * @RequestMapping GET
     * @param Model model
     * @return String index. 
     */
    @RequestMapping(method = RequestMethod.GET)
    public String showHome(Model model) {
        MemBookDao bookDao = new MemBookDao();
        List<Book> books = bookDao.list();

        for (Book book : books) {
            System.out.println(book.toString());
        }
        
        model.addAttribute("books", books);
        return "index";
    } // end showHome

    /**
     * Public String method that wires the About Us Page.
     * @RequestMapping GET
     * @param Model model
     * @return String about. 
     */
    @RequestMapping(method = RequestMethod.GET, path = "/about")
    public String showAboutUs(Model model) {
        return "about";
    } // end showAboutUs

    /**
     * Public String method that wires the Contact Us Page.
     * @RequestMapping GET
     * @param Model model
     * @return String contact. 
     */
    @RequestMapping(method = RequestMethod.GET, path = "/contact")
    public String showContactUs(Model model) {
        return "contact";
    } // end showContactUs

    /**
     * Public String method that wires the Books Page.
     * @RequestMapping GET
     * @param id String
     * @param Model model
     * @return String monthly-books/view. 
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public String getMonthlyBook(@PathVariable("id") String id, Model model) {
        String isbn = id;
        System.out.println(id);

        MemBookDao bookDao = new MemBookDao();
        Book book = bookDao.find(isbn);

        System.out.println(book.toString());

        model.addAttribute("book", book);
        return "monthly-books/view";
    } // end getMonthlyBook
}
