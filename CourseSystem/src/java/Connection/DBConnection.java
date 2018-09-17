/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import Entity.Students;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ASUS
 */
public class DBConnection {
    private Connection conn;
    
    public DBConnection() throws SQLException{
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/coursechoose?zeroDateTimeBehavior=convertToNull", "root", "Lyy19980122");
    }
    
    public Connection getConnection(){
        return conn;
    }
    
    public ResultSet query(String sql) throws SQLException{
        Statement stmt=(Statement)conn.createStatement();
        ResultSet rs=stmt.executeQuery(sql);
        return rs;
    }
    
    
    public void insert_student(String sql,Students student) throws SQLException{
        PreparedStatement pst=conn.prepareStatement(sql);
        pst.setString(1, student.getSno());
        pst.setString(2,student.getSname());
        pst.setString(3,student.getSpassword());
        pst.executeUpdate();
    }    
}
