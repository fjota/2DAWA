package es.cifpcm.miali.model.product;

/**
 *
 * @author Josue Ramirez
 */
public class ProductOffer {
  
  private int productId;
  private String productName;
  private float productPrice;
  private String productPicture;
  private int idMunicipio;
  private int productStock;

  public ProductOffer() {
  }

  public ProductOffer(int productId, String productName, float productPrice, String productPicture, int idMunicipio, int productStock) {
    this.productId = productId;
    this.productName = productName;
    this.productPrice = productPrice;
    this.productPicture = productPicture;
    this.idMunicipio = idMunicipio;
    this.productStock = productStock;
  }

  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public float getProductPrice() {
    return productPrice;
  }

  public void setProductPrice(float productPrice) {
    this.productPrice = productPrice;
  }

  public String getProductPicture() {
    return productPicture;
  }

  public void setProductPicture(String productPicture) {
    this.productPicture = productPicture;
  }

  public int getIdMunicipio() {
    return idMunicipio;
  }

  public void setIdMunicipio(int idMunicipio) {
    this.idMunicipio = idMunicipio;
  }

  public int getProductStock() {
    return productStock;
  }

  public void setProductStock(int productStock) {
    this.productStock = productStock;
  }
  
  
  
}
