package es.cifpcm.miali.data;

import es.cifpcm.miali.model.product.ProductOffer;
import java.util.List;

/**
 *
 * @author Josué Ramírez
 */
public interface ProductOfferDao {
  
  public List<ProductOffer> selectAll();
  
}
