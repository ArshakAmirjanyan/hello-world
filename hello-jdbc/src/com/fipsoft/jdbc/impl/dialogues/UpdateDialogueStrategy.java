package com.fipsoft.jdbc.impl.dialogues;

import com.fipsoft.jdbc.api.PersonDAO;
import com.fipsoft.jdbc.api.QueryCriteria;
import com.fipsoft.jdbc.dialogue.DialogueStrategy;
import com.fipsoft.jdbc.impl.dao.PersonDaoManager;
import com.fipsoft.jdbc.domain.Person;


import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by aamirjanyan on 6/28/16.
 */
public class UpdateDialogueStrategy implements DialogueStrategy {
    private PersonDAO personDAO;

    public UpdateDialogueStrategy() {
        personDAO = new PersonDaoManager();
    }

    @Override
    public void execute() {
        int passNumber, age;
        String newName,newSurname;
        System.out.println("Updating the person corresponding to the passport number you entered");
        System.out.println("Enter the passport number of the person being updated");
        Scanner scanner = new Scanner(System.in);
        passNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Specify new name, or enter for no changes");

        newName = scanner.nextLine();
        System.out.println(newName);

        System.out.println("Specify new surname, or enter for no changes");
        newSurname  = scanner.nextLine();

        System.out.println("Enter age or enter for no changes");
        age = scanner.nextInt();
        scanner.nextLine();

        Person updatedPerson = new Person(passNumber, newName, newSurname, age);

        try {
            personDAO.update(updatedPerson);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

