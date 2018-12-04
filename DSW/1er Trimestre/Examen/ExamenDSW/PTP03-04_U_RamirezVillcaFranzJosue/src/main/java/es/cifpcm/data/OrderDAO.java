package es.cifpcm.data;

import es.cifpcm.model.Order;

/**
 *
 * @author Josué Ramírez
 */
public interface OrderDAO {
  
  public boolean insertOrder(Order order);
  public String getIngredientById(Integer id);
  public String getTypeBaseById(Integer id);
  
}
