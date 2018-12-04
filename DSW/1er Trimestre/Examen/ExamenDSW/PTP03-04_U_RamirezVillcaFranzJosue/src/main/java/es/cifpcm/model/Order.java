package es.cifpcm.model;

/**
 *
 * @author Josué Ramírez
 */
public class Order {
  
  private int orderId;
  private int baseType;
  private int ingredientCount;
  private int total;

  public Order() {
  }

  public Order(int orderId, int baseType, int ingredientCount, int total) {
    this.orderId = orderId;
    this.baseType = baseType;
    this.ingredientCount = ingredientCount;
    this.total = total;
  }

  public int getOrderId() {
    return orderId;
  }

  public void setOrderId(int orderId) {
    this.orderId = orderId;
  }

  public int getBaseType() {
    return baseType;
  }

  public void setBaseType(int baseType) {
    this.baseType = baseType;
  }

  public int getIngredientCount() {
    return ingredientCount;
  }

  public void setIngredientCount(int ingredientCount) {
    this.ingredientCount = ingredientCount;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }
  
}
