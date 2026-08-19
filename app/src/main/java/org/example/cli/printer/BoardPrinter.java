package org.example.cli.printer;

import org.example.Board;
import org.example.Task;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BoardPrinter {

    public static void printTask(Task task) {
        System.out.println(
                String.format(
                    "\tTask\n" +
                    "\t\tName: %s\n" +
                    "\t\tDescription: %s\n" +
                    "\t\tPriority: %d\n" +
                    "\t\tCategory: %s\n" +
                    "\t\tTarget: %s\n",
                task.getTitle(), task.getDescription(), task.getPriority(), task.getCategory(), task.getTarget_data())
        );
    }

    public static void printSection(String sectionName, List<Task> tasks) {
        System.out.println(sectionName);
        for (Task task : tasks) {
            printTask(task);
        }
    }

    public static void printBoard(Board board) {
        // Itera diretamente sobre o HashMap utilizando expressão lambda
        for (Map.Entry<String, ArrayList<Task>> entry : board.getTasks().entrySet()) {
            String key = entry.getKey();
            ArrayList<Task> value = entry.getValue();
            printSection(key, value);
        }
    }

}
