/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Classes.DatabaseManager;
import Classes.Menu;
import api.api;
import com.thoughtworks.xstream.XStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
@WebServlet(name = "MenuServlet", urlPatterns = {"/MenuServlet"})
public class MenuServlet extends HttpServlet {
    
    
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
        response.setContentType("text/xml;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            //print out xml
            api a = new api();
            out.println(a.toXmlMenu());
            
            //xmlToFile();
        }
    }
    
    void xmlToFile()
    {
        Menu m = new Menu();
        m.setDesc("Test");
        m.setName("Menu 01");
        m.setPrice(60);
        
        FileOutputStream fos = null;
        File f; 
        String xmlFile = "Empty";
        
        try 
        {
            f = new File("C:/Menu.xml");
            fos = new FileOutputStream(f);
            
            if (!f.exists()) 
            {
                f.createNewFile();
            }
            
            //create new XStream
            XStream xstream = new XStream();
            //set custom tag name
            xstream.alias("menu", Menu.class);
            
            ArrayList<Menu> am = new ArrayList<>();
            am.add(m);
            
            xmlFile = xstream.toXML(am);
            
            byte[] br = xmlFile.getBytes();
            
            fos.write(br);
            fos.flush();
            fos.close();
        } 
        catch (Exception e) 
        {

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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

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
