package com.company;

import com.company.data.PostgresDB;
import com.company.entities.User;
import com.company.exception.WrongInputException;
import com.company.repositories.OwnerRepository;
import com.company.repositories.Updates;
import com.company.repositories.UserInfoCheck;
import com.company.repositories.UserRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class Application {
    PostgresDB db;
    OwnerRepository ownerRepository = new OwnerRepository();
    Updates updates = new Updates();
    UserInfoCheck userInfoCheck = new UserInfoCheck();
    User user;
    UserRepository userRepo = new UserRepository();

    {
        try {
            db = PostgresDB.getInstance();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    Scanner scanner = new Scanner(System.in);


    //Owner
    public void doActionOwner() {
        System.out.println("MENU:");
        char quit = 'n';
        String input;
        int choice;
        while (quit != 'y') {
            System.out.println("""
                    Available options:
                    delete-1
                    update-2
                    transaction-3
                    Exit-0""");
            choice = scanner.nextInt();
            try {
                switch (choice) {
                    case 1 -> {
                        delete();
                    }
                    case 2 -> {
                        update();
                    }
                    case 3 -> {
                        transaction();
                    }
                    case 0 -> {
                        return;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Would you like to quit y or n");
            input = scanner.next().toLowerCase();
            quit = input.charAt(0);
        }
    }

    public void delete() {
        System.out.println("Please,enter the name:");
        String name = scanner.next();
        if(ownerRepository.deleteUserByName(name)) System.out.println("Successfully deleted!");
        else System.err.println("Failed!");
    }


    public void update() {
        System.out.println("MENU:");
        char quit = 'n';
        String input;
        int choice;
        while (quit != 'y') {
            System.out.println("""
                    Available options:
                    update name-1
                    update surname-2
                    update contacts-3
                    update address-4
                    update password-5
                    Exit-0""");
            choice = scanner.nextInt();
            try {
                switch (choice) {
                    case 1 -> {
                        System.out.println("Please,enter the new name:");
                        String newUserName = scanner.next();
                        if (updates.updateName(newUserName, userInfoCheck.getUsername()))
                            System.out.println("Successfully updated!");
                        else System.err.println("Failed!");
                    }
                    case 2 -> {
                        System.out.println("Please,enter the new surname,that you want to update");
                        String newUserSurname = scanner.next();
                        if(!areLetters(newUserSurname))
                        if (updates.updateSurname(newUserSurname, userInfoCheck.getUsername()))
                            System.out.println("Successfully updated!");
                        else System.err.println("Failed!");
                    }
                    case 3 -> {
                        System.out.println("Please,enter the new contact,that you want to update");
                        String contact = scanner.next();
                        if (updates.updateSurname(contact, userInfoCheck.getUsername()))
                            System.out.println("Successfully updated!");
                        else System.err.println("Failed!");
                    }
                    case 4 -> {
                        System.out.println("Please,enter the new address,that you want to update");
                        String address = scanner.next();
                        if (updates.updateAddress(address, userInfoCheck.getUsername()))
                            System.out.println("Successfully updated!");
                        else System.err.println("Failed!");
                    }
                    case 5 -> {
                        System.out.println("Please,enter the new password,that you want to update");
                        String password = scanner.next();
                        if (updates.changePassword(password, userInfoCheck.getUsername()))
                            System.out.println("Successfully updated!");
                        else System.err.println("Failed!");
                    }
                    case 0 -> {
                        return;
                    }
                }
            } catch (Exception e) {
                System.out.println("Update error!");
                e.printStackTrace();
            }
            System.out.println("Would you like to quit y or n");
            input = scanner.next().toLowerCase();
            quit = input.charAt(0);

        }
    }

    public void transaction() {
        if(ownerRepository.transactions())System.out.println("Transaction has been successfully ended!");
        else System.err.println("Failed!");
    }


    //USER


    public void doActionUser() {

        System.out.println("MENU:");
        char quit = 'n';
        String input;
        int choice;
        while (quit != 'y') {
            System.out.println("""
                    Available options:
                    transaction-1
                    -2
                    balance-3
                    Exit-0""");
            choice = scanner.nextInt();
            try {
                switch (choice) {
                    case 1 -> {

                    }
                    case 2 -> {
                        update();
                    }
                    case 3 -> {
                        balanceCheck();
                    }
                    case 0 -> {
                        return;
                    }
                }
            } catch (Exception e) {
                System.out.println("User error!");
                e.printStackTrace();
            }
            System.out.println("Would you like to quit y or n");
            input = scanner.next().toLowerCase();
            quit = input.charAt(0);
        }
    }

    public void balanceCheck() {
        user = userRepo.getBalance(userInfoCheck.getUsername());
        System.out.println("User{ " +
                "First name:'" + user.getName() + "' || " +
                "Surname:'" + user.getSurname() + "' || " +
                "Username: '" + user.getUsername() + "' || " +
                "is'" + user.getAge() + "'years old" + " || " +
                "living in'" + user.getAddress() + "' || " +
                "Contact details:'" + user.getContact_number() + "' || " +
                "Balance:'" + user.getAccount() + "'");
    }
    protected boolean areLetters(String a){
        return a.matches("^[a-zA-Z]*$");
    }
}
/// Меня тут не может быть дохуя