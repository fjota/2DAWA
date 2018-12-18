package es.cifpcm.miali.common;

import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Josué Ramírez
 */
@ManagedBean
@Named(value = "productCartBean")
@ViewScoped
public class ProductCartBean implements Serializable {

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
  

  public void increment() {
    number++;
  }

}
