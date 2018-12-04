package es.cifpcm.ejercicio1;

/**
 *
 * @author Josué Ramírez
 */
public class DaoFactoryImpl implements DaoFactory {

  String diverName;
  
  @Override
  public ProductDao getProductDao() {
    return new ProductDao();
  }
  
  public void myPrivateOp(Integer num) {    
  }
  
}
