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

/**
 *
 * @author Josué Ramírez
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)  // 50MB

public class UploadServlet extends HttpServlet {

  private static final String SAVE_DIR = "ficherosSubidos";

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    PrintWriter out = response.getWriter();

    String appPath = request.getServletContext().getRealPath("");
    String savePath = appPath + File.separator + SAVE_DIR;

    File fileSaverDir = new File(savePath);
    if (!fileSaverDir.exists()) {
      fileSaverDir.mkdir();
    }

    for (Part part : request.getParts()) {
      String fileName = ExtractFileName(part);
      fileName = new File(fileName).getName();
      part.write(savePath + File.separator + fileName);
      out.println(savePath + File.separator + fileName);
    }

    request.setAttribute("message", "Upload has been done successfully!");
    getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
  }

  private String ExtractFileName(Part part) {
    String contentDisp = part.getHeader("content-disposition");
    String[] items = contentDisp.split(";");
    for (String s : items) {
      if (s.trim().startsWith("filename")) {
        return s.substring(s.indexOf("=") + 2, s.length() - 1);
      }
    }

    return "";
  }

}
