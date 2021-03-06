package com.company.repositories;

import com.company.data.PostgresDB;
import com.company.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {
    // get balance info
    public User getBalance(String username){
        User user = null;
        PreparedStatement st = null;
        Connection con = null;
        try {
            con = PostgresDB.getInstance().getConnection();

            String sql ="select * from user_info where username = '" + username + "'";

            st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                user = new User(rs.getString("name"), rs.getString("surname"),
                        username, rs.getString("password"),
                        rs.getInt("account"),rs.getInt("age"),rs.getString("contact_number"),rs.getString("address"));
            }
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
                st.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
    // transfer money to another user

    // change password and updates methods defined in 'Updates' class;
}
