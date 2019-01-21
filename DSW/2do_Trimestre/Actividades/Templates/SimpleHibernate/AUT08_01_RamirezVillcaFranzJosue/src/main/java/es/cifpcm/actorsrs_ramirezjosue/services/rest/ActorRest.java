package es.cifpcm.actorsrs_ramirezjosue.services.rest;

import es.cifpcm.actorsrs_ramirezjosue.model.Actor;
import es.cifpcm.actorsrs_ramirezjosue.repository.ActorRepository;
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
    //return ActorRepository.getAll().toString();
    return ActorRepository.getAll().toString();
    /*ActorRepository actorRepository = new  ActorRepository();
    StringBuilder sb = new StringBuilder();
    
    for (Actor element : actorRepository.getAll()) {
      sb.append("<p>").append(element.getActorId()).append(" ").append(element.getFirstName()).append(" ").append(element.getLastName()).append(" ").append(element.getLastUpdate()).append("</p>");
    }
    return sb.toString();*/
    //return "<h1>hola</h1>";
  }
  
}
