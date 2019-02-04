package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Bomber
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

  @Override
  public Set<Class<?>> getClasses() {
    Set<Class<?>> resources = new java.util.HashSet<>();
    addRestResourceClasses(resources);
    return resources;
  }

  /**
   * Do not modify addRestResourceClasses() method.
   * It is automatically populated with
   * all resources defined in the project.
   * If required, comment out calling this method in getClasses().
   */
  private void addRestResourceClasses(Set<Class<?>> resources) {
    resources.add(es.cifpcm.actorsrs_ramirezjosue.service.ActorFacadeREST.class);
    resources.add(es.cifpcm.actorsrs_ramirezjosue.service.AddressFacadeREST.class);
    resources.add(es.cifpcm.actorsrs_ramirezjosue.service.CategoryFacadeREST.class);
    resources.add(es.cifpcm.actorsrs_ramirezjosue.service.CityFacadeREST.class);
    resources.add(es.cifpcm.actorsrs_ramirezjosue.service.CountryFacadeREST.class);
    resources.add(es.cifpcm.actorsrs_ramirezjosue.service.CustomerFacadeREST.class);
    resources.add(es.cifpcm.actorsrs_ramirezjosue.service.FilmActorFacadeREST.class);
    resources.add(es.cifpcm.actorsrs_ramirezjosue.service.FilmCategoryFacadeREST.class);
    resources.add(es.cifpcm.actorsrs_ramirezjosue.service.FilmFacadeREST.class);
    resources.add(es.cifpcm.actorsrs_ramirezjosue.service.FilmTextFacadeREST.class);
    resources.add(es.cifpcm.actorsrs_ramirezjosue.service.InventoryFacadeREST.class);
    resources.add(es.cifpcm.actorsrs_ramirezjosue.service.LanguageFacadeREST.class);
    resources.add(es.cifpcm.actorsrs_ramirezjosue.service.PaymentFacadeREST.class);
    resources.add(es.cifpcm.actorsrs_ramirezjosue.service.RentalFacadeREST.class);
    resources.add(es.cifpcm.actorsrs_ramirezjosue.service.StaffFacadeREST.class);
    resources.add(es.cifpcm.actorsrs_ramirezjosue.service.StoreFacadeREST.class);
    resources.add(es.cifpcm.actorsrs_ramirezjosue.services.rest.ActorRest.class);
  }
  
}
