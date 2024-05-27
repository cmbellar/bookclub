package com.bookclub.service.impl;

/** imports */
import com.bookclub.model.BookOfTheMonth;
import com.bookclub.service.dao.BookOfTheMonthDao;
import java.util.List;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository("bookOfTheMonthDao")
public class MongoBookOfTheMonthDao implements BookOfTheMonthDao {

    @Autowired
    private MongoTemplate mongoTemplate; // Instantiate private MongoTemplate object.

    /**
     * A void method which is used to add a BookOfTheMonth.
     * @param BookOfTheMonth entity
     */
    @Override
    public void add(BookOfTheMonth entity) {
        mongoTemplate.save(entity);
    } // end add

    /**
     * A void method which is used to update a BookOfTheMonth.
     * @param BookOfTheMonth entity
     */
    @Override
    public void update(BookOfTheMonth entity) {
        throw new NotImplementedException();
    } // end update

     /**
     * A boolean method which is used to remove a BookOfTheMonth.
     * @param key String
     * @return true if successful
     */
    @Override
    public boolean remove(String key) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(key));
        mongoTemplate.remove(query, BookOfTheMonth.class);
        return true;
    } // end remove

    /**
     * Method which is used to return an array of BookOfTheMonths.
     * @param key String
     * @return a list of BookOfTheMonths.
     */
    @Override
    public List<BookOfTheMonth> list(String key) {
        int month = Integer.parseInt(key);

        System.out.println("Month: " + month);

        if (month == 999) {
            return mongoTemplate.findAll(BookOfTheMonth.class);
        }

        Query query = new Query();

        query.addCriteria(Criteria.where("month").is(month));

        return mongoTemplate.find(query, BookOfTheMonth.class);
    } // end list

    /**
     * Currently not implemented *
     * Method with one argument which is used to return a specific BookOfTheMonth when the id matches.
     * @param key String
     * @return a BookOfTheMonth.
     */
    @Override
    public BookOfTheMonth find(String key) {
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    } // end find
} // end MongoBookOfTheMonthDao
