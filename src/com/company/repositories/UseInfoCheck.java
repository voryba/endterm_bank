package com.company.repositories;

import com.company.data.PostgresDB;
import com.company.repositories.interfaces.IUserInfoCheck;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UseInfoCheck implements IUserInfoCheck {
    Scanner scanner=new Scanner(System.in);
    Statement statement;
    ResultSet result;
    PostgresDB db;

    public void checkInfo() {
        System.out.println("Please,enter your login,but keep in mind that if you are new user for our bank,your account will be created automatically:");
        String username=scanner.nextLine();
        try {
            statement = db.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            result=statement.executeQuery("SELECT * FROM user-info WHERE username=`"+username+"` ");
            if(result.next()){
                System.out.println("Please enter your password:");
                String password=scanner.nextLine();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    protected boolean areLetters(String name){
        return name.matches("^[a-zA-Z]*$");
    }
}
