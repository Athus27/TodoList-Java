package org.example;

public class Task {
    private int id;
    private int priority;
    private String title;
    private String description;
    private String create_data;
    private String target_data;

    public Task(int id, int priority, String title, String description, String create_data, String target_data) {
        this.id = id;
        this.priority = priority;
        this.title = title;
        this.description = description;
        this.create_data = create_data;
        this.target_data = target_data;
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

    public String getCreate_data() {
        return create_data;
    }

    public void setCreate_data(String create_data) {
        this.create_data = create_data;
    }

    public String getTarget_data() {
        return target_data;
    }

    public void setTarget_data(String target_data) {
        this.target_data = target_data;
    }
}
