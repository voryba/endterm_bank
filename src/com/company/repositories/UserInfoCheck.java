package com.company.repositories;

import com.company.data.PostgresDB;
import com.company.exception.WrongInputException;
import com.company.repositories.interfaces.IUserInfoCheck;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserInfoCheck implements IUserInfoCheck {
    Scanner scanner=new Scanner(System.in);
    Statement statement;
    ResultSet result;
    PostgresDB db;

    public void checkInfo() {
        System.out.println("Please,enter your login,but keep in mind that if you are new user for our bank,your account will be created automatically:");
        String username = scanner.nextLine();
        try {
            if (!areLetters(username)) {
                throw new WrongInputException("Input must contain only letters.Please,try again!");
            } else {
                statement = db.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                result = statement.executeQuery("SELECT * FROM user_info WHERE username=`" + username + "` ");
                if (result.next()) {
                    System.out.println("Please enter your password:");
                    String password = scanner.next();
                    while (!password.equals(result.getString(4))){
                        System.err.println("Password is incorrect,please try again!");
                        password = scanner.next();
                    }
                    System.out.println("Welcome back `"+username+"`!");
                }
                else {
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
                    result = st.executeQuery();
                    System.out.println("Account successfully created!");
                }
            }
        }catch (SQLException | WrongInputException throwable) {
            throwable.printStackTrace();
        }
    }

    protected boolean areLetters(String name){
        return name.matches("^[a-zA-Z]*$");
    }
}

