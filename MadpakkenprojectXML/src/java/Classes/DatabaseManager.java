/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Classes.Menu;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class DatabaseManager {

    Statement stmt = null;

    private static DatabaseManager instance = null;

    private DatabaseManager() {
    }

    public static synchronized DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    public void createSqlCon()
    {
        
    }
    
    public ArrayList<Menu> getMenus() {
        ArrayList<Menu> menus = new ArrayList<Menu>();

        String JDBC_DRIVER="com.mysql.jdbc.Driver";
        String DB_URL="jdbc:mysql://85.233.225.116/Madpakken";
        
        //  Database credentials
       String USER = "root";
       String PASS = "demo123";
       
       
         
       Connection conn = null;

         // Execute SQL query
         Statement stmt = null;
         
        
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
             conn = DriverManager.getConnection(DB_URL, USER, PASS);
          stmt = conn.createStatement();
            
            String sql = "SELECT * FROM Menu";
            ResultSet rs = stmt.executeQuery(sql);

            //Extract data from result set
            while (rs.next()) {
                Menu m = new Menu();
                
                String name = rs.getString("me_Name");
                int price = rs.getInt("me_Price");
                String desc = rs.getString("me_Description");
                
                m.setName(name);
                m.setDesc(desc);
                m.setPrice(price);
                menus.add(m);
                
                System.out.println("data menu");
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return menus;
    }
    
    public ArrayList<Child> getChilds() {
        ArrayList<Child> childs = new ArrayList<Child>();

        String JDBC_DRIVER="com.mysql.jdbc.Driver";
        String DB_URL="jdbc:mysql://85.233.225.116/Madpakken";
        
        //  Database credentials
       String USER = "root";
       String PASS = "demo123";
       
       
         
       Connection conn = null;

         // Execute SQL query
         Statement stmt = null;
         
        
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
             conn = DriverManager.getConnection(DB_URL, USER, PASS);
          stmt = conn.createStatement();
            
            String sql = "SELECT * FROM Child";
            ResultSet rs = stmt.executeQuery(sql);

            //Extract data from result set
            while (rs.next()) {
                Child c = new Child();
                
                String fName = rs.getString("ch_fName");
                String lName = rs.getString("ch_lName");
                String _class = rs.getString("ch_class");
                
                c.setfName(fName);
                c.setlName(lName);
                c.set_Class(_class);
                childs.add(c);
                
                System.out.println("data menu");
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return childs;
    }
    
    public ArrayList<Order> getOrders() {
        ArrayList<Order> orders = new ArrayList<Order>();

        String JDBC_DRIVER="com.mysql.jdbc.Driver";
        String DB_URL="jdbc:mysql://85.233.225.116/Madpakken";
        
        //  Database credentials
       String USER = "root";
       String PASS = "demo123";
       
       
         
       Connection conn = null;

         // Execute SQL query
         Statement stmt = null;
         
        
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
             conn = DriverManager.getConnection(DB_URL, USER, PASS);
          stmt = conn.createStatement();
            
            String sql = "SELECT * FROM `Order`";
            ResultSet rs = stmt.executeQuery(sql);

            //Extract data from result set
            while (rs.next()) {
                Order o = new Order();
                
                int price = rs.getInt("or_price");
                
                o.setPrice(price);
                orders.add(o);
                
                System.out.println("data menu");
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }
    
    
}
