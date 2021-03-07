package com.company.repositories;

import com.company.data.PostgresDB;
import com.company.entities.Transaction;
import com.company.entities.User;
import com.company.repositories.interfaces.IOwnerRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class OwnerRepository implements IOwnerRepository {
    // get all transactions
    public List<Transaction> transactions(){
        PreparedStatement st = null;
        Connection con = null;
        Transaction transaction;
        try {
            con = PostgresDB.getInstance().getConnection();

            String sql ="select * from transaction";

            st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            List<Transaction> list = new LinkedList<>();
            while (rs.next()){
                transaction = new Transaction(rs.getInt("id"),rs.getString("username"),
                        rs.getString("name"),rs.getString("surname"),
                        rs.getInt("account_changes"),rs.getDate("date").toLocalDate());
                list.add(transaction);
            }
            return list;
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
    // delete user from data by username
    public boolean deleteUserByName(String username){
        PreparedStatement st = null;
        Connection con = null;
        try {
            con = PostgresDB.getInstance().getConnection();

            String sql ="DELETE FROM user_info WHERE username = '"+username+"'";

            st = con.prepareStatement(sql);
            st.execute();
            return true;
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
        return false;
    }
    // get all users
    public List<User> getAll(){
        PreparedStatement st = null;
        Connection con = null;
        User user;
        try {
            con = PostgresDB.getInstance().getConnection();

            String sql ="select * from user_info";

            st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            List<User> list = new LinkedList<>();
            while (rs.next()){
                user = new User(rs.getString("name"), rs.getString("surname"),
                        rs.getString("username"), rs.getString("password"),
                        rs.getInt("account"),rs.getInt("age"),rs.getString("contact_number"),rs.getString("address"));
                list.add(user);
            }
            return list;
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
    // change password and updates methods defined in 'Updates' class;
}
