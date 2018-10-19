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
    //El primer dia del mes en el calendario US empieza en dimingo
    if (numeroSemana == 1) {
      numeroSemana = 7;
    } else {
      numeroSemana--;
    }

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
      out.print(EscribeCalendario(calendario, numeroSemana, diaActual, numeroMes));
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
    PrintWriter out = response.getWriter();
    try {
      ProcesoPeticion(request, response);

    } catch (NoSuchFieldException ex) {
      out.write("<Mes sin definir");
      Logger.getLogger(VerCalendarioServlet.class
              .getName()).log(Level.SEVERE, null, ex);

    } catch (IllegalArgumentException ex) {
      out.write("<Mes sin definir");
      Logger.getLogger(VerCalendarioServlet.class
              .getName()).log(Level.SEVERE, null, ex);

    } catch (IllegalAccessException ex) {
      out.write("<Mes sin definir");
      Logger.getLogger(VerCalendarioServlet.class
              .getName()).log(Level.SEVERE, null, ex);

    } catch (ParseException ex) {
      out.write("<Mes sin definir");
      Logger.getLogger(VerCalendarioServlet.class
              .getName()).log(Level.SEVERE, null, ex);
    }
    out.close();
  }

  private String EscribeCalendario(GregorianCalendar calendario, int numeroSemana, int diaActual, int numeroMes) {

    StringBuilder sb = new StringBuilder();

    int numDias = 1;
    int diasMes = calendario.getActualMaximum(Calendar.DAY_OF_MONTH);
    boolean podemosComenzar = false;

    //Cambiamos al mes anterior para obtener los ultimos días
    numeroMes--;
    calendario.set(Calendar.MONTH, numeroMes);
    int diasMesAnterior = calendario.getActualMaximum(Calendar.DAY_OF_MONTH);
    diasMesAnterior -= numeroSemana;
    diasMesAnterior += 2;

    int diasMesSiguiente = 1;

    sb.append("<h1 class=\"titulo-calendario\">Calendario</h1>");
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
    while (numDias <= diasMes) {
      sb.append("<tr>");
      for (int j = 1; j <= 7; j++) {
        if (numDias > diasMes) {
          //Rellenara los dias del mes siguiente
          if (j <= 7) {
            sb.append("<td class=\"otros-meses\">").append(diasMesSiguiente).append("</td>");
            diasMesSiguiente++;
          } else {
            break;
          }
        } else {
          if (!podemosComenzar) {
            //Entrara si podemos empezar a escribir los dias del mes 
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
              //Escribe los dias el mes anterior si los tuviese
              sb.append("<td class=\"otros-meses\">").append(diasMesAnterior).append("</td>");
              diasMesAnterior++;
            }
          } else {
            //Escribe el dia actual con un estilo predeterminado
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
