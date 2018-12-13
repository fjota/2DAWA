package es.cifpcm.miali.data;

import es.cifpcm.miali.model.product.ProductOffer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Josué Ramírez
 */
public class ProductOfferDaoImpl implements ProductOfferDao {

  private final Logger logger = LoggerFactory.getLogger(ProductOfferDaoImpl.class);

  private DaoFactory df;

  public ProductOfferDaoImpl() {
    df = DaoFactory.getInstance();
  }

  @Override
  public List<ProductOffer> selectAll() {
    List<ProductOffer> listProductOffer = new ArrayList<>();
    PreparedStatement preparedStatement = null;
    Connection conn = null;
    try {
      conn = df.getConnection();
      String slq = "SELECT * FROM productoffer";
      preparedStatement = conn.prepareStatement(slq);
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        listProductOffer.add(new ProductOffer(rs.getInt(1), rs.getString(2), rs.getInt(3),
                rs.getString(4), rs.getInt(5), rs.getInt(6)));
      }
    } catch (SQLException ex) {
      logger.error(ProductOfferDaoImpl.class.getName() + " " + ex.getMessage());
    } finally {
      try {
        if (!conn.isClosed()) {
          conn.close();
        }
      } catch (SQLException ex) {
        logger.error(MunicipiosDaoImpl.class.getName() + " " + ex.getMessage());
      }
    }

    return listProductOffer;
  }
}
