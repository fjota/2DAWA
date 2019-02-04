package es.cifpcm.saklilaautorestweb.service;

import es.cifpcm.saklilaautorestweb.FilmActor;
import es.cifpcm.saklilaautorestweb.FilmActorPK;
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
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author Josué Ramírez
 */
@Stateless
@Path("es.cifpcm.saklilaautorestweb.filmactor")
public class FilmActorFacadeREST extends AbstractFacade<FilmActor> {

  @PersistenceContext(unitName = "es.cifpcm_SaklilaAutoRestWEB_war_1.0-SNAPSHOTPU")
  private EntityManager em;

  private FilmActorPK getPrimaryKey(PathSegment pathSegment) {
    /*
     * pathSemgent represents a URI path segment and any associated matrix parameters.
     * URI path part is supposed to be in form of 'somePath;actorId=actorIdValue;filmId=filmIdValue'.
     * Here 'somePath' is a result of getPath() method invocation and
     * it is ignored in the following code.
     * Matrix parameters are used as field names to build a primary key instance.
     */
    es.cifpcm.saklilaautorestweb.FilmActorPK key = new es.cifpcm.saklilaautorestweb.FilmActorPK();
    javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
    java.util.List<String> actorId = map.get("actorId");
    if (actorId != null && !actorId.isEmpty()) {
      key.setActorId(new java.lang.Short(actorId.get(0)));
    }
    java.util.List<String> filmId = map.get("filmId");
    if (filmId != null && !filmId.isEmpty()) {
      key.setFilmId(new java.lang.Short(filmId.get(0)));
    }
    return key;
  }

  public FilmActorFacadeREST() {
    super(FilmActor.class);
  }

  @POST
  @Override
  @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public void create(FilmActor entity) {
    super.create(entity);
  }

  @PUT
  @Path("{id}")
  @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public void edit(@PathParam("id") PathSegment id, FilmActor entity) {
    super.edit(entity);
  }

  @DELETE
  @Path("{id}")
  public void remove(@PathParam("id") PathSegment id) {
    es.cifpcm.saklilaautorestweb.FilmActorPK key = getPrimaryKey(id);
    super.remove(super.find(key));
  }

  @GET
  @Path("{id}")
  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public FilmActor find(@PathParam("id") PathSegment id) {
    es.cifpcm.saklilaautorestweb.FilmActorPK key = getPrimaryKey(id);
    return super.find(key);
  }

  @GET
  @Override
  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public List<FilmActor> findAll() {
    return super.findAll();
  }

  @GET
  @Path("{from}/{to}")
  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public List<FilmActor> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
