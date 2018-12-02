package es.cifpcm.web.bean;

import es.cifpcm.model.Actor;
import es.cifpcm.web.data.ActorDAO;
import es.cifpcm.web.data.ActorDAOImpl;
import java.sql.SQLException;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped; //Usar siempre estos paquetes 
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
  
  private ActorDAO actorDAO = new ActorDAOImpl();
      
  public ActorBean() {
  }

  public String save() {
    return "nombrevista";
  }
  
  public List<Actor> getActorList() {
    try {
      return actorDAO.selectAll();
    } catch (SQLException ex) {
      logger.error(ActorBean.class
              .getName() + " " + ex.getMessage());
    }
     return null;
  }
   
}
