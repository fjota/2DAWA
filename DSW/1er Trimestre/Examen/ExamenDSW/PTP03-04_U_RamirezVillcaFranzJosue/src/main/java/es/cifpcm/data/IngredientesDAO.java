package es.cifpcm.data;

import es.cifpcm.model.Ingredientes;
import java.util.List;

/**
 *
 * @author Josué Ramírez
 */
public interface IngredientesDAO {
  
  public List<Ingredientes> selectAll();
  
}
