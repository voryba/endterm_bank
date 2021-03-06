package com.company.repositories;

import com.company.data.PostgresDB;
import com.company.repositories.interfaces.IUserInfoCheck;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class OwnerRepository{
    // delete by username
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
    // Get all transactions
    public boolean transactions(){
        PreparedStatement st = null;
        Connection con = null;
        try {
            con = PostgresDB.getInstance().getConnection();

            String sql ="select * from transaction";

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
    // Update name
    public boolean updateName(String newName, String username){
        PreparedStatement st = null;
        Connection con = null;
        try {
            con = PostgresDB.getInstance().getConnection();

            String sql ="update user_info set name = '"+newName+"' where username = '" + username + "'";

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
    // Update surname
    public boolean updateSurname(String newSurname, String username){
        PreparedStatement st = null;
        Connection con = null;
        try {
            con = PostgresDB.getInstance().getConnection();

            String sql ="update user_info set surname = '"+newSurname+"' where username = '" + username + "'";

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
    // Update contact number
    public boolean updateContacts(String contact, String username){
        PreparedStatement st = null;
        Connection con = null;
        try {
            con = PostgresDB.getInstance().getConnection();

            String sql ="update user_info set contact_number = '"+contact+"' where username = '" + username + "'";

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
}
