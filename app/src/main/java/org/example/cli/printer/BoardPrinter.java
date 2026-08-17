package org.example.cli.printer;

import org.example.Board;
import org.example.Task;


import java.util.List;

public class BoardPrinter {

    public static void printTask(Task task) {
        System.out.println(
                String.format(
                    "\tTask\n" +
                    "\t\tName: %s\n" +
                    "\t\tDescription: %s\n" +
                    "\t\tTarget: %s\n",
                task.getTitle(), task.getDescription(), task.getTarget_data())
        );
    }

    public static void printSection(String sectionName, List<Task> tasks) {
        System.out.println(sectionName);
        for (Task task : tasks) {
            printTask(task);
        }
    }

    public void printBoard(Board board) {
        // imprime todo, doing, done
    }
}