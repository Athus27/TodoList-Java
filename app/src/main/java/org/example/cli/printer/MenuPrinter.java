package org.example.cli.printer;

import org.example.cli.Menu;
import org.example.cli.MenuItem;

public class MenuPrinter {
    public static void printMenu(Menu menu) {
        System.out.println();
        System.out.println(menu.getTitle());
        System.out.println("------------------------------");

        for (MenuItem item : menu.getItems()) {
            System.out.println(item);
        }
    }
}
