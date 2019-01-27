package es.cifpcm.actorsrs_ramirezjosue.service;

import es.cifpcm.actorsrs_ramirezjosue.model.FilmCategory;
import es.cifpcm.actorsrs_ramirezjosue.model.FilmCategoryId;
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
@Path("es.cifpcm.actorsrs_ramirezjosue.model.filmcategory")
public class FilmCategoryFacadeREST extends AbstractFacade<FilmCategory> {

  @PersistenceContext(unitName = "es.cifpcm_ActorsRs_RamirezJosue_war_1.0-SNAPSHOTPU")
  private EntityManager em;

  private FilmCategoryId getPrimaryKey(PathSegment pathSegment) {
    /*
     * pathSemgent represents a URI path segment and any associated matrix parameters.
     * URI path part is supposed to be in form of 'somePath;filmId=filmIdValue;categoryId=categoryIdValue'.
     * Here 'somePath' is a result of getPath() method invocation and
     * it is ignored in the following code.
     * Matrix parameters are used as field names to build a primary key instance.
     */
    es.cifpcm.actorsrs_ramirezjosue.model.FilmCategoryId key = new es.cifpcm.actorsrs_ramirezjosue.model.FilmCategoryId();
    javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
    java.util.List<String> filmId = map.get("filmId");
    if (filmId != null && !filmId.isEmpty()) {
      key.setFilmId(new java.lang.Short(filmId.get(0)));
    }
    java.util.List<String> categoryId = map.get("categoryId");
    if (categoryId != null && !categoryId.isEmpty()) {
      key.setCategoryId(new java.lang.Byte(categoryId.get(0)));
    }
    return key;
  }

  public FilmCategoryFacadeREST() {
    super(FilmCategory.class);
  }

  @POST
  @Override
  @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public void create(FilmCategory entity) {
    super.create(entity);
  }

  @PUT
  @Path("{id}")
  @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public void edit(@PathParam("id") PathSegment id, FilmCategory entity) {
    super.edit(entity);
  }

  @DELETE
  @Path("{id}")
  public void remove(@PathParam("id") PathSegment id) {
    es.cifpcm.actorsrs_ramirezjosue.model.FilmCategoryId key = getPrimaryKey(id);
    super.remove(super.find(key));
  }

  @GET
  @Path("{id}")
  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public FilmCategory find(@PathParam("id") PathSegment id) {
    es.cifpcm.actorsrs_ramirezjosue.model.FilmCategoryId key = getPrimaryKey(id);
    return super.find(key);
  }

  @GET
  @Override
  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public List<FilmCategory> findAll() {
    return super.findAll();
  }

  @GET
  @Path("{from}/{to}")
  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public List<FilmCategory> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
