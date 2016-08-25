package com.fipsoft.jdbc.domain;

/**
 * Created by aamirjanyan on 6/27/16.
 */
public class Person {

    private int passNumber;
    private String name;
    private String surname;
    private int age;


    public Person() {
    }

    public Person(int p, String n, String s, int a) {

        passNumber = p;
        name = n;
        surname = s;
        age = a;

    }

    public void setSurname(String lastName) {
        this.surname = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPassNumber(int passNumber) {
        this.passNumber = passNumber;
    }

    public void setName(String firstName) {
        this.name = firstName;
    }


    public int getPassNumber() {
        return passNumber;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

}
