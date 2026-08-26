package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

public class Task {
    private int id;
    private int priority;
    private String title;
    private String description;
    private String target_data;
    private String category;
    private String section;

    /**
     * Inicializa Task sem Categoria
     * @param id
     * @param priority
     * @param title
     * @param description
     * @param target_data
     */
    public Task(int id, int priority, String title, String description, String target_data) {
        this(id, priority, title, description, target_data, "Sem categoria","ToDo");
    }

    public Task(int id, int priority, String title, String description, String target_data, String category) {
        this(id, priority, title, description, target_data, category, "ToDo");
    }

    /**
     * Inicializa task com Categoria
     * @param id
     * @param priority
     * @param title
     * @param description
     * @param target_data
     * @param category
     */
    public Task(int id, int priority, String title, String description, String target_data, String category, String section) {
        LocalDate createDate = LocalDate.now();

        this.id = id;
        this.priority = priority;
        this.title = title;
        this.description = description;
        this.target_data = target_data;
        this.category = category;
        this.section = section;
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

    public String getTarget_data() {
        return target_data;
    }

    public void setTarget_data(String target_data) {
        this.target_data = target_data;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
}
