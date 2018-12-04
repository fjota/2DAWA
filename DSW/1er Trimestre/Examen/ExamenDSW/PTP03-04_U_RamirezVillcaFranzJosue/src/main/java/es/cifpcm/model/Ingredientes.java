package es.cifpcm.model;

/**
 *
 * @author Josué Ramírez
 */
public class Ingredientes {
  
  private int idIngrediente;
  private String descripcion;

  public Ingredientes() {
  }

  public Ingredientes(int idIngrediente, String descripcion) {
    this.idIngrediente = idIngrediente;
    this.descripcion = descripcion;
  }

  public int getIdIngrediente() {
    return idIngrediente;
  }

  public void setIdIngrediente(int idIngrediente) {
    this.idIngrediente = idIngrediente;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }
  
}
