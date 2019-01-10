package es.cifpcm.miali.common;

import es.cifpcm.miali.model.product.ProductOffer;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Josué Ramírez
 */
@Named(value = "addProductOffer")
@ApplicationScoped
public class AddProductOffer {

  /**
   * Creates a new instance of AddProductOffer
   */
  public AddProductOffer() {
  }
  
  public String addProduct() {
    return "/addProduct.xhtml";
  }
}
