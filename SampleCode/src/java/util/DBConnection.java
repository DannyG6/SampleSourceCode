/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DannyG
 */
public class DBConnection {

    public static Connection createConnection() throws ClassNotFoundException, SQLException {
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/samplereflekt";
        String DBusername = "root";
        String DBpassword = "";

        Class.forName("com.mysql.jdbc.Driver");
        con = (Connection) DriverManager.getConnection(url, DBusername, DBpassword);
        return con;
    }
}
