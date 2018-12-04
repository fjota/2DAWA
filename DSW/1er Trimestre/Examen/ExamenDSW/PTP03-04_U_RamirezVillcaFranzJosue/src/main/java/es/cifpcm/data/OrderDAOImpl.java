package es.cifpcm.data;

import es.cifpcm.datebase.ConnectionDB;
import es.cifpcm.model.Order;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Josué Ramírez
 */
public class OrderDAOImpl implements OrderDAO {

  private final Logger logger = LoggerFactory.getLogger(OrderDAOImpl.class);

  ConnectionDB connectionDB;

  public OrderDAOImpl() {
    connectionDB = new ConnectionDB();
  }

  @Override
  public boolean insertOrder(Order order) {
    PreparedStatement preparedStatement = null;
    try {
      String sql = "INSERT INTO pedidos (IdTipoBase, NumIngredientes, Precio) VALUES (?,?, ?)";
      preparedStatement = connectionDB.Connect().prepareStatement(sql);
      preparedStatement.setInt(1, order.getBaseType());
      preparedStatement.setInt(2, order.getIngredientCount());
      preparedStatement.setInt(3, order.getTotal());
      preparedStatement.executeUpdate();
      return true;
    } catch (SQLException ex) {
      logger.error(OrderDAOImpl.class.getName() + " " + ex.getMessage() + " " + "Error al insertar un pedido");
      return false;
    } finally {
      try {
        connectionDB.Close();
      } catch (SQLException ex) {
        logger.error(OrderDAOImpl.class.getName() + " " + ex.getMessage() + " "
                + "Error al cerrar la conexion con la bese de datos");
      }
    }
  }

  @Override
  public String getIngredientById(Integer id) {
    PreparedStatement preparedStatement = null;
    String description = "";
    try {
      String sql = "SELECT Descripcion FROM ingredients WHERE IdIngrediente = ?";
      preparedStatement = connectionDB.Connect().prepareStatement(sql);
      preparedStatement.setInt(1, id);
      ResultSet rs = preparedStatement.executeQuery();
      if (rs.next()) {
        description = rs.getString(1);
      }
    } catch (SQLException ex) {
      logger.error(OrderDAOImpl.class.getName() + " " + ex.getMessage() + " " + "Error obtener descripcion");
    } finally {
      try {
        connectionDB.Close();
      } catch (SQLException ex) {
        logger.error(OrderDAOImpl.class.getName() + " " + ex.getMessage() + " "
                + "Error al cerrar la conexion con la bese de datos");
      }
    }
    return description;
  }

  @Override
  public String getTypeBaseById(Integer id) {
    PreparedStatement preparedStatement = null;
    String description = "";
    try {
      String sql = "SELECT Descripcion FROM tiposbases WHERE IdTipoBase = ?";
      preparedStatement = connectionDB.Connect().prepareStatement(sql);
      preparedStatement.setInt(1, id);
      ResultSet rs = preparedStatement.executeQuery();
      if (rs.next()) {
        description = rs.getString(1);
      }
    } catch (SQLException ex) {
      logger.error(OrderDAOImpl.class.getName() + " " + ex.getMessage() + " " + "Error obtener descripcion");
    } finally {
      try {
        connectionDB.Close();
      } catch (SQLException ex) {
        logger.error(OrderDAOImpl.class.getName() + " " + ex.getMessage() + " "
                + "Error al cerrar la conexion con la bese de datos");
      }
    }
    return description;
  }

}
