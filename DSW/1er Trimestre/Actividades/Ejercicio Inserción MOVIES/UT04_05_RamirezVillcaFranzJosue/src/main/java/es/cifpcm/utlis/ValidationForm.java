package es.cifpcm.utlis;

/**
 *
 * @author Josue Ramirez
 */
public class ValidationForm {

  /**
   * Check if the object is Null or void
   *
   * @param value
   * @return
   *
   */
  public static boolean isNullOrBlank(Object value) {
    return (value == null) || "".equals(value.toString().trim());
  }

  /**
   * Check if the object is Null or empty
   *
   * @param value
   * @return
   *
   */
  /*public static boolean isNullOrEmpty(Collection<?> value) {
    return (value == null) || value.isEmpty();
  }*/

}
