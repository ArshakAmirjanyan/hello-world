package com.fipsoft.jdbc;

import com.fipsoft.jdbc.dialogue.DialogueStrategy;
import com.fipsoft.jdbc.impl.dialogues.DeleteDialogueStrategy;
import com.fipsoft.jdbc.impl.dialogues.InsertDialogueStrategy;
import com.fipsoft.jdbc.impl.dialogues.SelectDialogueStrategy;
import com.fipsoft.jdbc.impl.dialogues.UpdateDialogueStrategy;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by aamirjanyan on 6/27/16.
 */
public class Program {
    private static Map<Integer, DialogueStrategy> dialogueStrategies = new HashMap<>();
    static {
        dialogueStrategies.put(1, new InsertDialogueStrategy());
        dialogueStrategies.put(2, new UpdateDialogueStrategy());
        dialogueStrategies.put(3, new DeleteDialogueStrategy());
        dialogueStrategies.put(4, new SelectDialogueStrategy());
    }

    public static void main(String[] args) {
        System.out.println("What action do you want to execute");
        System.out.println("1 for insert\n2 for update\n3 for delete\n4 for select");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        if (input > 0 && input < 5) {
            DialogueStrategy dialogueStrategy = dialogueStrategies.get(input);

            try {
                dialogueStrategy.execute();
            } catch (Exception a) {
                System.out.println("Invalid input");
            }
        }

    }
}
