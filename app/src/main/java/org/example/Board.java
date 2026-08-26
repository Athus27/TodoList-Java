package org.example;

import java.util.ArrayList;
import java.util.Comparator;

public class Board {
    private static int count_tasks = 0;
    private int id;
    private int priority;
    private String title;
    private String description;

    private ArrayList<Task> tasks = new ArrayList<>();

    public Board(int id, int priority, String title, String description) {
        this.id = id;
        this.priority = priority;
    }

    public void addTask(Task task) {
        tasks.add(task);
        orderTasksBySection();
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    /**
     * Identifica em qual section esta a task e move para a sessão após ela
     * Todo->Doing->Done
     * Se a task estiver em done não é possível mover
     *
     * @param task
     */
    public void moveTask(Task task) {

        switch (task.getSection()) {
            case "ToDo":
                task.setSection("Doing");
                break;
            case "Doing":
                task.setSection("Done");
                break;
            default:
                System.out.println("Impossível remover tarefa");
                break;
        }
        this.orderTasksBySection();

    }

    /**
     * Ordena as tarefas primeiro por seção e, dentro de cada seção, por prioridade.
     * A ordem das seções é definida pelo método sectionOrder.
     */
    private void orderTasksBySection() {
        // Ordena primeiro por secao e, dentro de cada secao, por prioridade.
        tasks.sort(
                Comparator.comparingInt((Task task) -> sectionOrder(task.getSection()))
                        .thenComparing(Comparator.comparingInt(Task::getPriority).reversed())
        );

    }


    /**
     * Define a ordem das seções para a ordenação.
     * "ToDo" vem primeiro,
     * seguido por "Doing"
     * e depois "Done".
     *
     * @param section
     * @return
     */
    private int sectionOrder(String section) {
        return switch (section) {
            case "ToDo" -> 1;
            case "Doing" -> 2;
            case "Done" -> 3;
            default -> 4;
        };
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
        ArrayList<Task> tasksToDo = new ArrayList<>();
        for (Task currentTask : this.tasks) {
            if (currentTask.getSection().equals("ToDo")) {
                tasksToDo.add(currentTask);
            }
        }
        return tasksToDo;
    }

    public ArrayList<Task> getTasksDoing() {
        return getTasksBySection("Doing");
    }

    public ArrayList<Task> getTasksDone() {
        return getTasksBySection("Done");
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
        orderTasksBySection();
    }

    public ArrayList<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    public ArrayList<Task> getTasksByPriority() {
        ArrayList<Task> allTasks = getAllTasks();
        allTasks.sort(Comparator.comparingInt(Task::getPriority).reversed());
        return allTasks;
    }

    public ArrayList<Task> getTasksByCategory(String category) {
        ArrayList<Task> filteredTasks = new ArrayList<>();

        for (Task task : getAllTasks()) {
            if (task.getCategory().equalsIgnoreCase(category)) {
                filteredTasks.add(task);
            }
        }

        return filteredTasks;
    }

    public ArrayList<Task> getTasksBySection(String section) {
        ArrayList<Task> filteredTasks = new ArrayList<>();

        for (Task task : tasks) {
            if (task.getSection().equalsIgnoreCase(section)) {
                filteredTasks.add(task);
            }
        }

        return filteredTasks;
    }

    public ArrayList<Task> getTasksByStatus(String status) {
        return getTasksBySection(status);
    }

    /**
     * Dado um titulo de task, percorre a lista de tasks e retorna a task correspondente, caso exista. Se não encontrar, retorna null.
     *
     * @param title
     * @return Task
     */
    public Task findTask(String title) {
        for (Task task : tasks) {
            if (task.getTitle().equals(title)) {
                System.out.println("found task " + title + " on section " + task.getSection());
                return task;
            }
        }
        System.out.println("Task not found");
        return null;
    }
}
