package com.company.repositories;

import com.company.Application;
import com.company.data.PostgresDB;
import com.company.repositories.interfaces.IUserInfoCheck;

import java.sql.*;
import java.util.Scanner;

public class UserInfoCheck implements IUserInfoCheck {
    Scanner scanner=new Scanner(System.in);
    Statement statement;
    ResultSet result;
    PostgresDB db;
    int i = 0;
    boolean owner = false;
    static String username;
    Application app;
    public void checkInfo(){
        System.out.println("Please,enter your login,but keep in mind that if you are new user for our bank,your account will be created automatically:");
        username = scanner.nextLine();
        try {
            if (!areLetters(username)) {
                System.out.println("Input must contain only letters.Please,try again!");
            } else {
                db = PostgresDB.getInstance();
                statement = db.getConnection().createStatement();
                result = statement.executeQuery("select * from user_info where username = '" + username + "'");
                if (result.next()) {
                    System.out.println("Please enter your password:");
                    String password = scanner.next();
                    while (!password.equals(result.getString(4))){
                        System.err.println("Password is incorrect,please try again!");
                        password = scanner.next();
                        i++;

                    }
                    System.out.println("Welcome back `"+username+"`!");
                    app = new Application();
                    app.doActionUser();
                }else if(!result.next()) {
                    owner = true;
                    result = statement.executeQuery("select * from owners_info where username = '" + username + "'");
                    if (result.next()) {
                        System.out.println("You are owner, please enter your password:");
                        String password = scanner.next();
                        while (!password.equals(result.getString(4))){
                            System.err.println("Password is incorrect,please try again!");
                            password = scanner.next();
                        }
                        System.out.println("Welcome back owner`"+username+"`!");
                        app = new Application();
                        app.doActionOwner();
                    }else {
                        PreparedStatement st = db.getConnection().prepareStatement("INSERT INTO user_info(name, surname, username, password, account, age, contact_number, address) " +
                                "VALUES(?,?,?,?,?,?,?,?)");
                        //
                        System.out.println("You are new user, you must create a unique password that should contain only letters!");
                        String password=scanner.next();
                        System.out.println("Please, enter your name:");
                        String name = scanner.next();
                        System.out.println("Please, enter your surname:");
                        String surname = scanner.next();
                        System.out.println("Please, enter your age:");
                        int age = scanner.nextInt();
                        System.out.println("Please, enter your phone number:");
                        String contact_number = scanner.next();
                        System.out.println("Please, enter your address:");
                        String address = scanner.next();
                        //
                        st.setString(1,name);
                        st.setString(2,surname);
                        st.setString(3,username);
                        st.setString(4,password);
                        st.setInt(5,0);
                        st.setInt(6,age);
                        st.setString(7,contact_number);
                        st.setString(8,address);
                        //
                        st.execute();
                        System.out.println("Account successfully created!");
                    }
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                db.getConnection().close();
                result.close();
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    protected boolean areLetters(String name){
        return name.matches("^[a-zA-Z]*$");
    }

    public String getUsername(){
        return username;
    }
}

