package es.cifpcm.miali.buscador;

import es.cifpcm.miali.model.Productoffer;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Josué Ramírez
 */
@Stateless
public class ProductofferFacade extends AbstractFacade<Productoffer> {

  @PersistenceContext(unitName = "es.cifpcm_MiAliHibernate_RamirezVillcaFranzJosue_war_1.0-SNAPSHOTPU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public ProductofferFacade() {
    super(Productoffer.class);
  }
  
}
