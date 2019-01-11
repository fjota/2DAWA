package es.cifpcm.miali.common;

import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Josué Ramírez
 */
@Named(value = "productCartBean")
@RequestScoped
public class ProductCartBean {

  /**
   * Creates a new instance of ProductCartBean
   */
  public ProductCartBean() {
  }

  private int number;

  public int getNumber() {    
    return number;
  }

  public void setNumber(int number) {    
    this.number = number;
  }
  

  public String increment() {
    this.number++;
    return "/index";
  }

}
