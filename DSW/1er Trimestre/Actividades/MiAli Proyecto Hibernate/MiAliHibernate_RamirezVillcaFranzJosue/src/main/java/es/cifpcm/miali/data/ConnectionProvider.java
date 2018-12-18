package es.cifpcm.miali.data;

import java.sql.Connection;

/**
 *
 * @author Josué Ramírez
 */
public interface ConnectionProvider {

  public Connection getConnection();
}
