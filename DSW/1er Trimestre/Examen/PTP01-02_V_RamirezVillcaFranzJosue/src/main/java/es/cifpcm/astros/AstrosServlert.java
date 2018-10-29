package es.cifpcm.astros;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Franz Josue Ramirez Villca
 */
public class AstrosServlert extends HttpServlet {

  private final Logger logger = LoggerFactory.getLogger(AstrosServlert.class);  

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    
    logger.info("Entrando en el ProcessRequest: " + request.getContextPath());

    //Obteniendo las imagenes
    String directorioImagenes = "Pictures";
    File imagenes = new File(request.getServletContext().getRealPath("").concat(File.separator).concat(directorioImagenes));
    String[] listaImagenes;
    listaImagenes = imagenes.list();

    //Creando el calendario
    GregorianCalendar calendario = new GregorianCalendar();
    SimpleDateFormat formateoFecha = new SimpleDateFormat("d MMMMM YYYY", Locale.forLanguageTag("es-ES"));
    String fechaActual = formateoFecha.format(calendario.getTime());

    //Obteniendo el valor enviado desde el formulario
    String universo = request.getParameter("universo");
    if ("nada".equals(universo) || universo == null) {
      //Enviamos a la pagina de error con el mensaje correspondiente
      request.setAttribute("mensajeError", "Tienes que seleccionar un astro");
      getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
      logger.info("Valores introducidos nulos: " + request.getContextPath());
    } else {      
      int indice = -1;
      while (indice == -1) {
        indice = SeleccionarImagen(universo, listaImagenes);
      }
    
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
      try {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Universo</title>");
        out.println("</head>");
        out.println("<body>");       
        out.println("<img src=" + request.getContextPath().concat("/").concat(directorioImagenes).concat("/").concat(listaImagenes[indice]) + " width=\"300\" heigth=\"300\" ></img>");
        out.println("<h1> Nombre imagen: " + listaImagenes[indice].substring(0, (listaImagenes[indice].length() - 4)) + " </h1>");
        out.println("<h1> Fecha Actual: " + fechaActual + " </h1>");
        out.println("</body>");
        out.println("</html>");
      } finally {
        out.close();
        logger.info("Saliendo del ProcessRequest: " + request.getContextPath());
      }
    }

  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    logger.info("Entrando en el GET METHOD: " + request.getContextPath());
    processRequest(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    logger.info("Entrando en el POST METHOD: " + request.getContextPath());
    processRequest(request, response);
  }

  private int SeleccionarImagen(String nombre, String[] listaImagenes) {
    Random rnd = new Random();
    int indice;
    indice = rnd.nextInt(listaImagenes.length);
    if (listaImagenes[indice].substring(0, 2).equals(nombre)) {
      return indice;
    }
    logger.info("No se encontro una conincidencia con el nombre la la imagen : ");
    return -1;    
    
  }

}
