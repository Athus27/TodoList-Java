package org.example.cli;

//import java.
//import java.awt.*;
//import java.awt.*;
import java.awt.*;
import java.util.List;

public class MenuConfig {
    public String appName;
    public List<Menu> menus;

    public MenuConfig() {
    }
    public MenuConfig(String appName, List<Menu> menus) {
        this.appName = appName;

    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}
