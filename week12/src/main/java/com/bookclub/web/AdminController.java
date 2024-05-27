package com.bookclub.web;

/** imports */
import com.bookclub.model.BookOfTheMonth;
import com.bookclub.service.dao.BookOfTheMonthDao;
import com.bookclub.service.impl.MongoBookOfTheMonthDao;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/monthly-books")
public class AdminController {

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
     * Public String method that wires the Book of the Month Page.
     * @RequestMapping GET
     * @return String monthly-books/list. 
     */
    @RequestMapping(method = RequestMethod.GET)
    public String showBookOfTheMonth(Model model) {
        model.addAttribute("books", bookOfTheMonthDao.list("999"));
        return "monthly-books/list";
    } // end showBookOfTheMonth

    /**
     * Public String method that wires BookOfTheMonth new.
     * @RequestMapping GET
     * @param Model model
     * @return String monthly-books/new. 
     */
    @RequestMapping(path = "/new", method = RequestMethod.GET)
    public String bookOfTheMonthForm(Model model) {
        model.addAttribute("months", getMonths());
        model.addAttribute("bookOfTheMonth", new BookOfTheMonth());
        return "monthly-books/new";
    } // end bookOfTheMonthForm

    /**
     * Public String method that wires BookOfTheMonth add.
     * @RequestMapping POST
     * @param bookOfTheMonth BookOfTheMonth
     * @param bindingResult BindingResult
     * @param model Model
     * @return String redirect:/monthly-books. 
     */
    @RequestMapping(method = RequestMethod.POST)
    public String addBookOfTheMonth(@Valid BookOfTheMonth bookOfTheMonth, BindingResult bindingResult, Model model) {
        System.out.println(bookOfTheMonth.toString());

         /* Check for errors prior to add. */
        if (bindingResult.hasErrors()) {
            model.addAttribute("months", getMonths()); // Bind the months.
            return "monthly-books/new";
        } // end if

        bookOfTheMonthDao.add(bookOfTheMonth); // Add bookOfTheMonth.

        return "redirect:/monthly-books";
    } // end addBookOfTheMonth

    /**
     * Public String method that wires BookOfTheMonth remove.
     * @RequestMapping GET
     * @param id String
     * @return redirect:/monthly-books. 
     */
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public String removeBookOfTheMonth(@PathVariable String id) {
        bookOfTheMonthDao.remove(id);

        return "redirect:/monthly-books";
    } // end removeBookOfTheMonth

    /**
     * Public String method that adds all the months to a hashmap.
     * @RequestMapping GET
     * @return map of months. 
     */
    private Map<Integer, String> getMonths() {
        Map<Integer, String> months = new HashMap<>();
        months.put(1, "January");
        months.put(2, "February");
        months.put(3, "March");
        months.put(4, "April");
        months.put(5, "May");
        months.put(6, "June");
        months.put(7, "July");
        months.put(8, "August");
        months.put(9, "September");
        months.put(10, "October");
        months.put(11, "November");
        months.put(12, "December");

        return months;
    } // end getMonths
} // end AdminController
