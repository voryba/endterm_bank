package com.company.repositories;

import com.company.data.PostgresDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Updates {
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
    // Update address
    public boolean updateAddress(String newAddress, String username){
        PreparedStatement st = null;
        Connection con = null;
        try {
            con = PostgresDB.getInstance().getConnection();

            String sql ="update user_info set address = '"+ newAddress +"' where username = '" + username + "'";

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
    // Change password
    public boolean changePassword(String newPassword, String username){
        PreparedStatement st = null;
        Connection con = null;
        try {
            con = PostgresDB.getInstance().getConnection();

            String sql ="update user_info set password = '"+newPassword+"' where username = '" + username + "'";

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
