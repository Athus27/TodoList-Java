package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class Board {
    private static int count_tasks = 0;
    private int id;
    private int priority;
    private String title;
    private String description;

    private ArrayList<Task> tasksTodo = new ArrayList<>();
    private ArrayList<Task> tasksDoing = new ArrayList<>();
    private ArrayList<Task> tasksDone = new ArrayList<>();
    HashMap<String,ArrayList<Task>> tasks = new HashMap<>();



    public Board(int id, int priority, String title, String description) {
        this.id = id;
        this.priority = priority;

        tasks.put("To Do",tasksTodo);
        tasks.put("Doing",tasksDoing);
        tasks.put("DOne",tasksDone);
    }

    public void addTask(Task task) {
        tasksTodo.add(task);
    }

    public void removeTask(Task task) {
        tasksTodo.remove(task);
    }

    /**
     * Identifica em qual section esta a task e move para a sessão após ela
     * Todo->Doing->Done
     * Se a task estiver em done não é possível mover
     * @param task
     */
    public void moveTask(Task task) {
        if (this.tasksTodo.contains(task)) {
            this.tasksTodo.remove(task);
            this.tasksDoing.add(task);
            System.out.printf("Moving task %s from 'ToDo' to 'Doing'%n", task.getTitle());
        } else if (tasksDoing.contains(task)) {
            this.tasksDoing.remove(task);
            this.tasksDone.add(task);
            System.out.printf("Moving task %s from 'Doing' to 'Done'%n", task.getTitle());

        }
        else System.out.println("Não é possível mover a task");
    }

    public static int getCount_tasks() {
        return count_tasks;
    }

    public static void setCount_tasks(int count_tasks) {
        Board.count_tasks = count_tasks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Task> getTasksTodo() {
        return tasksTodo;
    }

    public void setTasksTodo(ArrayList<Task> tasksTodo) {
        this.tasksTodo = tasksTodo;
    }

    public ArrayList<Task> getTasksDoing() {
        return tasksDoing;
    }

    public void setTasksDoing(ArrayList<Task> tasksDoing) {
        this.tasksDoing = tasksDoing;
    }

    public ArrayList<Task> getTasksDone() {
        return tasksDone;
    }

    public void setTasksDone(ArrayList<Task> tasksDone) {
        this.tasksDone = tasksDone;
    }

    public HashMap<String, ArrayList<Task>> getTasks() {
        return tasks;
    }

    public void setTasks(HashMap<String, ArrayList<Task>> tasks) {
        this.tasks = tasks;
    }



}
