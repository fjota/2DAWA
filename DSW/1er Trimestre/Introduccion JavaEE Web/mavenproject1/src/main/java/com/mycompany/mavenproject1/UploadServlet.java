/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Josué Ramírez
 */
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
    maxFileSize=1024*1024*10, // 10MB
    maxRequestSize=1024*1024*50)

public class UploadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        /*                  CHECKBOX
        String languages[] = request.getParameterValues("language");
        PrintWriter out = response.getWriter();
        
        if (languages != null) {
            out.println("Languages are: ");
            for (String lang : languages) {
                out.println("\t" + lang);
            }
        }
         */
 /*                  RADIO BUTTONS
        String gender = request.getParameter("gender");
        out.println("Gender is: " + gender);;*/
 /*                  TEXT AREA
        String feedback = request.getParameter("feedback");
        out.println("FeedBack is: " + gender);*/
        String jobCat = request.getParameter("jobCat");
        out.println("The Job is : " + jobCat);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
