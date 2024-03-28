/*
    Walls, Craig (2022, March 1). Spring in Action (6th ed.). 
        Manning.
    Additional modifications by C. Bellar 2024
*/
package com.bookclub.web;

/** imports */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ch.qos.logback.core.model.Model;

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
}
