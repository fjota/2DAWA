package es.cifpcm.miali.buscador;

import es.cifpcm.miali.common.MasterDataBean;
import es.cifpcm.miali.model.Municipios;
import es.cifpcm.miali.model.Provincias;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Josue Ramirez
 */
@Named(value = "productSearchBean")
@RequestScoped
public class ProductSearchBean {

  private int id_Provincia;
  private int id_Municipio;

  @Inject
  MasterDataBean masterDataBean;

  private List<Municipios> listMunicipios;

  @PostConstruct
  public void init() {
    this.listMunicipios = masterDataBean.getMunicipios();
  }

  /**
   * Creates a new instance of ProductSearchBean
   */
  public ProductSearchBean() {
  }

  public List<Provincias> getProvincias() {
    return masterDataBean.getProvincias();
  }

  public List<Municipios> getMunicipios() {
    return this.listMunicipios;
  }

  public void onCboProvinciasChange() {
    try {
      List<Municipios> filterMunicipios = masterDataBean.getMunicipios().stream().
              filter(m -> m.getIdProvincia() == this.getId_Provincia()).collect(Collectors.toList());      
      listMunicipios = filterMunicipios;
    } catch (NullPointerException e) {
      listMunicipios = masterDataBean.getMunicipios();
    }
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
