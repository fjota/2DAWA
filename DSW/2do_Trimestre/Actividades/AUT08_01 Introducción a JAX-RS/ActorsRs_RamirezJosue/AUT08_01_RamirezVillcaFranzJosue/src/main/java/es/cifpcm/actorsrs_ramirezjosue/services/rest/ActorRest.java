package es.cifpcm.actorsrs_ramirezjosue.services.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Bomber
 */
@Path("actors")
public class ActorRest {
  
  @Context
  private UriInfo context;
  
  public ActorRest(){
    
  }
  
  @GET
  @Produces("text/html")
  public String read(){
    return "<html lang=\"en\"><body><h1>Hello, World!!</h1></body></html>";
  }
  
}
