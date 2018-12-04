package es.cifpcm.model;

/**
 *
 * @author Josué Ramírez
 */
public class TipoBases {
  
  private int idTipoBase;
  private String descripcion;

  public TipoBases() {
  }

  public TipoBases(int idTipoBase, String descripcion) {
    this.idTipoBase = idTipoBase;
    this.descripcion = descripcion;
  }

  public int getIdTipoBase() {
    return idTipoBase;
  }

  public void setIdTipoBase(int idTipoBase) {
    this.idTipoBase = idTipoBase;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }    
  
}
