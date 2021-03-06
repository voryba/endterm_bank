package com.company;

import com.company.data.PostgresDB;
import com.company.exception.WrongInputException;
import com.company.repositories.OwnerRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class Application {
    PostgresDB db;
    OwnerRepository ownerRepository= new OwnerRepository();
    {
        try {
            db = PostgresDB.getInstance();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    Scanner scanner = new Scanner(System.in);


    public void doAction() throws WrongInputException {
        System.out.println("MENU:");
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
        choice = scanner.nextInt();

        switch (choice) {
            case 1->{
                System.out.println("Please,enter the name:");
                String name=scanner.next();
                ownerRepository.deleteUserByName(name);
            }
            case 2->{

            }
            case 3->{return;}
            default->{throw new WrongInputException("Input must contain only digits,please try again!");}

        }
        System.out.println("Would you like to quit y or n");
        input = scanner.next().toLowerCase();
        quit = input.charAt(0);


    }
public void update(){
    System.out.println("MENU:");
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
    choice = scanner.nextInt();
    switch (choice) {
        case 1
    ->{System.out.println("Please,enter the name:");
            String name=scanner.next();
            System.out.println("Please,enter the username");
            String username= scanner.next();
            ownerRepository.updateName(name,username);
        case 2:
    }

}
}

/// Меня тут не может быть дохуя