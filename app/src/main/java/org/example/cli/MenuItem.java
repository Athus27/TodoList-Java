package org.example.cli;

public class MenuItem {
    private String key;
    private String label;
    private String action;

    public MenuItem() {
    }

    public MenuItem(String key, String label, String action) {
        this.key = key;
        this.label = label;
        this.action = action;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return
                String.format("[%s] - %s.", key, label);
    }
}
