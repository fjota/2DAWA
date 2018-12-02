package es.cifpcm.model;

/**
 *
 * @author Josue Ramirez
 */
public class Categories {
  
  private int idCategory ;
  private String category;

  public Categories() {
  }

  public Categories(int idCategory, String category) {
    this.idCategory = idCategory;
    this.category = category;
  }

  public int getIdCategory() {
    return idCategory;
  }

  public void setIdCategory(int idCategory) {
    this.idCategory = idCategory;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }  
  
}
