package es.cifpcm.euromillonramirezvillcafranzjosue;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.TreeSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Josué Ramírez
 */
public class ResultadosServlet extends HttpServlet {

  //Conbinacion creada por la maquina
  private final TreeSet<Integer> combinacionMaquina = new TreeSet();
  //Combinacion que nos da el usuario
  private final TreeSet<Integer> combinacionUsuario = new TreeSet();
  //Numero de acertos de los números
  private int aciertos = 0;

  @Override
  public void init()
          throws ServletException {
    super.init();
    Random rnd = new Random();
    int num = 0;
    while (combinacionMaquina.size() < 5) {
      num = rnd.nextInt(49) + 1;
      if (!combinacionMaquina.contains(num)) {
        combinacionMaquina.add(num);
      }
    }
  }

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    
    //Aqui almacenaremos los parametros que nos pasen
    String[] numeros;
    numeros = request.getParameterValues("numero");
   
  
    
    for (String numero : numeros) {
      if (!combinacionUsuario.contains(Integer.parseInt(numero))) {
        combinacionUsuario.add(Integer.parseInt(numero));
      } else {
        request.setAttribute("mensajeError", "Se han introducido dos o mas números iguales");
        getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);        
      }
    }
    
    
     /*
    for (String numero : numeros) {
      if (Integer.parseInt(numero) > 49 || Integer.parseInt(numero) < 1) {
        request.setAttribute("mensajeError", "Se han introducido dos o mas números iguales");
        getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);        
      }
    }*/

    doGet(request, response);
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

    for (Integer numero : combinacionMaquina) {
      if (combinacionUsuario.contains(numero)) {
        aciertos++;
      }         
    }

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    try {
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet ResultadosServlet</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Verificando</h1>");
      out.println("<p>Has acertado " + aciertos + " de 5 </p>");
      out.println("<p> La combinacion ganadora es: " + combinacionMaquina.toString() + "</p>");
      out.println("<p> La combinacion introducida es: " + combinacionUsuario.toString() + "</p>");
      if (aciertos == 5) {
         out.println("<p>Muy bien</p>");
      }
      out.println("</body>");
      out.println("</html>");
    } finally {
      out.close();
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

}
