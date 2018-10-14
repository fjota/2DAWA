package es.cifpcm.calendarioramirezvillcafranzjosue;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Josue Ramirez
 */
public class VerCalendarioServlet extends HttpServlet {

  /**
   * Procesa las peticiones de HTTP del método <code>GET</code>
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   * @throws java.lang.IllegalAccessException
   * @throws java.lang.NoSuchFieldException
   * @throws java.text.ParseException
   */
  protected void ProcesoPeticion(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, ParseException {

    //Almacena el nombre del mes
    String mes;
    //Almacenara las fechas que luego iremos formateando
    Date fecha;

    //Almacenara la fecha actual si no se pasa ningun parametro
    Date fechaActual;
    int diaActual = 0;

    GregorianCalendar calendario = new GregorianCalendar(Locale.forLanguageTag("es-ES"));

    //Formatean las fechas, Español e Ingles
    SimpleDateFormat sdf = new SimpleDateFormat("MMMMM", Locale.forLanguageTag("es-ES"));
    SimpleDateFormat sdfE = new SimpleDateFormat("MMMMM", Locale.forLanguageTag("en-EN"));

    //Obtenemos el mes del HTTP request o ponemos por defecto el mes actual   
    if (request.getParameter("mes") == null) {
      mes = sdf.format(calendario.getTime());
      fechaActual = calendario.getTime();
      
      //Obtenemos el dia de la fecha actual
      sdfE.applyPattern("dd");      
      diaActual = Integer.parseInt(sdfE.format(fechaActual));

    } else {
      mes = request.getParameter("mes");
    }

    //Pasa el mes en español a una fecha en ingles
    fecha = sdf.parse(mes);
    //Formatea la fecha para obtener solo el nombre del mes
    sdfE.applyPattern("MMMMM");
    mes = sdfE.format(fecha);

    //Obtenemos el numero del mes (comienza en 0)
    Object mesNumerico = calendario.getClass().getField(mes.toUpperCase()).get(mes);
    int numeroMes = Integer.parseInt(mesNumerico.toString());

    //Cambiamos los valores de MES por el que pasamos por parametros
    calendario.set(Calendar.MONTH, numeroMes);
    //Cambiamos el valor del dia por 1, que es el primer dia de un mes
    calendario.set(Calendar.DATE, 1);

    //Obtenemos el nombre de la semana
    sdfE.applyPattern("EEEE");
    String nombreSemana = sdfE.format(calendario.getTime());

    //Obtenemos el número de la semana
    Object semanaNumerica = calendario.getClass().getField(nombreSemana.toUpperCase()).get(nombreSemana);
    int numeroSemana = Integer.parseInt(semanaNumerica.toString());
    numeroSemana--;

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    try {
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"" + request.getContextPath() + "/css/estilos.css" + "\">");
      out.println("<title>Calendario Josue</title>");
      out.println("</head>");
      out.println("<body>");
      out.print(EscribeCalendario(calendario, numeroSemana, diaActual));
      out.println("</body>");
      out.println("</html>");
    } finally {
      out.close();
    }
  }

  /**
   * Maneja las peticiones HTTP del metodo <code>GET</code>.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    try {
      ProcesoPeticion(request, response);

    } catch (NoSuchFieldException ex) {
      Logger.getLogger(VerCalendarioServlet.class
              .getName()).log(Level.SEVERE, null, ex);

    } catch (IllegalArgumentException ex) {
      Logger.getLogger(VerCalendarioServlet.class
              .getName()).log(Level.SEVERE, null, ex);

    } catch (IllegalAccessException ex) {
      Logger.getLogger(VerCalendarioServlet.class
              .getName()).log(Level.SEVERE, null, ex);

    } catch (ParseException ex) {
      Logger.getLogger(VerCalendarioServlet.class
              .getName()).log(Level.SEVERE, null, ex);
    }
  }

  private String EscribeCalendario(GregorianCalendar calendario, int numeroSemana, int diaActual) {

    StringBuilder sb = new StringBuilder();
    int numDias = 1;
    int diaMes = calendario.getActualMaximum(Calendar.DAY_OF_MONTH);
    boolean podemosComenzar = false;

    sb.append("<div class=\"contenedor-calendario\">");
    sb.append("<table>");
    sb.append("<thead>");
    sb.append("<tr>");
    sb.append("<th> Lunes </th>");
    sb.append("<th> Martes </th>");
    sb.append("<th> Miercoles </th>");
    sb.append("<th> Jueves </th>");
    sb.append("<th> Viernes </th>");
    sb.append("<th> Sabado </th>");
    sb.append("<th> Domingo </th>");
    sb.append("</tr>");
    sb.append("</thead>");
    sb.append("<tbody>");
    while (numDias <= diaMes) {
      sb.append("<tr>");
      for (int j = 1; j <= 7; j++) {
        if (numDias > diaMes) {
          break;
        } else {
          if (!podemosComenzar) {
            if (j == numeroSemana) {
              podemosComenzar = true;
              if (numDias == diaActual) {
                sb.append("<td class=\"dia-actual\">").append(numDias).append("</td>");
                numDias++;
              } else {
                sb.append("<td>").append(numDias).append("</td>");
                numDias++;
              }
            } else {
              sb.append("<td>" + " " + "</td>");
            }
          } else {
            if (numDias == diaActual) {
              sb.append("<td class=\"dia-actual\">").append(numDias).append("</td>");
              numDias++;
            } else {
              sb.append("<td>").append(numDias).append("</td>");
              numDias++;
            }
          }
        }
      }
      sb.append("</tr>");

    }
    sb.append("</tbody>");
    sb.append("</table>");
    sb.append("</div>");

    return sb.toString();

  }

}
