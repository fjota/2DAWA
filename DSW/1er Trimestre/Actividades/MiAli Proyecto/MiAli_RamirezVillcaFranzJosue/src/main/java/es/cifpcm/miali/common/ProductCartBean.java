package es.cifpcm.miali.common;

import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author Josué Ramírez
 */
@Named(value = "productCartBean")
@ApplicationScoped
public class ProductCartBean implements Serializable {

  /**
   * Creates a new instance of ProductCartBean
   */
  public ProductCartBean() {
  }

  protected int number;

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }
  

  public void increment() {
    this.number++;
  }

}
