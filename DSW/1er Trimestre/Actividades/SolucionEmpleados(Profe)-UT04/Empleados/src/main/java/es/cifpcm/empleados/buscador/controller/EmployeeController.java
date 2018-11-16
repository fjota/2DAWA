/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.empleados.buscador.controller;

import es.cifpcm.data.DaoFactory;
import es.cifpcm.data.DaoFactoryConfig;
import es.cifpcm.empleados.buscador.data.EmployeeDao;
import es.cifpcm.empleados.buscador.model.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ResourceBundle;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Fer
 */
@WebServlet(name = "EmployeeControllerServlet",
        urlPatterns = {"/employeeController"},
        initParams = @WebInitParam(name = "app.config", value = "empleados"))
public class EmployeeController extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    private DaoFactoryConfig dfc;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        String configBundleName = config.getInitParameter("app.config");
        ResourceBundle rb = ResourceBundle.getBundle(configBundleName);

        this.dfc = new DaoFactoryConfig();
        dfc.setConnectionUrl(rb.getString("database.url"));
        dfc.setDbUser(rb.getString("database.user"));
        dfc.setDbPassword(rb.getString("database.password"));
        dfc.setDriverClassName(rb.getString("database.driver"));

        // Creo la fábrica de objetos de acceso a datos
        DaoFactory.createInstance(dfc);
    }

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

        logger.debug("Entrando en doGet");

        SearchAction search = new SearchAction();
        List<Employee> employees = search.execute(request);

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Buscador de empleados</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"/Empleados/css/table.css\"/>");
            out.println("</head>");
            out.println("<body>");
            out.println("<table>");
            out.println("<thead>");
            out.println("<tr><th>Nº</th><th>Nombre</th><th>Fecha Nac.</th>"
                    + "<th>Fecha cont.</th><th>-</th></tr>");
            out.println("</thead>");
            out.println("<tbody>");

            for (Employee emp : employees) {
                out.println("<tr>");

                out.printf("<td>%s</td>\n", emp.getEmpNo());
                out.printf("<td>%s, %s</td>\n", emp.getLastName(),
                        emp.getFirstName());
                out.printf("<td>%s</td>\n", emp.getBirthDate());
                out.printf("<td>%s</td>\n", emp.getHireDate());

                out.println("</tr>");
            }

            out.println("</tbody>");
            out.println("</table>");

            out.println("</body>");
            out.println("</html>");
        }
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

        //TODO crear cookie con pageSize
        logger.debug("Entrando en doPost");

        throw new UnsupportedOperationException("doPost no implementado");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet de gestión de empleados";
    }

}
