package com.store.dal.repo;

import com.store.dal.entity.users;
import com.store.dal.manager.DBManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserRepo {

    public void insertUser(users usr) {

        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DBManager.getConnection();
            stmt = conn.prepareStatement("INSERT INTO USERS (USER_ID , USER_FULL_NAME ,EMAIL , USER_NAME ,USER_PASSWORD) VALUES (? , ? , ? ,? , ? )");

            stmt.setInt(1, usr.getUserId());
            stmt.setString(2, usr.getUserFullName());
            stmt.setString(3, usr.getEmail());
            stmt.setString(4, usr.getUserName());
            stmt.setString(5, usr.getUserPassword());

            int r = stmt.executeUpdate();
            System.out.println(r);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBManager.closePreparedstatmen(stmt);
            DBManager.closeConnection(conn);
        }
    }

    public void deleteUserByPK(users usr) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DBManager.getConnection();
            stmt = conn.prepareStatement("DELETE FROM USERS WHERE USER_ID = ?");

            stmt.setInt(1, usr.getUserId());

            int r = stmt.executeUpdate();
            System.out.println(r);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBManager.closePreparedstatmen(stmt);
            DBManager.closeConnection(conn);
        }
    }

    public void updateRecord(users usr) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DBManager.getConnection();
            stmt = conn.prepareStatement("UPDATE USERS SET USER_NAME = ? , USER_PASSWORD = ? WHERE USER_ID = ?");
            stmt.setString(1, usr.getUserName());
            stmt.setString(2, usr.getUserPassword());
            stmt.setInt(3, usr.getUserId());

            int r = stmt.executeUpdate();
            System.out.println(r);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBManager.closePreparedstatmen(stmt);
            DBManager.closeConnection(conn);
        }
    }

    public ArrayList<users> findAllUser() {
        ArrayList<users> al = new ArrayList<>();
        users usr = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DBManager.getConnection();
            stmt = conn.prepareStatement("SELECT USER_ID ,USER_FULL_NAME ,EMAIL , USER_NAME , USER_PASSWORD FROM USERS ");

            rs = stmt.executeQuery();

            while (rs.next()) {
                usr = new users();
                
                usr.setUserId(rs.getInt("USER_ID"));
                usr.setUserFullName(rs.getString("USER_FULL_NAME"));
                usr.setEmail(rs.getString("EMAIL"));
                usr.setUserName(rs.getString("USER_NAME"));
                usr.setUserPassword(rs.getString("USER_PASSWORD"));
                al.add(usr);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBManager.closeResultSet(rs);
            DBManager.closePreparedstatmen(stmt);
            DBManager.closeConnection(conn);
        }
        return al;
    }

    public users findUser(String userName, String userPassword) {

        users user = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        if (userName == null || userPassword == null) {
            return user;
        } else {
            try {
                conn = DBManager.getConnection();
                stmt = conn.prepareStatement("SELECT USER_ID , USER_FULL_NAME , EMAIL , USER_NAME , USER_PASSWORD FROM USERS WHERE USER_NAME = ? and USER_PASSWORD = ?");
                stmt.setString(1, userName);
                stmt.setString(2, userPassword);
                rs = stmt.executeQuery();

                while (rs.next()) {
                    user = new users();
                    user.setUserId(rs.getInt("USER_ID"));
                    user.setUserFullName(rs.getString("USER_FULL_NAME"));
                    user.setEmail(rs.getString("EMAIL"));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                DBManager.closeResultSet(rs);
                DBManager.closePreparedstatmen(stmt);
                DBManager.closeConnection(conn);
            }
        }

        return user;
    }

}
