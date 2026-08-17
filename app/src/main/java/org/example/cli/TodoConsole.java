package org.example.cli;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream; //serve pra ler arquivo/recurso

public class TodoConsole {


    public void menu() {
        ObjectMapper mapper = new ObjectMapper();

        MenuConfig menuConfig;
        try {
            InputStream inputStream = getClass().getResourceAsStream("/menu/menu.json");
            menuConfig = mapper.readValue(inputStream, MenuConfig.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        System.out.println("--------------------------------");
        System.out.println(menuConfig.getAppName());
        System.out.println("------------------------------");

        for (Menu menu  : menuConfig.getMenus() ) {
            System.out.println("\n"+menu.getTitle());
            System.out.println("------------------------------");
             for (MenuItem item : menu.getItems()) {
                 System.out.println(item);
             }
        }

    }

    void options() {
        System.out.println("-----------------------------");
    }
}
