package es.cifpcm.miali.data;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Josué Ramírez
 */
public class DaoFactory implements ConnectionProvider {

  private static final Logger LOGGER = LoggerFactory.getLogger(DaoFactory.class);

  private static DaoFactory instance;

  private DataSource ds;
  private DatabaseConfig dbCfg;

  private DaoFactory() {

    ResourceBundle rb = ResourceBundle.getBundle("database");

    try {
      InitialContext ctx = new InitialContext();
      dbCfg = new DatabaseConfig(rb.getString("database.name"),
              rb.getString("jdbc.datasource.name"));

      LOGGER.debug("Pidiendo datasource: {}", dbCfg.getDatasourceName());
      this.ds = (DataSource) ctx.lookup(dbCfg.getDatasourceName());
    } catch (NamingException ex) {
      LOGGER.error(null, ex);
    }
  }

  public static synchronized DaoFactory getInstance() {

    if (instance == null) {
      instance = new DaoFactory();
    }

    return instance;
  }

  @Override
  public Connection getConnection() {

    try {
      return ds.getConnection();
    } catch (SQLException ex) {
      LOGGER.error(null, ex);
      return null;
    }
  }

  public MunicipiosDao getMunicipiosDao() {

    return new MunicipiosDaoImpl();
  }

  public ProvinciasDao getProvinciasDao() {

    return new ProvinciasDaoImpl();
  }

}
