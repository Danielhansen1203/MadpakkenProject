/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import Classes.DatabaseManager;
import Classes.Menu;
import com.thoughtworks.xstream.XStream;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 *
 * @author Daniel
 */
@WebServlet(name = "api", urlPatterns = {"/api"})
public class api extends HttpServlet {
    
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
    throws ServletException, IOException {
        
        String JDBC_DRIVER="com.mysql.jdbc.Driver";
        String DB_URL="jdbc:mysql://85.233.225.116/Madpakken";
        
        //  Database credentials
       String USER = "root";
       String PASS = "demo123";

      // Set response content type
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Database Result";
      String docType =
        "<!doctype html public \"-//w3c//dtd html 4.0 " +
         "transitional//en\">\n";
         out.println(docType +
         "<html>\n" +
         "<head><title>" + title + "</title></head>\n" +
         "<body bgcolor=\"#f0f0f0\">\n" +
         "<h1 align=\"center\">" + title + "</h1>\n");
         Connection conn = null;

         // Execute SQL query
         Statement stmt = null;
      try{
         // Register JDBC driver
         Class.forName("com.mysql.jdbc.Driver");
         
         conn = DriverManager.getConnection(DB_URL, USER, PASS);
          stmt = conn.createStatement();
         String sql;
         sql = "SELECT * FROM User";
         ResultSet rs = stmt.executeQuery(sql);

         // Extract data from result set
         while(rs.next()){
            //Retrieve by column name
            int id  = rs.getInt("us_userID");
            String name = rs.getString("us_Name");
            String first = rs.getString("us_password");
            

            //Display values
            out.println("ID: " + id + "<br>");
            out.println("Username: " + name + "<br>");
            out.println("Password: " + first + "<br>");
            
         }
         out.println("</body></html>");

         // Clean-up environment
         rs.close();
         stmt.close();
         conn.close();
      }catch(SQLException se){
         //Handle errors for JDBC
         se.printStackTrace();
      }catch(Exception e){
         //Handle errors for Class.forName
         e.printStackTrace();
      }finally{
         //finally block used to close resources
         try{
            if(stmt!=null)
               stmt.close();
         }catch(SQLException se2){
         }// nothing we can do
         try{
            if(conn!=null)
            conn.close();
         }catch(SQLException se){
            se.printStackTrace();
         }//end finally try
      } //end try
   }
    
    //XML stuff
    public String toXml()
    {

        //create new XStream
        XStream xstream = new XStream();
        //set custom tag name
        xstream.alias("menu", Menu.class); 
        
        //used to store the returned data
        ArrayList<Menu> menuList = new ArrayList<Menu>();
        
        String s = "";
        String xml = "";
        
        //grap xml resualts and add them to our list
            for (Menu m : DatabaseManager.getInstance().getMenus()) 
            {
                s += m.getName();
                s += m.getDesc();
                s += m.getPrice();
                
                //add current menu to the list
                menuList.add(m);
            }
    
       //transform into xml
       xml = xstream.toXML(menuList);
       return xml;
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet api</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet api at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}