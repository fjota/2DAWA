package es.cifpcm.model;

/**
 *
 * @author Josue Ramirez
 */
public class Movies {
  
  private int idMovies;
  private int idCategory;
  private String titulo;

  public Movies() {
  }

  public Movies(int idMovies, int idCategory, String titulo) {
    this.idMovies = idMovies;
    this.idCategory = idCategory;
    this.titulo = titulo;
  }

  public int getIdMovies() {
    return idMovies;
  }

  public void setIdMovies(int idMovies) {
    this.idMovies = idMovies;
  }

  public int getIdCategory() {
    return idCategory;
  }

  public void setIdCategory(int idCategory) {
    this.idCategory = idCategory;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }
  
}
