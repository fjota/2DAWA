package es.cifpcm.data;


import es.cifpcm.model.TipoBases;
import java.util.List;

/**
 *
 * @author Josué Ramírez
 */
public interface TipoBasesDAO {
  
  public List<TipoBases> selectAll();
  
}
