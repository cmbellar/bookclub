/*
    Walls, Craig (2022, March 1). Spring in Action (6th ed.). 
        Manning.
    Additional modifications by C. Bellar 2024
*/
package com.bookclub.web;

/** imports */
import com.bookclub.model.Book;
import com.bookclub.model.BookOfTheMonth;
import com.bookclub.service.dao.BookOfTheMonthDao;
import com.bookclub.service.impl.MongoBookOfTheMonthDao;
import com.bookclub.service.impl.RestBookDao;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {

    BookOfTheMonthDao bookOfTheMonthDao = new MongoBookOfTheMonthDao(); // instantiate an instance of the MongoBookOfTheMonthDao.

    /**
     * Public void method that assigns passed object to this.bookOfTheMonthDao.
     * @Autowired
     * @param bookOfTheMonthDao BookOfTheMonthDao 
     */
    @Autowired
    public void setBookOfTheMonthDao(BookOfTheMonthDao bookOfTheMonthDao) {
        this.bookOfTheMonthDao = bookOfTheMonthDao;
    } // end setBookOfTheMonthDao

    /**
     * Public String method that wires the Home Page.
     * @RequestMapping GET
     * @param Model model
     * @return String index. 
     */
    @RequestMapping(method = RequestMethod.GET)
    public String showHome(Model model) {
        /* Capture the current month */
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int calMonth = cal.get(Calendar.MONTH) + 1;

        /* Pass the current month to bookOfTheMonthDao.list */
        RestBookDao bookDao = new RestBookDao();
        List<BookOfTheMonth> monthlyBooks = bookOfTheMonthDao.list(Integer.toString(calMonth));

        /* Instantiate a StringBuilder and append content to it. */
        StringBuilder isbnBuilder = new StringBuilder();
        isbnBuilder.append("ISBN:");

        /* Loop through monthlyBooks and append the ISBN of each. */
        for (BookOfTheMonth monthlyBook : monthlyBooks) {
            isbnBuilder.append(monthlyBook.getIsbn()).append(",");
        } // end for

        /* Set contents of isbnBuilder to isbnString, add them to a list, and add them to the model. */
        String isbnString = isbnBuilder.toString().substring(0, isbnBuilder.toString().length() - 1);
        List<Book> books = bookDao.list(isbnString);
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

        RestBookDao bookDao = new RestBookDao();
        Book book = bookDao.find(isbn);

        System.out.println(book.toString());

        model.addAttribute("book", book);
        return "monthly-books/view";
    } // end getMonthlyBook
}
