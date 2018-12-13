package es.cifpcm.miali.common;

import es.cifpcm.miali.data.MunicipiosDao;
import es.cifpcm.miali.data.MunicipiosDaoImpl;
import es.cifpcm.miali.data.ProductOfferDao;
import es.cifpcm.miali.data.ProductOfferDaoImpl;
import es.cifpcm.miali.data.ProvinciasDao;
import es.cifpcm.miali.data.ProvinciasDaoImpl;
import es.cifpcm.miali.model.Municipios;
import es.cifpcm.miali.model.Provincias;
import es.cifpcm.miali.model.product.ProductOffer;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Josue Ramirez
 */
@Named(value = "masterDataBean")
@ApplicationScoped
public class MasterDataBean {

  private MunicipiosDao municipiosDaoImpl = new MunicipiosDaoImpl();
  private ProvinciasDao provinciasDaoImpl = new ProvinciasDaoImpl();
  private ProductOfferDao productOfferDaoImpl = new ProductOfferDaoImpl();

  /**
   * Creates a new instance of MasterDataBean
   */
  public MasterDataBean() {
  }

  public List<Provincias> getProvincias() {
    return provinciasDaoImpl.selectAll();
  }

  public List<Municipios> getMunicipios() {
    return municipiosDaoImpl.selectAll();
  }

  public List<ProductOffer> getProducts() {
    return productOfferDaoImpl.selectAll();
  }

}
