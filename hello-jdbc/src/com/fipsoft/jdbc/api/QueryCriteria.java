package com.fipsoft.jdbc.api;

import java.util.HashMap;
import java.util.Map;


public class QueryCriteria {

    private int passNumber;
    private int age;
    private String name;
    private String surname;

    public String getSurname() {
        return surname;
    }

    public int getPassNumber() {
        return passNumber;
    }

    public void setPassNumber(int passNumber) {
        this.passNumber = passNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Map<String, Object> getCriterias() {
        Map<String, Object> criterias = new HashMap<>();

        if (passNumber != 0) {
            criterias.put("passNumber", passNumber);
        }

        if (name != null) {
            criterias.put("name", name);
        }

        if (surname != null) {
            criterias.put("surname", surname);
        }

        if (age != 0) {
            criterias.put("age", age);
        }

        return criterias;
    }

}
