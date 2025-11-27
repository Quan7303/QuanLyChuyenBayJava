/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author LENOVO
 */
public class DataConnection {
    public static Connection connection;
    public static Statement statement;
    
    public static void createStatement(){
        String url = "jdbc:mysql://localhost:3306/qlmb?autoReconnect=true&useSSL=false";
        String username = "root";
        String password ="0867755047ha";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection(url,username,password);
            statement = connection.createStatement();
        }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(DataConnection.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }
    
    public static ResultSet retrieveData(String sql){
        try{
            createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            return resultSet;
        }catch(SQLException ex){
            Logger.getLogger(DataConnection.class.getName()).log(Level.SEVERE,
                    null, ex);
            return null;
        }
    }

    public DataConnection() {
    }
}
