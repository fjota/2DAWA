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

 
  @WebMethod(operationName = "hello")
  public String hello(@WebParam(name = "name") String txt) {
    return "Hello " + txt + " !";
  }
  
  @WebMethod(operationName = "doble")
  public int doble(@WebParam(name = "name") int number) {
    return number*2;
  }
}