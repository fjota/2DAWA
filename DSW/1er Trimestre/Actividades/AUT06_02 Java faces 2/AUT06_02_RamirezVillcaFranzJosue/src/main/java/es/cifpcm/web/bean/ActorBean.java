package es.cifpcm.web.bean;

import es.cifpcm.model.Actor;
import es.cifpcm.web.data.ActorDAO;
import es.cifpcm.web.data.ActorDAOImpl;
import java.sql.SQLException;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped; //Usar siempre estos paquetes 
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Size;
import java.lang.NullPointerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Josué Ramírez
 */
@Named(value = "actorBean")
@RequestScoped
public class ActorBean extends Actor {

  private final Logger logger = LoggerFactory.getLogger(ActorBean.class);

  private final ActorDAO actorDAO = new ActorDAOImpl();

  public ActorBean() {
  }

  public String save() {
    try {
      insertActor();
      return "actorDetail";
    } catch (NullPointerException ex) {
      logger.error(ActorBean.class.getName() + " " + ex.getMessage());
      error();
      return "/error";
    }
  }

  public List<Actor> getActorList() {
    try {
      return actorDAO.selectAll();
    } catch (SQLException ex) {
      logger.error(ActorBean.class.getName() + " " + ex.getMessage());
    }
    return null;
  }

  public Actor insertActor()
          throws NullPointerException {
    try {
      Actor actor = actorDAO.insert(new Actor(0, this.getFirst_name(), this.getLast_name(), this.getLast_update()));
      this.setActor_id(actor.getActor_id());
      this.setLast_update(actor.getLast_update());
      return actor;
    } catch (SQLException ex) {
      logger.error(ActorBean.class.getName() + " " + ex.getMessage());
      return null;
    }
  }

  public void error() {
    FacesContext.getCurrentInstance().addMessage("MessageId", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error de inserción"));
  }

  @Size(min = 1, message = "Apellidos no puede estar vacio")
  @Override
  public String getLast_name() {
    return super.getLast_name();
  }

  @Size(min = 1, message = "Nombre no puede estar vacio")
  @Override
  public String getFirst_name() {
    return super.getFirst_name();
  }

}
