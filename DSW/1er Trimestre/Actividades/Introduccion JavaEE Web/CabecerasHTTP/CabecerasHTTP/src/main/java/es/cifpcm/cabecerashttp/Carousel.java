/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.cabecerashttp;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Josué Ramírez
 */
public class Carousel extends HttpServlet {

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
    PrintWriter out = response.getWriter();
    try {
      /* TODO output your page here. You may use following sample code. */
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"" + request.getContextPath() + "/main.css" + "\">");
      out.println("<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">");
      out.println("<title>Servlet Carousel</title>");      
      out.println("</head>");
      out.println("<body>");
      out.println("<h2 class=\"w3-center\">Manual Slideshow</h2>");
      out.println("<div class=\"w3-content w3-display-container\">");
      out.println("<img class=\"mySlides\" src=\""+ request.getContextPath() + "/img" +"/img_snowtops.jpg\" style=\"width:100%\">");      
      out.println("<img class=\"mySlides\" src=\""+ request.getContextPath() + "/img" +"/img_lights.jpg\" style=\"width:100%\">");
      out.println("<img class=\"mySlides\" src=\""+ request.getContextPath() + "/img" +"/img_mountains.jpg\" style=\"width:100%\">");
      out.println("<img class=\"mySlides\" src=\""+ request.getContextPath() + "/img" +"/img_forest.jpg\" style=\"width:100%\">");
      out.println("<button class=\"w3-button w3-black w3-display-left\" onclick=\"plusDivs(-1)\">&#10094;</button>");
      out.println("<button class=\"w3-button w3-black w3-display-right\" onclick=\"plusDivs(1)\">&#10095;</button>");
      out.println("</div>");      
      out.println("<script src=\""+ request.getContextPath() + "/script.js" +"\"></script>");
      out.println("</body>");
      out.println("</html>");
    } finally {
      out.close();
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
