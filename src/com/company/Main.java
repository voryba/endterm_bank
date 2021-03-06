package com.company;

import com.company.repositories.OwnerRepository;
import com.company.repositories.UserInfoCheck;
import com.company.repositories.UserRepository;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserRepository repo = new UserRepository();
        repo.transfer("asdasd","yernur",500);
    }
}
