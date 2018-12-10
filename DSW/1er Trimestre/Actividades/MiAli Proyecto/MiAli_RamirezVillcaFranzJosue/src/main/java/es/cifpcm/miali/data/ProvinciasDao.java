package es.cifpcm.miali.data;

import es.cifpcm.miali.model.Provincias;
import java.util.List;

/**
 *
 * @author Josué Ramírez
 */
public interface ProvinciasDao {
  
  public List<Provincias> selectAll();
  
}
