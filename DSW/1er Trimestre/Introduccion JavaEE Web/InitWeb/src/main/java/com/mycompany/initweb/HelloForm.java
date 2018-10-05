/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.initweb;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Josué Ramírez
 */
public class HelloForm extends HttpServlet {
    
    public void DoGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        String title = "Using GET Method to Read Form Data";
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
        
        out.println(docType + "<html>\n" +
            "<head><title>" + title + "</title></head>\n" +
            "<body bgcolor = \"#f0f0f0\">\n" +
            "<h1 align = \"center\">" + title + "</h1>\n" +
            "<ul>\n" +
            " <li><b>First Name</b>: "
            + request.getParameter("first_name") + "\n" +
            " <li><b>Last Name</b>: "
            + request.getParameter("last_name") + "\n" +
            "</ul>\n" +
            "</body></html>");
        
    }
    
}
