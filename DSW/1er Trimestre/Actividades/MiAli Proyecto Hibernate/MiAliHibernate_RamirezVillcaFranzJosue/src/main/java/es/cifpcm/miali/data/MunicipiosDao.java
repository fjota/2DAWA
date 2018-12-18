package es.cifpcm.miali.data;

import es.cifpcm.miali.model.Municipios;
import java.util.List;

/**
 *
 * @author Josué Ramírez
 */
public interface MunicipiosDao {
  
  public List<Municipios> selectAll();
  
}
