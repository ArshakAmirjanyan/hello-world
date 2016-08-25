package com.fipsoft.jdbc.impl.dialogues;

import com.fipsoft.jdbc.api.PersonDAO;
import com.fipsoft.jdbc.api.QueryCriteria;
import com.fipsoft.jdbc.dialogue.DialogueStrategy;
import com.fipsoft.jdbc.domain.Person;
import com.fipsoft.jdbc.impl.dao.PersonDaoManager;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by aamirjanyan on 6/28/16.
 */
public class DeleteDialogueStrategy implements DialogueStrategy {

    private PersonDAO personDAO;

    public DeleteDialogueStrategy() {
        personDAO = new PersonDaoManager();
    }

    @Override
    public void execute() {
        System.out.println("Deleting record based on your specified criterias");
        String name, surname;
        int passNumber, age;
        System.out.println("Specify passport number, or enter for blank");
        Scanner scanner = new Scanner(System.in);

        passNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Specify name, or enter for blank");
        name = scanner.nextLine();

        System.out.println("Specify surname, or enter for blank");
        surname = scanner.nextLine();

        System.out.println("Specify age, or enter for blank");
        age = scanner.nextInt();
        scanner.nextLine();

        Person person = new Person(passNumber, name, surname, age);

        try {
            personDAO.delete(person);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

