package es.cifpcm.miali.model;
// Generated 18-dic-2018 11:53:24 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Municipios generated by hbm2java
 */
@Entity
@Table(name="municipios"
    ,catalog="mialidb"
)
public class Municipios  implements java.io.Serializable {


     private Short idMunicipio;
     private Provincias provincias;
     private int codMunicipio;
     private int dc;
     private String nombre;

    public Municipios() {
    }

    public Municipios(Provincias provincias, int codMunicipio, int dc, String nombre) {
       this.provincias = provincias;
       this.codMunicipio = codMunicipio;
       this.dc = dc;
       this.nombre = nombre;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id_municipio", unique=true, nullable=false)
    public Short getIdMunicipio() {
        return this.idMunicipio;
    }
    
    public void setIdMunicipio(Short idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_provincia", nullable=false)
    public Provincias getProvincias() {
        return this.provincias;
    }
    
    public void setProvincias(Provincias provincias) {
        this.provincias = provincias;
    }

    
    @Column(name="cod_municipio", nullable=false)
    public int getCodMunicipio() {
        return this.codMunicipio;
    }
    
    public void setCodMunicipio(int codMunicipio) {
        this.codMunicipio = codMunicipio;
    }

    
    @Column(name="DC", nullable=false)
    public int getDc() {
        return this.dc;
    }
    
    public void setDc(int dc) {
        this.dc = dc;
    }

    
    @Column(name="nombre", nullable=false, length=100)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }




}

