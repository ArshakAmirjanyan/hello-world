package com.fipsoft.jdbc.impl.dao;

import com.fipsoft.jdbc.api.ConnectionProvider;
import com.fipsoft.jdbc.api.PersonDAO;
import com.fipsoft.jdbc.api.QueryCriteria;
import com.fipsoft.jdbc.db.ConnectionManager;
import com.fipsoft.jdbc.domain.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by aamirjanyan on 6/27/16.
 */
public class PersonDaoManager implements PersonDAO {
    private ConnectionProvider connectionProvider;


    public PersonDaoManager() {
        this.connectionProvider = new ConnectionManager();
    }


    @Override
    public Person select(QueryCriteria criteria) throws SQLException {
        String query = "SELECT * FROM person WHERE ";
        boolean single = true;

        if (criteria.getPassNumber() != 0) {
            query += "passNumber = ? ";
            single = false;
        }

            if (!criteria.getName().equals("")) {
                if (!single) {
                    query += "AND ";
                }
                query += "name = ? ";
                single = false;
            }

            if (!criteria.getSurname().equals("")) {
                if (single == false) {
                    query += "AND ";
                }
                query += "surname = ? ";
            }

            if (criteria.getAge() != 0) {
                if (single == false) {
                    query += "AND ";
                }
                query += "age = ?";
            }


        Connection connection = null;
        PreparedStatement preparedStatement = null;

        connection = connectionProvider.getConnection();
        preparedStatement = connection.prepareStatement(query);
        int count = 1;

        if (criteria.getPassNumber() != 0) {
            preparedStatement.setInt(count, criteria.getPassNumber());
            count++;
        }

            if (!criteria.getName().equals("")) {
                preparedStatement.setString(count, criteria.getName());
                count++;
            }

            if (!criteria.getSurname().equals("")) {
                preparedStatement.setString(count, criteria.getSurname());
                count++;
            }

            if (criteria.getAge() != 0) {
                preparedStatement.setInt(count, criteria.getAge());
                count++;
            }


        System.out.println(query);
        ResultSet rs = preparedStatement.executeQuery();
        return null;
    }

    @Override
    public void insert(Person person) throws SQLException {
        String query = "INSERT INTO person(passNumber, name, surname, age)VALUES(?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        connection = connectionProvider.getConnection();
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, person.getPassNumber());
        preparedStatement.setString(2, person.getName());
        preparedStatement.setString(3, person.getSurname());
        preparedStatement.setInt(4, person.getAge());

        preparedStatement.executeUpdate();
    }

    @Override
    public void update(Person person) throws SQLException {

        String query = "UPDATE person SET ";
        boolean single = true;
        if (!person.getName().equals("")) {
            single = false;
            query += "name = ? ";
        }

        if (!person.getSurname().equals("")) {
            if (single == false) {
                query += ", ";
            }
            query += "surname = ? ";
            single = false;
        }
        if (person.getAge() != 0) {
            if (single == false) {
                query += ", ";
            }
            query += " age =? ";
        }
        query += "WHERE passNumber = ?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        connection = connectionProvider.getConnection();
        preparedStatement = connection.prepareStatement(query);

        int count = 1;

        if (!person.getName().equals("")) {
            preparedStatement.setString(count, person.getName());
            count++;
        }

        if (!person.getSurname().equals("")) {
            preparedStatement.setString(count, person.getSurname());
            count++;
        }
        if (person.getAge() != 0) {
            preparedStatement.setInt(count, person.getAge());
            count++;
        }
        System.out.println(query);

        preparedStatement.setInt(count, person.getPassNumber());
        preparedStatement.executeUpdate();

    }


    @Override
    public void delete(Person person) throws SQLException {

        String query = "DELETE FROM person WHERE ";
        boolean single = true;
        if (person.getPassNumber() != 0) {
            query += "passNumber = ? ";
            single = false;
        }

        if (!person.getName().equals("")) {
            if (single == false) {
                query += "AND ";
            }
            query += "name = ? ";
            single = false;
        }


            if (!person.getSurname().equals("")) {

                if(single == false) {
                    query += "AND ";
                }
                query += "surname = ? ";
            }
            if (person.getAge() != 0) {
                if (single == false) {
                    query += "AND ";
                }
                query += "Age = ?";
            }

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        connection = connectionProvider.getConnection();
        preparedStatement = connection.prepareStatement(query);
        int count = 1;
        if (person.getPassNumber() != 0) {
            preparedStatement.setInt(count, person.getPassNumber());
            count++;
        }

            if (!person.getName().equals("")) {
                preparedStatement.setString(count, person.getName());
                count++;
            }
            if (!person.getSurname().equals("")) {
                preparedStatement.setString(count, person.getSurname());
                count++;
            }
            if (person.getAge() != 0) {
                preparedStatement.setInt(count, person.getAge());
                count++;
            }
        preparedStatement.executeUpdate();

    }
}

