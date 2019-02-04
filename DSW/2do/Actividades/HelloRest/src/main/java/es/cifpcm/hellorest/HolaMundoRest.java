package es.cifpcm.hellorest;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Josué Ramírez
 */
@Path("holamundo")
public class HolaMundoRest {

  @Context
  private UriInfo context;

  
  public HolaMundoRest() {
  }

  @GET
  @Produces("text/html")
  public String getHtml() {
    return "<html lang=\"en\"><body><h1>Hola Mundo soy josue!!</h1></body></html>";
  }

 
}
