package es.cifpcm.hellosoap;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Josué Ramírez
 */
@WebService(serviceName = "EchoService")
public class EchoService {

  /**
   * This is a sample web service operation
   * @param txt
   * @return 
   */  
  @WebMethod(operationName = "hello")
  public String hello(@WebParam(name = "name") String txt) {
    return "Hello " + txt + " !";
  }
}
