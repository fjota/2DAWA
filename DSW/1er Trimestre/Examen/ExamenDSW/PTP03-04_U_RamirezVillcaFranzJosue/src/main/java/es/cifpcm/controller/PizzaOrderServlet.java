package es.cifpcm.controller;

import es.cifpcm.data.OrderDAO;
import es.cifpcm.data.OrderDAOImpl;
import es.cifpcm.model.Order;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.NullPointerException;

/**
 *
 * @author Josué Ramírez
 */
public class PizzaOrderServlet extends HttpServlet {

  private final Logger logger = LoggerFactory.getLogger(PizzaOrderServlet.class);
  OrderDAO orderDAO;

  @Override
  public void init() {
    orderDAO = new OrderDAOImpl();
  }

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    request.setAttribute("error", "La pagina que buscas no se encuentra disponible");
    request.getRequestDispatcher("error.jsp").forward(request, response);
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    try {
      processRequest(request, response);
    } catch (IOException | ServletException ex) {
      logger.error(PizzaOrderServlet.class.getName() + " " + ex.getMessage() + " "
              + "Se ha producido un error en el servlet, contactar con el administrador");
      request.setAttribute("error", "La pagina que buscas no se encuentra disponible");
      request.getRequestDispatcher("error.jsp").forward(request, response);
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    try {
      Order order = new Order();
      order.setBaseType(Integer.parseInt(request.getParameter("TipoBase")));
      int numIngredientes = 0;
      if (request.getParameterValues("ingredientes") != null) {
        numIngredientes = request.getParameterValues("ingredientes").length;
      } else {
        numIngredientes = 0;
      }
      order.setIngredientCount(numIngredientes);
      int precioTotal = Integer.parseInt(request.getParameter("TipoBase"));
      switch (precioTotal) {
        case 1:
          precioTotal = 3;
          break;
        case 2:
          precioTotal = 5;
          break;
        case 3:
          precioTotal = 8;
          break;
      }
      order.setTotal(precioTotal + (numIngredientes * 2));
      if (orderDAO.insertOrder(order)) {
        request.setAttribute("order", order);
        request.setAttribute("tipoBase", orderDAO.getTypeBaseById(order.getBaseType()));      
        request.setAttribute("ingredientes", 
                obtenerDescripcionIngredientes(request.getParameterValues("ingredientes"), numIngredientes));
        request.getRequestDispatcher("exito.jsp").forward(request, response);
      } else {
        request.setAttribute("error", "Se a producido un error al insertar el pedido");
        request.getRequestDispatcher("error.jsp").forward(request, response);
      }
    } catch (IOException | NumberFormatException | ServletException | NullPointerException ex) {
      logger.error(PizzaOrderServlet.class.getName() + " " + ex.getMessage() + " "
              + "Se ha producido un error en el servlet, contactar con el administrador");
      request.setAttribute("error", "Se ha producido un error inesperado");
      request.getRequestDispatcher("error.jsp").forward(request, response);
    }

  }

  /**
   * Almacena en una lista las descripciones correspondientes al ID de un ingrediente
   * @param ingredientes
   * @param numIngredientes
   * @return 
   */
  public List<String> obtenerDescripcionIngredientes(String[] ingredientes, int numIngredientes) {
    List<String> ingredientesList = new ArrayList<>();
    for (int i = 0; i < numIngredientes; i++) {
      ingredientesList.add(orderDAO.getIngredientById(Integer.parseInt(ingredientes[i])));
    }
    return ingredientesList;
  }

}
