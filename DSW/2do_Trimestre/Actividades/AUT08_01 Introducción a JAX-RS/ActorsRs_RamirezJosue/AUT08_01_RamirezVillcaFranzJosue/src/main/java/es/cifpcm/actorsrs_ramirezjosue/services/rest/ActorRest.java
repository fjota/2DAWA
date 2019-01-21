package es.cifpcm.actorsrs_ramirezjosue.services.rest;

import com.google.gson.Gson;
import es.cifpcm.actorsrs_ramirezjosue.model.Actor;
import es.cifpcm.actorsrs_ramirezjosue.repository.ActorRepository;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Bomber
 */
@Path("actors")
public class ActorRest {

  @Context
  private UriInfo context;

  public ActorRest() {

  }

  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  public String findAll() {
    List<Actor> listActors = ActorRepository.findAll();
    String json = new Gson().toJson(listActors);
    return json;
  }
  
  @GET
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public String findOne(@PathParam("id") int id){
    String json = new Gson().toJson(ActorRepository.findOne(id));
    return json;
  }
  
  @POST
  @Path("/")
  public Response registerActor(@QueryParam("name") String name, @QueryParam("last_name") String lastName){
    Response res = ActorRepository.registerActor(name, lastName);
    return res;
  }

}
