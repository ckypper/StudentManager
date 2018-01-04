/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dan;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author admin
 */
public class DBContext {
    public Connection getConnection() throws Exception {
        //load jdbc driver
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //open connection
        String url = "jdbc:sqlserver://ADMIN-PC\\SQLEXPRESS:51326;databaseName=StudentManagement;"
                + "user=sa;password=chyp412";
        return DriverManager.getConnection(url);
    }
}
