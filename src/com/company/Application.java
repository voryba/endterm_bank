package com.company;

import com.company.data.PostgresDB;

import java.sql.SQLException;
import java.util.Scanner;

public class Application {
    PostgresDB db;

    {
        try {
            db = PostgresDB.getInstance();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    Scanner scanner = new Scanner(System.in);


    public void doAction() {
        System.out.println("IT company MENU:");
        char quit = 'n';
        String input;
        int choice;
        while (quit != 'y') {
            System.out.println("""
                    Available options:
                    insert-1
                    request-2
                    delete-3
                    Exit-0""");
        }
    }
}

/// Меня тут не может быть дохуя