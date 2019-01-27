package es.cifpcm.actorsrs_ramirezjosue.model;
// Generated 21-ene-2019 8:38:53 by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * FilmCategory generated by hbm2java
 */
@Entity
@Table(name="film_category"
    ,catalog="sakila"
)
@XmlRootElement
public class FilmCategory  implements java.io.Serializable {


     private FilmCategoryId id;
     private Category category;
     private Film film;
     private Date lastUpdate;

    public FilmCategory() {
    }

    public FilmCategory(FilmCategoryId id, Category category, Film film, Date lastUpdate) {
       this.id = id;
       this.category = category;
       this.film = film;
       this.lastUpdate = lastUpdate;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="filmId", column=@Column(name="film_id", nullable=false) ), 
        @AttributeOverride(name="categoryId", column=@Column(name="category_id", nullable=false) ) } )
    public FilmCategoryId getId() {
        return this.id;
    }
    
    public void setId(FilmCategoryId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="category_id", nullable=false, insertable=false, updatable=false)
    public Category getCategory() {
        return this.category;
    }
    
    public void setCategory(Category category) {
        this.category = category;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="film_id", nullable=false, insertable=false, updatable=false)
    public Film getFilm() {
        return this.film;
    }
    
    public void setFilm(Film film) {
        this.film = film;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_update", nullable=false, length=19)
    public Date getLastUpdate() {
        return this.lastUpdate;
    }
    
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }




}


