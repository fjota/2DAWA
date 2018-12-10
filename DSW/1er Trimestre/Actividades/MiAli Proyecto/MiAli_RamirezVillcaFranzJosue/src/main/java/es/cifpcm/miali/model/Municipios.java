package es.cifpcm.miali.model;

import java.io.Serializable;

/**
 *
 * @author Josué Ramírez
 */
public class Municipios implements Serializable {
  
  private int idMunicipio;
  private int idProvincia;
  private int codMunicipio;
  private int dc;
  private String nombre;

  public Municipios() {
  }

  public Municipios(int idMunicipio, int idProvincia, int codMunicipio, int dc, String nombre) {
    this.idMunicipio = idMunicipio;
    this.idProvincia = idProvincia;
    this.codMunicipio = codMunicipio;
    this.dc = dc;
    this.nombre = nombre;
  }

  public int getIdMunicipio() {
    return idMunicipio;
  }

  public void setIdMunicipio(int idMunicipio) {
    this.idMunicipio = idMunicipio;
  }

  public int getIdProvincia() {
    return idProvincia;
  }

  public void setIdProvincia(int idProvincia) {
    this.idProvincia = idProvincia;
  }

  public int getCodMunicipio() {
    return codMunicipio;
  }

  public void setCodMunicipio(int codMunicipio) {
    this.codMunicipio = codMunicipio;
  }

  public int getDc() {
    return dc;
  }

  public void setDc(int dc) {
    this.dc = dc;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }    
  
}
