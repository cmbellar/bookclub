/*
    Spring Initializr. (n.d.). Retrieved March 17, 2024, from https://start.spring.io/
    Additional modifications by C. Bellar 2024
*/
package com.bookclub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookclubApplication {

    /**
     * A static void method which drives the application.
     */
    public static void main(String[] args) {
        SpringApplication.run(BookclubApplication.class, args);
    }

}
