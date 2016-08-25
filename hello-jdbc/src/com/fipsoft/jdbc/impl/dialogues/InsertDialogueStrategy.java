package com.fipsoft.jdbc.impl.dialogues;

import com.fipsoft.jdbc.api.PersonDAO;
import com.fipsoft.jdbc.dialogue.DialogueStrategy;
import com.fipsoft.jdbc.domain.Person;
import com.fipsoft.jdbc.impl.dao.PersonDaoManager;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by aamirjanyan on 6/28/16.
 */
public class InsertDialogueStrategy implements DialogueStrategy {

    private PersonDAO personDAO;

    public InsertDialogueStrategy() {
        personDAO = new PersonDaoManager();
    }

    @Override
    public void execute() {
        System.out.println("Enter Passport number, name, surname, age");
        Scanner sc = new Scanner(System.in);
        int pN = sc.nextInt();
        sc.nextLine();
        String fN = sc.nextLine();
        String lN = sc.nextLine();
        int a = sc.nextInt();

        Person inputPerson = new Person(pN, fN, lN, a);
        try {
            personDAO.insert(inputPerson);
        } catch (SQLException e) {
            //handle
        }
    }
}
