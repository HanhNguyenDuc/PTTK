/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author nguye
 */
public class DAO {
    public static Connection conn;
     
    public DAO(){
        if(conn == null){
            String dbUrl = "jdbc:mysql://localhost:3306/pttk?autoReconnect=true&useSSL=false";
            String dbClass = "com.mysql.jdbc.Driver";
 
            try {
                Class.forName(dbClass);
                conn = DriverManager.getConnection (dbUrl, "root", "");
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
