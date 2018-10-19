package es.cifpcm.file;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)   // 50MB
public class ImageManagerServlet extends HttpServlet {

  private static final String PATH_FILES = "uploads";

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

    // gets absolute path of the web application
    String appPath = request.getServletContext().getRealPath("");
    // constructs path of the directory to save uploaded file
    String savePath = appPath + File.separator + PATH_FILES;

    // creates the save directory if it does not exists
    File fileSaveDir = new File(savePath);
    if (!fileSaveDir.exists()) {
      fileSaveDir.mkdir();
    }

    for (Part part : request.getParts()) {
      String fileName = extractFileName(part);
      // refines the fileName in case it is an absolute path
      fileName = new File(fileName).getName();
      part.write(savePath + File.separator + fileName);
      System.out.println(savePath + File.separator + fileName);
    }
    
    doGet(request, response);
  }

  private String extractFileName(Part part) {
    String contentDisp = part.getHeader("content-disposition");
    String[] items = contentDisp.split(";");
    for (String s : items) {
      if (s.trim().startsWith("filename")) {
        return s.substring(s.indexOf("=") + 2, s.length() - 1);
      }
    }
    return "";
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {    
    
    File fileImages = new File(request.getServletContext().getRealPath("").concat(File.separator).concat(PATH_FILES));
    String[] listImages;
    listImages = fileImages.list();

    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet ImageManagerServlet</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Links de imagenes</h1><br>");
      for (String item : listImages) {                              
        out.println("<a href=\"" + request.getContextPath().concat("/").concat(PATH_FILES).concat("/").concat(item) + "\">" + item + "</a><br>");       
      }
      out.println("</body>");
      out.println("</html>");
    }
   
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

}
