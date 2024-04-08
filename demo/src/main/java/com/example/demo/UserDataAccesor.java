package com.example.demo;

import java.sql.Connection ;
import java.sql.DriverManager ;
import java.sql.SQLException ;
import java.sql.Statement ;
import java.sql.ResultSet ;

import java.util.List ;
import java.util.ArrayList ;

class UserDataAccessor {

    // in real life, use a connection pool....
    private Connection connection ;

    public UserDataAccessor(String driverClassName, String dbURL, String user, String password) throws SQLException, ClassNotFoundException {
        Class.forName(driverClassName);
        connection = DriverManager.getConnection(dbURL, user, password);
    }

    public void shutdown() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public List<User> getUserList() throws SQLException {
        try (
                Statement stmnt = connection.createStatement();
                ResultSet rs = stmnt.executeQuery("select * from person");
        ){
            List<User> userList = new ArrayList<>();
            while (rs.next()) {
                String userName = rs.getString("user_name");
                String password = rs.getString("password");
                User user = new User(userName, password);
                userList.add(user);
            }
            return userList;
        }
    }

    private void addUser(String username, String password){

    }

    private void deleteUser(String username, String password){

    }

}
