package es.cifpcm.miali.buscador;

import es.cifpcm.miali.common.MasterDataBean;
import es.cifpcm.miali.model.Municipios;
import es.cifpcm.miali.model.Provincias;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author Josue Ramirez
 */
@Named(value = "productSearchBean")
@RequestScoped
public class ProductSearchBean {
  
  private int id_Provincia;
  private int id_Municipio = 00000;
    
  MasterDataBean masterDataBean = new MasterDataBean();

  /**
   * Creates a new instance of ProductSearchBean
   */
  public ProductSearchBean() {
  }
  
  public List<Provincias> getProvincias() {
    return masterDataBean.getProvincias();
  }
  
  public List<Municipios> getMunicipios() {
    return masterDataBean.getMunicipios();
  }
  
  public void onCboProvinciasChange() {
    
  }

  public int getId_Provincia() {
    return id_Provincia;
  }

  public void setId_Provincia(int id_Provincia) {
    this.id_Provincia = id_Provincia;
  }

  public int getId_Municipio() {
    return id_Municipio;
  }

  public void setId_Municipio(int id_Municipio) {
    this.id_Municipio = id_Municipio;
  }
  
  
}
