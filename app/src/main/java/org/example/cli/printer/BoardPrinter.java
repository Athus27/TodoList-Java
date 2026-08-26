package org.example.cli.printer;

import org.example.Board;
import org.example.Task;


import java.time.format.DateTimeFormatter;
import java.util.List;

public class BoardPrinter {

    public static void printTask(Task task) {
        String alarmText = (task.getAlarmTime() != null) ? task.getAlarmTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) : "No alarm set";

        System.out.println(
                String.format(
                        "\tTask\n" +
                                "\t\tName: %s\n" +
                                "\t\tDescription: %s\n" +
                                "\t\tPriority: %d\n" +
                                "\t\tCategory: %s\n" +
                                "\t\tTarget: %s\n" +
                                "\t\tAlarm: %s\n",
                        task.getTitle(), task.getDescription(), task.getPriority(), task.getCategory(), task.getTarget_data(), alarmText)
        );
    }

    public static void printSection(String sectionName, List<Task> tasks) {
        System.out.println(sectionName);
        for (Task task : tasks) {
            printTask(task);
        }
    }

    public static void printBoard(Board board) {
        printSection("ToDo", board.getTasksBySection("ToDo"));
        printSection("Doing", board.getTasksBySection("Doing"));
        printSection("Done", board.getTasksBySection("Done"));
    }

}
