package com.fipsoft.jdbc.api;

import com.fipsoft.jdbc.domain.Person;

import javax.management.Query;
import java.sql.SQLException;

/**
 * Created by aamirjanyan on 6/27/16.
 */
public interface PersonDAO {

    //NOTE TO SELF:
    //what's query criteria, why return person

    Person select(QueryCriteria criteria) throws SQLException;

    void insert(Person person) throws SQLException;

    void update(Person person) throws SQLException;

    void delete(Person person) throws SQLException;
}
