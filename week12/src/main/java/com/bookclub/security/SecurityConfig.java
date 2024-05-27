/*
    Walls, Craig (2022, March 1). Spring in Action (6th ed.). 
        Manning.
    Additional modifications by C. Bellar 2024
*/
package com.bookclub.security;

/** imports */
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    /**
     * Protected void method that wires the application auth.
     * @param AuthenticationManagerBuilder auth
     * @exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        auth // Generate users.
            .inMemoryAuthentication()
            .withUser("user").password(encoder.encode("password")).roles("USER")
            .and()
            .withUser("cbellar").password(encoder.encode("welcome01")).roles("USER", "ADMIN");
    } // end configure

    /**
     * Protected void method that wires the application security.
     * @param HttpSecurity http
     * @exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http // Configure Spring security to require authenticated users, use a custom login page, and handle user logouts.
            .authorizeRequests()
                .antMatchers("/monthly-books/list", "/monthly-books/new", "/monthly-books").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .logoutSuccessUrl("/login?logout=true")
                .invalidateHttpSession(true)
                .permitAll();
    } // end configure
} // end SecurityConfig
