package com.company.repositories;

import com.company.data.PostgresDB;
import com.company.repositories.interfaces.IOwnerRepository;

import java.sql.*;

public class OwnerRepository implements IOwnerRepository {
    // get all transactions
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

    // change password and updates methods defined in 'Updates' class;
}
