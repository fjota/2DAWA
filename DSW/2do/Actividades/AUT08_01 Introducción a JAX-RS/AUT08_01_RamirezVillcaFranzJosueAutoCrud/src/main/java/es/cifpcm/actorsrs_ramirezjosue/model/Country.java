package es.cifpcm.actorsrs_ramirezjosue.model;
// Generated 21-ene-2019 8:38:53 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Country generated by hbm2java
 */
@Entity
@Table(name="country"
    ,catalog="sakila"
)
@XmlRootElement
public class Country  implements java.io.Serializable {


     private Short countryId;
     private String country;
     private Date lastUpdate;
     private Set<City> cities = new HashSet<City>(0);

    public Country() {
    }

	
    public Country(String country, Date lastUpdate) {
        this.country = country;
        this.lastUpdate = lastUpdate;
    }
    public Country(String country, Date lastUpdate, Set<City> cities) {
       this.country = country;
       this.lastUpdate = lastUpdate;
       this.cities = cities;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="country_id", unique=true, nullable=false)
    public Short getCountryId() {
        return this.countryId;
    }
    
    public void setCountryId(Short countryId) {
        this.countryId = countryId;
    }

    
    @Column(name="country", nullable=false, length=50)
    public String getCountry() {
        return this.country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_update", nullable=false, length=19)
    public Date getLastUpdate() {
        return this.lastUpdate;
    }
    
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="country")
    public Set<City> getCities() {
        return this.cities;
    }
    
    public void setCities(Set<City> cities) {
        this.cities = cities;
    }




}


