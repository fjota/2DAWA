package es.cifpcm.saklilaautorestweb.service;

import es.cifpcm.saklilaautorestweb.ActorInfo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Josué Ramírez
 */
@Stateless
@Path("es.cifpcm.saklilaautorestweb.actorinfo")
public class ActorInfoFacadeREST extends AbstractFacade<ActorInfo> {

  @PersistenceContext(unitName = "es.cifpcm_SaklilaAutoRestWEB_war_1.0-SNAPSHOTPU")
  private EntityManager em;

  public ActorInfoFacadeREST() {
    super(ActorInfo.class);
  }

  @POST
  @Override
  @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public void create(ActorInfo entity) {
    super.create(entity);
  }

  @PUT
  @Path("{id}")
  @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public void edit(@PathParam("id") String id, ActorInfo entity) {
    super.edit(entity);
  }

  @DELETE
  @Path("{id}")
  public void remove(@PathParam("id") String id) {
    super.remove(super.find(id));
  }

  @GET
  @Path("{id}")
  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public ActorInfo find(@PathParam("id") String id) {
    return super.find(id);
  }

  @GET
  @Override
  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public List<ActorInfo> findAll() {
    return super.findAll();
  }

  @GET
  @Path("{from}/{to}")
  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public List<ActorInfo> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
    return super.findRange(new int[]{from, to});
  }

  @GET
  @Path("count")
  @Produces(MediaType.TEXT_PLAIN)
  public String countREST() {
    return String.valueOf(super.count());
  }

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }
  
}
